package fr.thet.warn.commands;

import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.thet.warn.Main;
import fr.thet.warn.data.Permission;

public class Log implements CommandExecutor{

	private Main plugin;
	
	public Log(Main plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg, String[] other) {
		if(s instanceof Player){
			Player p  = (Player) s;
			if(p.isOp() || p.hasPermission(Permission.permLog)){
				if(other.length == 1){
					String pname = other[0];
					FileConfiguration config = plugin.getConfig();
						Date d = new Date();
						
						p.sendMessage("§c===================================");
						p.sendMessage("§cJoueur " + pname);
						if(config.contains("ban."+ pname)){
							p.sendMessage("§cBanni Oui");
						}else{
							p.sendMessage("§cBanni Non");
						}
						if(config.contains("log."+ pname + ".banraison")){
							String raison = config.getString("log."+ pname + ".banraison");
						    String author = config.getString("log."+ pname + ".banauthor");
						    
							long time = config.getLong("log."+ pname + ".bandate");
							
							d.setTime(time);
							p.sendMessage("§cBanni le (Dernier) " + d.toLocaleString());
							p.sendMessage("§cBanni par (Dernier) " + author);
							p.sendMessage("§cBanni pour (Dernier) " + raison);
						}else{
							p.sendMessage("§cBanni le [JAMAIS]");
							p.sendMessage("§cBanni par N/C");
							p.sendMessage("§cBanni pour N/C");
						}
						if(config.contains("log."+ pname + ".debanauthor")){
							String st = config.getString("log."+ pname + ".debanauthor");
							long st2 = config.getLong("log."+ pname + ".debandate");
							Date da = new Date();
							da.setTime(st2);
							p.sendMessage("§cDébanni par " + st);
							p.sendMessage("§cDébanni le " + da.toLocaleString());
						}else{
							p.sendMessage("§cDébanni par N/C");
							p.sendMessage("§cDébanni le N/C");
						}
						p.sendMessage("§c===================================");
				}else{
					p.sendMessage("§c/log <Pseudo>");
				}
			}else{
				p.sendMessage("§cPermission requise: §6" + Permission.permLog);
			}
			return true;
		}
	return false;
	}

	
	
	
	
}
