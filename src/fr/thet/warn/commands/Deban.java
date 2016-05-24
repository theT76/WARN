package fr.thet.warn.commands;

import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.thet.warn.Main;
import fr.thet.warn.data.Permission;

public class Deban implements CommandExecutor{

	private Main plugin;
	
	public Deban(Main plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg, String[] other) {
		if(s instanceof Player){
			Player p  = (Player) s;
			if(p.isOp() || p.hasPermission(Permission.permDeban)){
				if(other.length == 1){
					String pname = other[0];
					FileConfiguration config = plugin.getConfig();
					if(config.contains("ban." + pname)){
						Date d = new Date();
						long ntime = d.getTime();
						String raison = config.getString("log."+ pname + ".banraison");
					    String author = config.getString("log."+ pname + ".banauthor");
						long time = config.getLong("log."+ pname + ".bandate");
						d.setTime(time);
						p.sendMessage("§cJoueur " + pname + " débanni");
						p.sendMessage("§c===================================");
						p.sendMessage("§cJoueur " + pname);
						p.sendMessage("§cBanni le (Dernier) " + d.toLocaleString());
						p.sendMessage("§cBanni par (Dernier) " + author);
						p.sendMessage("§cBanni pour (Dernier) " + raison);
						p.sendMessage("§cDébanni par Vous");
						d.setTime(ntime);
						p.sendMessage("§cDébanni le " + d.toLocaleString());
						p.sendMessage("§c===================================");
						config.set("log."+ pname + ".debanauthor", p.getName());
						config.set("log."+ pname + ".debandate", ntime);
						config.set(("ban." + pname), null);
						plugin.saveConfig();
						plugin.reloadConfig();
					}else{
						p.sendMessage("§cCe joueur n'est pas banni.");
						p.sendMessage("§c/log " + pname + " pour voir ses antécédents.");
					}
				}else{
					p.sendMessage("§c/log <Pseudo>");
				}
			}else{
				p.sendMessage("§cPermission requise: §6" + Permission.permDeban);
			}
		}
		return true;
	}
	
	

}
