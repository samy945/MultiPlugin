package me.samy.HelloWorld.Fly;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!player.hasPermission("launch.use")) {
			player.sendMessage(ChatColor.RED + "you do not have permission to use this command");
			return  true;
		}
		
		if (label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch") ) {
					
			if(!(sender instanceof Player)) {
				sender.sendMessage("*console goes flying*");
				return true;
			}

			// /launch     /launch <number>
			if (args.length == 0) {
				player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooooooom");
				player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
				
				return true;				
			}
			//	/launch <number>
			if (isNum(args[0])) {
				player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooooooom");
				player.setVelocity(player.getLocation() .getDirection() .multiply(Integer.parseInt(args[0])).setY(2));
				return true;
			}
			else {
				player.sendMessage(ChatColor.RED + "Usage: /launch <number-valuse>");
				
			}
		}
		return false;		
	}
	
	public boolean isNum(String num)  {
		try {
			Integer.parseInt(num); 
								
		} catch (Exception e) {
				return false;
			}
			return true;
			}
	}
	