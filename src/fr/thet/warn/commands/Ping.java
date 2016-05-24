package fr.thet.warn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.thet.warn.data.Permission;

public class Ping implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg, String[] other) {
			if(s instanceof Player){
				Player p = (Player) s;
				if(p.hasPermission(Permission.permPingAJ) || p.isOp()){
					if(other.length == 1){
						boolean found = false;
						for(Player j : Bukkit.getOnlinePlayers()){
							if(j.getName().equalsIgnoreCase(other[0])){
								found = true;
							}
						}
						if(found == true){
							Player p2 = Bukkit.getPlayer(other[0]);
							CraftPlayer cp = (CraftPlayer) p2;
							p.sendMessage("§cPing de §6" + other[0] + "§c: " + cp.getHandle().ping);
						}else{
							p.sendMessage("§cLe joueur " + other[0] + " n'est pas connecté");
						}
					}else{
						CraftPlayer cp = (CraftPlayer) p;
						p.sendMessage("§cVotre ping: " + cp.getHandle().ping);
						p.sendMessage("§c/ping <Joueur>");
					}
				}else{
					CraftPlayer cp = (CraftPlayer) p;
					p.sendMessage("§cVotre ping: " + cp.getHandle().ping);
				}
				return true;
			}
		return false;
	}
	
}
