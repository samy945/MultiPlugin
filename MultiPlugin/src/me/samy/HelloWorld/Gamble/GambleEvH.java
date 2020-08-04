package me.samy.HelloWorld.Gamble;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GambleEvH implements Listener{



	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (!me.samy.HelloWorld.Gamble.Gamble.invs.contains(event.getInventory()))
			return;
		
		event.setCancelled(true);
		return;
	}
	}

