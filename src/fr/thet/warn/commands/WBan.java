package fr.thet.warn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thet.warn.Main;
import fr.thet.warn.data.Permission;
import fr.thet.warn.sanction.Ban;

public class WBan implements CommandExecutor{
	
	private Main plugin;
	
	public WBan(Main plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg, String[] other) {
		if(s instanceof Player){
			Player p  = (Player) s;
			if(p.isOp() || p.hasPermission(Permission.permBan)){
				if(other.length > 1){
					if(plugin.getConfig().contains("staff." + other[0])){
						p.sendMessage("§cCe joueur ne peut pas être banni!");
					}else{
						Ban.BanOther1(other, other[0], p, plugin);
						p.sendMessage("§6Joueur banni");
					}
				}else{
			     	p.sendMessage("§c/warnban <Pseudo> <Raison>");
				
				}
			}else{
				p.sendMessage("§cPermission requise: §6" + Permission.permBan);
			}
			return true;
		}
		return false;
	}
}
