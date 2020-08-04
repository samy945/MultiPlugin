package me.samy.HelloWorld.DoctorCom;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Doctor implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if(lable.equalsIgnoreCase("Doctor") || lable.equalsIgnoreCase("Doc")) {
			
			if (!(sender instanceof Player)) {
				sender.sendMessage("*you've been healed*");
				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("doctor.use")) {
				player.sendMessage(ChatColor.RED + "you do not have permission to use this command");
				return  true;
			}
			if (args.length == 0) {
				// / doctor
				TextComponent message = new TextComponent("would you like to be healed?");
				message.setColor(ChatColor.GOLD);
				message.setBold(true);
				message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));				
				message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
						new ComponentBuilder("Click here to be healed!").color(ChatColor.GRAY).italic(true).create()));
				player.spigot().sendMessage(message);
				return true;
			}
			//  /doctor healme
			if (args[0].equalsIgnoreCase("Healme")) {
				player.setHealth(20.0);; // easy way
				//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal " + player.getName()); // Though console
				player.sendMessage(ChatColor.GREEN + "you've been healede!");
				return true;
				
			}
			player.sendMessage(ChatColor.RED + "usage; /doctor");
			return true;
			
		}
			
		
		return false;
		
	}

}
