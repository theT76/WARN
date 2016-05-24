package fr.thet.warn.sanction;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.thet.warn.data.Permission;

public class Warning {

	@SuppressWarnings("deprecation")
	public static void WarningCps(Player p, int cps){
		for(Player j : Bukkit.getOnlinePlayers()){
			if(j.hasPermission(Permission.permWarning)){
				j.sendMessage("§c§l[WARN] §c§o[Alerte] §4" + p.getName() + " §cClicks en 5sec: §4" + cps + " §c(Moy.Cps: " + (cps/5)+")") ;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void WarningOther(Player p, String raison){
		for(Player j : Bukkit.getOnlinePlayers()){
			if(j.hasPermission(Permission.permWarning) || j.isOp()){
				j.sendMessage("§c§l[WARN] §c§o[Alerte] §4" + p.getName() + " §cSuspecté de: §4" + raison) ;
			}
		}
	}
	
}
