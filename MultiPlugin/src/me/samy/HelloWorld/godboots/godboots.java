package me.samy.HelloWorld.godboots;

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

public class godboots implements CommandExecutor  {

	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {

	Player player = (Player) sender;
	if (!player.hasPermission("gods.use")) {
		player.sendMessage(ChatColor.RED + "you do not have permission to use this command");
		return  true;
	}
		
		if (lable.equalsIgnoreCase("gods")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Sorry console you're not allowed to fly.");
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
		
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = boots.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of Leaping");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Boots made for Minecraft Gods");
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		boots.setItemMeta(meta);
		
		return boots;
	}
	
}

