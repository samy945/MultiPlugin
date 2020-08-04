package me.samy.HelloWorld.startool;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Startool implements CommandExecutor {

public List<String> list = new ArrayList<String>(); 
	


	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {

		
		Player player = (Player) sender;
		if (!player.hasPermission("startool.use")) {
			player.sendMessage(ChatColor.RED + "you do not have permission to use this command");
			return  true;
		}
		
		if (lable.equalsIgnoreCase("startool")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot use this command!");
				return true;
			}	
			
			if (player.getInventory().firstEmpty() == -1) {
				
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "The Minecraft Gods Dropped A Gift At Your Feet.");
				return true;
				
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "The Minecraft Gods gave you a gift.");
			return true;
		}
		
		return false;
	} 
	
	public ItemStack getItem() {
				
		ItemStack item = new ItemStack(Material.TRIDENT);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Ancient Trident");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click) &a&oSpawn minions"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left Click) &a&oShoot explositves"));
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.LOYALTY, 10, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
	}
	
}
