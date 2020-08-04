package me.samy.HelloWorld.Hello;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hello implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

			if (label.equalsIgnoreCase("hello") || label.equalsIgnoreCase("hi")) {
				if (sender instanceof Player) {
					// Player
					Player player = (Player) sender; 
					if (player.hasPermission("hello.use")){
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Hey welcome to the server!");
						return true;
					}
					player.sendMessage(ChatColor.RED + "You do not have permission!");
					return true;
				}
				else {
					// console
					
					return true;
				}
			}	
			return false;

	}
	

}


