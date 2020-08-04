package me.samy.HelloWorld.Gamble;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.scheduler.BukkitRunnable;

import io.netty.util.internal.ThreadLocalRandom;
import me.samy.HelloWorld.Main;

public class Gamble implements CommandExecutor, Plugin{
	
	public static List<Inventory> invs = new ArrayList<Inventory>();
	public static ItemStack[] contents;
	private int itemIndex = 0;
	

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("gamble")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("No gambling for the console :(");
				return true;
			}
			Player player = (Player) sender;
			ItemStack fee = new ItemStack(Material.DIAMOND);
			fee.setAmount(3);
			if (player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND) &&
					player.getInventory().getItemInMainHand().getAmount() >= 3) {
				player.getInventory().removeItem(fee);
				// spin that GUI!!!
				spin(player);
				return true;
			}
			player.sendMessage(ChatColor.DARK_RED + "You need 3 diamonds to gamble!");
			return true;
			
		}
		return false;
	}
	
	public void shuffle(Inventory inv) {
		if (contents == null) {
			ItemStack[] items = new ItemStack[10];
			
			items[0] = new ItemStack(Material.COARSE_DIRT, 32);
			items[1] = new ItemStack(Material.DIAMOND, 3);
			items[2] = new ItemStack(Material.IRON_INGOT, 64);
			items[3] = new ItemStack(Material.NETHER_STAR, 8);
			items[4] = new ItemStack(Material.DRAGON_EGG, 1);
			items[5] = new ItemStack(Material.QUARTZ_BLOCK, 64);
			items[6] = new ItemStack(Material.DIAMOND, 3);
			items[7] = new ItemStack(Material.DRAGON_HEAD, 1);
			items[8] = new ItemStack(Material.DIAMOND, 3);
			items[9] = new ItemStack(Material.WITHER_SKELETON_SKULL, 3);
			
			contents = items;
		}
		
		int startingIndex = ThreadLocalRandom.current().nextInt(contents.length);
		
		for (int index = 0; index < startingIndex; index++) {
			for (int itemstacks = 9; itemstacks < 18; itemstacks++) {
				inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
			}
			itemIndex++;
		}
		
		// Customize
		ItemStack item = new ItemStack(Material.HOPPER);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GRAY + "|");
		item.setItemMeta(meta);
		inv.setItem(4, item);
	}
	
	
	public void spin(final Player player) {
		
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Goodluck!");
		shuffle(inv);
		invs.add(inv);
		player.openInventory(inv);
		
		Random r = new Random();
		double seconds = 7.0 + (12.0 - 7.0) * r.nextDouble();
		
		new BukkitRunnable() {
			double delay = 0;
			int ticks = 0;
			boolean done = false;
			
			public void run() {
				if (done)
					return;
				ticks++;
				delay += 1 / (20 *seconds);
				if (ticks > delay * 10) {
					ticks = 0;
					
					for (int itemstacks = 9; itemstacks < 18; itemstacks++)
						inv.setItem(itemstacks, contents[(itemstacks + itemIndex) % contents.length]);
					
					itemIndex++;
					
					if (delay >= .5) {
						done = true;
						new BukkitRunnable() {
							public void run() {
								ItemStack item = inv.getItem(13);
								player.getInventory().addItem(item);
								player.updateInventory();
								player.closeInventory();
								cancel();
							}
						}.runTaskLater(Main.getPlugin(Main.class), 50);
						cancel();
					}
				}
				
			}
			
			
		}.runTaskTimer(this, 0, 1);
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileConfiguration getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getDataFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginDescriptionFile getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginLoader getPluginLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getResource(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNaggable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reloadConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDefaultConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveResource(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNaggable(boolean arg0) {
		// TODO Auto-generated method stub
		
	}
}



