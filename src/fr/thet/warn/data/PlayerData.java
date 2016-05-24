package fr.thet.warn.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

import de.inventivegames.npc.NPC;

public class PlayerData {

	public static List<Player> vanish = new ArrayList<>();
	public static List<Player> fly = new ArrayList<>();
	public static List<Player> god = new ArrayList<>();
	public static Map<Player, Player> ins = new HashMap<>();
	public static HashMap<Player, Long> lastreg = new HashMap<>();
	public static HashMap<Player, Long> lastarr = new HashMap<>();
	public static Map<Player, NPC> check = new HashMap<>();
	
	public static List<Player> packetOn = new ArrayList<>();
	
	public static List<Player> joined = new ArrayList<>();
	
	//Packets
	public static HashMap<Player, Integer> Look = new HashMap<>();
	public static HashMap<Player, Integer> Flying = new HashMap<>();
	public static HashMap<Player, Integer> Pos = new HashMap<>();
	public static HashMap<Player, Integer> PosLok = new HashMap<>();
	public static HashMap<Player, Integer> GLook = new HashMap<>();
	public static HashMap<Player, Integer> GFlying = new HashMap<>();
	public static HashMap<Player, Integer> GPos = new HashMap<>();
	public static HashMap<Player, Integer> GPosLok = new HashMap<>();
	public static HashMap<Player, Integer> FlyToggle = new HashMap<>();
	public static HashMap<Player, Integer> FlyNotToggle = new HashMap<>();
	
	//CheatPoints
	public static HashMap<Player, Integer> antiKb = new HashMap<>();
	public static HashMap<Player, Integer> rgn = new HashMap<>();
	public static HashMap<Player, Integer> bow = new HashMap<>();
	
	public static long lastban = 100000;
	
	//AutoClick
	public static List<Player> cps = new ArrayList<>();
	public static HashMap<Player, Integer> clicks = new HashMap<>();
	public static List<Player> rcps = new ArrayList<>();
	public static HashMap<Player, Integer> rclicks = new HashMap<>();
	
	public static List<String> packet = new ArrayList<>();
	public static List<Player> fishy = new ArrayList<>();
	public static List<Player> fishy2 = new ArrayList<>();
	public static List<Player> fishy3 = new ArrayList<>();
	public static List<Player> fishy4 = new ArrayList<>();
	
	//Packet Overload Check
	public static HashMap<Player, Long> lastPacketOverload = new HashMap<>();
	public static List<Player> lastPacketOverload2 = new ArrayList<>();
	
}
