package fr.thet.warn.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import de.inventivegames.npc.NPC;
import de.inventivegames.npc.NPCLib;
import fr.thet.warn.Main;
import fr.thet.warn.data.PlayerData;
import fr.thet.warn.util.NameGen;

public class FFTest implements CommandExecutor{

	private Main plugin;
	
	public FFTest(Main plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg, String[] other) {
		if(s instanceof Player){
			final Player p = (Player) s;
			p.sendMessage("§cCheck dans §l2§c secondes.");
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					if(!p.isValid() || p == null) return;
					if(!p.isOnline()) return;
						if(PlayerData.fishy.contains(p)){
							PlayerData.fishy.remove(p);
						}
						if(PlayerData.fishy2.contains(p)){
							PlayerData.fishy2.remove(p);
						}
						if(PlayerData.fishy3.contains(p)){
							PlayerData.fishy3.remove(p);
						}				
						if(PlayerData.fishy.contains(p)){
							PlayerData.fishy.remove(p);
						}
						if(PlayerData.fishy2.contains(p)){
							PlayerData.fishy2.remove(p);
						}
						if(PlayerData.fishy4.contains(p)){
							PlayerData.fishy4.remove(p);
						}
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
						        behind = world.getBlockAt(behind.getX() +2, behind.getY(), behind.getZ());
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
						final NPC npc = NPCLib.spawnNPC(behind.getLocation().subtract(0, 1.3, 0), NameGen.newName());
						npc.setGravity(false);
						npc.setShownInList(false);
						npc.setFrozen(true);
						npc.setInvulnerable(false);
						BukkitScheduler sched = Bukkit.getScheduler();
						PlayerData.check.put(p, npc);
						sched.scheduleSyncDelayedTask(plugin, new Runnable() {

							@Override
							public void run() {
								npc.setShownInList(false);
								npc.getBukkitEntity().remove();
								npc.despawn();
								npc.getBukkitEntity().remove();
								if(PlayerData.check.containsKey(p)){
									PlayerData.check.remove(p);
								}
								if(PlayerData.fishy.contains(p)){
									PlayerData.fishy.remove(p);
								}
								if(PlayerData.fishy2.contains(p)){
									PlayerData.fishy2.remove(p);
								}
								if(PlayerData.fishy3.contains(p)){
									PlayerData.fishy3.remove(p);
								}				
								if(PlayerData.fishy.contains(p)){
									PlayerData.fishy.remove(p);
								}
								if(PlayerData.fishy2.contains(p)){
									PlayerData.fishy2.remove(p);
								}
								if(PlayerData.fishy4.contains(p)){
									PlayerData.fishy4.remove(p);
								}
							}}, 12);
					
				}
				
				}, 40);
			return true;
		}
		return false;
	}

}
