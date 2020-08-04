package me.samy.HelloWorld;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import me.samy.HelloWorld.DoctorCom.Doctor;
import me.samy.HelloWorld.Fly.Fly;
import me.samy.HelloWorld.Gamble.Gamble;
import me.samy.HelloWorld.Gamble.GambleEvH;
import me.samy.HelloWorld.Hello.Hello;
import me.samy.HelloWorld.Skull.Skull;
import me.samy.HelloWorld.Stats.StatCommand;
import me.samy.HelloWorld.Stats.StatTab;
import me.samy.HelloWorld.godboots.godboots;
import me.samy.HelloWorld.startool.Startool;
import me.samy.HelloWorld.startool.startoolevh;

public class Main<data> extends JavaPlugin implements Listener {
	
	public static Inventory INVS;

	
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new startoolevh(), this);
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new GambleEvH(), this);
		this.getCommand("Launch").setExecutor(new Fly());
		this.getCommand("Hello").setExecutor(new Hello());
		this.getCommand("Doctor").setExecutor(new Doctor());
		this.getCommand("Gods").setExecutor(new godboots());
		this.getCommand("Startool").setExecutor(new Startool());
		this.getCommand("Skull").setExecutor(new Skull());
		this.getCommand("gamble").setExecutor(new Gamble());
		this.getCommand("myststs").setExecutor(new StatCommand());
		this.getCommand("mystats").setTabCompleter(new StatTab());

		// startup
		// reloads
		// plugin reloads

			}
	



	@Override
	public void onDisable() {
		// shutdown
		// reload
		// plugin reloads
	}
		//boosts listner
	@EventHandler
	public void onJump(PlayerMoveEvent event) {
		Player player = (Player) event.getPlayer();
		if (player.getInventory().getBoots() != null)
			if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of Leaping"))
				if (player.getInventory().getBoots().getItemMeta().hasLore())
					if (event.getFrom().getY() < event.getTo().getY() &&
							player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
						player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));		
								
							}

	}
	
	@EventHandler
	public void onFall(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (event.getCause() == DamageCause.FALL) {
				if (player.getInventory().getBoots() != null)
					if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of Leaping"))
						if (player.getInventory().getBoots().getItemMeta().hasLore());
							event.setCancelled(true); 
			}
			
		}
		}
	}







						