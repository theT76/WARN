package fr.thet.warn.manager;

import fr.thet.warn.Main;
import fr.thet.warn.listener.BlockIgnite;
import fr.thet.warn.listener.EntityDamage;
import fr.thet.warn.listener.EntityRegainHealth;
import fr.thet.warn.listener.EntityShootBow;
import fr.thet.warn.listener.NPCDamage;
import fr.thet.warn.listener.PlayerInteract;
import fr.thet.warn.listener.PlayerJoin;
import fr.thet.warn.listener.PlayerQuit;
import fr.thet.warn.listener.PlayerVelocity;

public class EventManager{
	
	private Main plugin;
	
	public static void init(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(new BlockIgnite(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new EntityDamage(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new EntityRegainHealth(plugin), plugin);
		plugin.getServer().getPluginManager().registerEvents(new EntityShootBow(plugin), plugin);
		plugin.getServer().getPluginManager().registerEvents(new PlayerInteract(plugin), plugin);
		plugin.getServer().getPluginManager().registerEvents(new PlayerJoin(plugin), plugin);
		plugin.getServer().getPluginManager().registerEvents(new PlayerInteract(plugin), plugin);
		plugin.getServer().getPluginManager().registerEvents(new PlayerQuit(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new PlayerVelocity(plugin), plugin);
		System.out.println("EventManager initialisé");
	}
}