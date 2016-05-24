package fr.thet.warn.manager;

import org.bukkit.command.CommandExecutor;

import fr.thet.warn.Main;
import fr.thet.warn.commands.Deban;
import fr.thet.warn.commands.FFTest;
import fr.thet.warn.commands.Log;
import fr.thet.warn.commands.Ping;
import fr.thet.warn.commands.WBan;

public class CommandManager {
	
	public static void init(Main plugin){
		CommandExecutor deban = new Deban(plugin);
		
		CommandExecutor ban = new WBan(plugin);
		
		CommandExecutor log = new Log(plugin);
		
		CommandExecutor ping = new Ping();
		
		CommandExecutor ff = new FFTest(plugin);
		
		plugin.getCommand("warndeban").setExecutor(deban);
		plugin.getCommand("log").setExecutor(log);
		plugin.getCommand("warnban").setExecutor(ban);
		plugin.getCommand("ping").setExecutor(ping);
		plugin.getCommand("warnff").setExecutor(ff);
		
		System.out.println("CmdManager initialisé");
	}
	
}
