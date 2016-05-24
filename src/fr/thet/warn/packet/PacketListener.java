package fr.thet.warn.packet;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

import fr.thet.warn.Main;
import fr.thet.warn.data.PlayerData;

public class PacketListener {

	@SuppressWarnings("deprecation")
	public static void Listener(Main plugin, ProtocolManager protocolManager) {
	    
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
	
}
