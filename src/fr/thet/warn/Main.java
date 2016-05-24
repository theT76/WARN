package fr.thet.warn;

import org.bukkit.plugin.java.JavaPlugin;

import com.captainbern.npclib.NPCManager;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

import fr.thet.warn.data.PlayerData;
import fr.thet.warn.manager.CommandManager;
import fr.thet.warn.manager.EventManager;
import fr.thet.warn.packet.PacketListener;

public class Main extends JavaPlugin{

	private Main plugin;
	private ProtocolManager protocolManager;
	NPCManager manager;
	
	@Override
	public void onEnable() {
		
		
		manager = NPCManager.getNPCManager(this);
		
		
		protocolManager = ProtocolLibrary.getProtocolManager();
		plugin = this;
		//PacketListener.Listener(plugin, protocolManager);
		CommandManager.init(plugin);
		EventManager.init(plugin);
		saveDefaultConfig();
		System.out.println("Warn Actif");
		
		
		
		
		
		 protocolManager.addPacketListener(
	    		  new PacketAdapter(plugin, ListenerPriority.NORMAL, 
	    		          PacketType.Play.Client.POSITION_LOOK) {
	    		    
					@Override
	    		    public void onPacketReceiving(PacketEvent event) {
	    		        if (event.getPacketType() == 
	    		                PacketType.Play.Client.POSITION_LOOK) {
	    		        	if(event.getPlayer().isOnGround()){
		    		        	   if(PlayerData.PosLok.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.PosLok.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.PosLok.remove(event.getPlayer());
		    		        		   PlayerData.PosLok.put(event.getPlayer(), i);
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.PosLok.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}else{
		    		        	   if(PlayerData.PosLok.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.PosLok.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.PosLok.remove(event.getPlayer());
		    		        		   PlayerData.PosLok.put(event.getPlayer(), i);
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.PosLok.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}
	    		        	if(event.getPlayer().isOnGround()){
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}else{
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}
	    		        }
	    		    }
	    		  
	    		});
	    
	    protocolManager.addPacketListener(
	    		  new PacketAdapter(plugin, ListenerPriority.NORMAL, 
	    		          PacketType.Play.Client.LOOK) {
	    		    @Override
	    		    public void onPacketReceiving(PacketEvent event) {
	    		    	
	    		        if (event.getPacketType() == 
	    		                PacketType.Play.Client.LOOK) {
	    		        	if(event.getPlayer().isOnGround()){
		    		        	   if(PlayerData.GLook.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.GLook.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.GLook.remove(event.getPlayer());
		    		        		   PlayerData.GLook.put(event.getPlayer(), i);
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.GLook.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}else{
		    		        	   if(PlayerData.Look.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Look.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Look.remove(event.getPlayer());
		    		        		   PlayerData.Look.put(event.getPlayer(), i);
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Look.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}
	    		        	if(event.getPlayer().isOnGround()){
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}else{
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}

	    		        }
	    		    }
	    		  
	    		  
	    		});
	    
	    protocolManager.addPacketListener(
	    		  new PacketAdapter(plugin, ListenerPriority.NORMAL, 
	    		          PacketType.Play.Client.FLYING) {
	    		    @Override
	    		    public void onPacketReceiving(PacketEvent event) {
	    		    	
	    		    	
	    		        if (event.getPacketType() == 
	    		                PacketType.Play.Client.FLYING) {
	    		        	if(event.getPacket().getBooleans().readSafely(0) != null){
	    		        		if( event.getPacket().getBooleans().readSafely(0) == false){
			    		        	   if(PlayerData.FlyToggle.containsKey(event.getPlayer())){
			    		        		   Integer i = PlayerData.FlyToggle.get(event.getPlayer());
			    		        		   i++;
			    		        		   PlayerData.FlyToggle.remove(event.getPlayer());
			    		        		   PlayerData.FlyToggle.put(event.getPlayer(), i);
			    		        		   
			    		        	   }else{
			    		        		   PlayerData.FlyToggle.put(event.getPlayer(), 1);
			    		        	   }
	    		        		}
	    		        	
	    		        	}
	    		        	if(event.getPacket().getBooleans().readSafely(0) != null){
	    		        		if( event.getPacket().getBooleans().readSafely(0) == true){
			    		        	   if(PlayerData.FlyNotToggle.containsKey(event.getPlayer())){
			    		        		   Integer i = PlayerData.FlyNotToggle.get(event.getPlayer());
			    		        		   i++;
			    		        		   PlayerData.FlyNotToggle.remove(event.getPlayer());
			    		        		   PlayerData.FlyNotToggle.put(event.getPlayer(), i);
			    		        		   
			    		        	   }else{
			    		        		   PlayerData.FlyNotToggle.put(event.getPlayer(), 1);
			    		        	   }
	    		        		}
	    		        	
	    		        	}
		        		
	    		        	
	    		        	if(event.getPlayer().isOnGround()){
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}else{
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}
	    		        }
	    		    }
	    		  
	    		  
	    		});
	    
	    protocolManager.addPacketListener(
	    		  new PacketAdapter(plugin, ListenerPriority.NORMAL, 
	    		          PacketType.Play.Client.POSITION) {
					@Override
	    		    public void onPacketReceiving(PacketEvent event) {
	    		    	
	    		    	
	    		        if (event.getPacketType() == 
	    		                PacketType.Play.Client.POSITION) {
	    		        	if(event.getPlayer().isOnGround()){
		    		        	   if(PlayerData.Pos.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Pos.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Pos.remove(event.getPlayer());
		    		        		   PlayerData.Pos.put(event.getPlayer(), i);
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Pos.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}else{
		    		        	   if(PlayerData.Pos.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Pos.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Pos.remove(event.getPlayer());
		    		        		   PlayerData.Pos.put(event.getPlayer(), i);
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Pos.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}
	    		        	if(event.getPlayer().isOnGround()){
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}else{
		    		        	   if(PlayerData.Flying.containsKey(event.getPlayer())){
		    		        		   Integer i = PlayerData.Flying.get(event.getPlayer());
		    		        		   i++;
		    		        		   PlayerData.Flying.remove(event.getPlayer());
		    		        		   PlayerData.Flying.put(event.getPlayer(), i);
		    		        		   
		    		        		   //event.getPlayer().sendMessage("§cOnGround: " + i);
		    		        	   }else{
		    		        		   PlayerData.Flying.put(event.getPlayer(), 1);
		    		        	   }
	    		        	}

	    		        }
	    		    }
	    		  
	    		  
	    		});
	}
	
	@Override
	public void onDisable() {
		getConfig().set("cps", null);
		this.saveConfig();
		this.reloadConfig();
	}
	
}
