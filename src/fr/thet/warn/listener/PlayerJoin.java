package fr.thet.warn.listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;

import com.captainbern.npclib.NPCManager;

import de.inventivegames.npc.NPC;
import de.inventivegames.npc.NPCLib;
import fr.thet.warn.Main;
import fr.thet.warn.data.PlayerData;
import fr.thet.warn.sanction.Ban;
import fr.thet.warn.util.NameGen;

public class PlayerJoin implements Listener {

	private Main plugin;
	
	public PlayerJoin(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		p.sendMessage("§7§o[WarnAntiCheat] §aActif");
		PlayerData.joined.add(p);
		//AntiFF
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				if(!p.isValid() || p == null) return;
				if(!p.isOnline()) return;
				Random r = new Random();
				int i = r.nextInt(10);
				if(i < 2){
					
					World world = p.getWorld();
					Location loc = p.getLocation();
					Block behind = loc.getBlock();
					int direction = (int)loc.getYaw();
					 
					if(direction < 0) {
					    direction += 360;
					    direction = (direction + 45) / 90;
					}else {
					    direction = (direction + 45) / 90;
					}
					 
					switch (direction) {
					    case 1:
					        behind = world.getBlockAt(behind.getX() + 2, behind.getY(), behind.getZ());
					        break;
					    case 2:
					        behind = world.getBlockAt(behind.getX(), behind.getY(), behind.getZ() + 2);
					        break;
					    case 3:
					        behind = world.getBlockAt(behind.getX() - 2, behind.getY(), behind.getZ());
					        break;
					    case 4:
					        behind = world.getBlockAt(behind.getX(), behind.getY(), behind.getZ() - 2);
					        break;
					    case 0:
					        behind = world.getBlockAt(behind.getX(), behind.getY(), behind.getZ() - 2);
					        break;
					    default:
					        break;
					}
					
					NPCManager.getNPCManager(plugin).spawnNPC(behind.getLocation(), NameGen.newName());
				}
		
		}}, 0, 20);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				
				if(!p.isValid() || p == null) return;
				if(!p.isOnline()) return;
				//NoFall
				
				if(p.isOnline() == false)return;
				if(p.isValid() == false) return;
				int packets = 0;
				if(PlayerData.joined.contains(p)){
					//p.sendMessage("§cJoin ByPass");
					PlayerData.GFlying.remove(p);
					PlayerData.Flying.remove(p);
					PlayerData.FlyToggle.remove(p);
					PlayerData.FlyNotToggle.remove(p);
				}
				if(PlayerData.GFlying.containsKey(p)){
					packets = packets + PlayerData.GFlying.get(p);
				}
				if(PlayerData.Flying.containsKey(p)){
					packets = packets + PlayerData.Flying.get(p);
				}
				if(packets >= 40 && !PlayerData.joined.contains(p)){
					//p.sendMessage("§cPackets: " + packets);
					if(!p.getGameMode().equals(GameMode.CREATIVE)){
						if(p.getAllowFlight() == false){
							Ban.BanPlayer("Cheat", p, "WARN", plugin);
						}
					}
				}
				
				
				//Fly
				
				int fly = 0;
				int ground = 0;
				if(PlayerData.FlyToggle.containsKey(p)){
					fly = fly + PlayerData.FlyToggle.get(p);
					
				}
				if(PlayerData.FlyNotToggle.containsKey(p)){
					ground = ground + PlayerData.FlyNotToggle.get(p);
					
				}
				if(PlayerData.GFlying.containsKey(p)){
					ground = ground + PlayerData.GFlying.get(p);
					
				}
				if(PlayerData.Flying.containsKey(p)){
					fly = fly + PlayerData.Flying.get(p);
					
				}
				if( fly > 21 && ground > 21){
					//p.sendMessage("§cFlyingPackets: " + fly);
					//p.sendMessage("§cOnGroundPackets: " + ground);
					if(!p.getGameMode().equals(GameMode.CREATIVE)){
						if(p.getAllowFlight() == false){
							Ban.BanPlayer("Cheat", p, "WARN", plugin);
						}
					}
				}
				PlayerData.FlyNotToggle.remove(p);
				PlayerData.FlyToggle.remove(p);
				PlayerData.Flying.remove(p);
				PlayerData.GFlying.remove(p);
				
				if(PlayerData.joined.contains(p)) PlayerData.joined.remove(p);
			}}, 0, 20);   
	}
	
}
