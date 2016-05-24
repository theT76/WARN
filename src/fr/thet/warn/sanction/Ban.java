package fr.thet.warn.sanction;

import java.util.Date;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Player;

import fr.thet.warn.Main;
import fr.thet.warn.data.Permission;
import fr.thet.warn.data.PlayerData;
import fr.thet.warn.util.FireworkEffectPlayer;

public class Ban {

	@SuppressWarnings("deprecation")
	public static void BanPlayer(String raison, Player p, String author, Main plugin){
		Random r = new Random();
		//TODO PingCheck
		FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(Color.PURPLE).withFade(Color.BLUE).with(Type.BURST).trail(false).build();
		long time = System.currentTimeMillis();
		if(raison.equalsIgnoreCase("Cheat")){
			if(PlayerData.lastPacketOverload.containsKey(p)){
				long lpo = PlayerData.lastPacketOverload.get(p);
				long diff = time - lpo;
				if(PlayerData.lastPacketOverload2.contains(p)){
					if(diff <= 1000){
						PlayerData.lastPacketOverload.remove(p);
						PlayerData.lastPacketOverload2.remove(p);
					}else{
						PlayerData.lastPacketOverload.remove(p);
						PlayerData.lastPacketOverload2.remove(p);
						PlayerData.lastPacketOverload.put(p, time);
						return;
					}
				}else{
					if(diff <= 500){
						Warning.WarningOther(p, raison);
						PlayerData.lastPacketOverload2.add(p);
					}else{
						PlayerData.lastPacketOverload.remove(p);
						PlayerData.lastPacketOverload.put(p, time);
						return;
					}
				}
			}else{
				PlayerData.lastPacketOverload.put(p, time);
				return;
			}
		}
		if(p.isOp()){
			p.sendMessage("§c§o[AntiCheat]§7§o " + raison);
			FireworkEffectPlayer.spawn(p.getLocation().add(0, 0.5, 0), effect, Bukkit.getOnlinePlayers());
			return;
		}
		PlayerData.lastban = System.currentTimeMillis();
		if(p.hasPermission(Permission.permBypass)) return;
		for(Player j : Bukkit.getOnlinePlayers()){
			j.sendMessage("§c§l[WARN] §c" + p.getName() + " a été banni pour §4" + raison);
		}
		FireworkEffectPlayer.spawn(p.getLocation(), effect, Bukkit.getOnlinePlayers());;
		p.getWorld().strikeLightning(p.getLocation());
		plugin.getConfig().set("ban." + p.getName(), raison);
		Date d = new Date();
		plugin.getConfig().set("log."+ p.getName() + ".bandate" , d.getTime());
		plugin.getConfig().set("log."+ p.getName() + ".banraison", raison);
		plugin.getConfig().set("log."+ p.getName() + ".banauthor", author);
		plugin.saveConfig();
		plugin.reloadConfig();
		p.kickPlayer("§c§lBanni Pour §4" + raison);
	}
	
	public static void BanOther1(String[] args, String banned, Player p2, Main plugin){
		String pname = args[0];
		String raison = "";
		for(String s : args){
			if(!s.equals(pname)){
				raison = raison + " " + s;
			}
		}
		BanOther(raison, banned, p2.getName(), plugin);
	}
	
	@SuppressWarnings("deprecation")
	public static void BanOther(String raison, String p, String author, Main plugin){
		
		for(Player j : Bukkit.getOnlinePlayers()){
				j.sendMessage("§c§l[WARN] §c" + p + " a été banni par §4" + author + " §cpour §4" + raison);
				if(j.getName().equals(p)){
					j.kickPlayer(("§c§lBanni Par §4" + author +"§c§l Pour §4" + raison));
				}
		}
		plugin.getConfig().set("ban." + p, raison);
		Date d = new Date();
		plugin.getConfig().set("log."+ p + ".bandate" , d.getTime());
		plugin.getConfig().set("log."+ p + ".banraison", raison);
		plugin.getConfig().set("log."+ p + ".banauthor", author);
		plugin.saveConfig();
		plugin.reloadConfig();
	}
}
