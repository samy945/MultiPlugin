package me.samy.HelloWorld.Stats;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class StatCommand implements CommandExecutor {


public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {

		if (lable.equalsIgnoreCase("mystats")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("The console cannot run this command");
				return true;
			}
			
			Player player = (Player) sender;
			if (args.length == 0) { 
				player.sendMessage(ChatColor.RED + "Useage: /mystats {deaths/logins/mobkills/playerkills");
				return true;
			}
			if (args.length >= 0) {
				if (args[0].equalsIgnoreCase("deaths")) {
					player.sendMessage(ChatColor.AQUA + "You have" + player.getStatistic(Statistic.DEATHS) + " deaths");
					return true;
			}
			}
			if (args.length >= 0) {
				if (args[0].equalsIgnoreCase("logins")) {
					player.sendMessage(ChatColor.AQUA + "You have" + (player.getStatistic(Statistic.LEAVE_GAME) + 1 )+ " logins");
					return true;	
					
			}
			}
			if (args.length >= 0) {
				if (args[0].equalsIgnoreCase("mobkills")) {
					player.sendMessage(ChatColor.AQUA + "You have" + player.getStatistic(Statistic.MOB_KILLS) + " mobkills");
					return true;
			}
			}
			if (args.length >= 0) {
				if (args[0].equalsIgnoreCase("playerkills")) {
					player.sendMessage(ChatColor.AQUA + "You have" + player.getStatistic(Statistic.PLAYER_KILLS) + " playerkills");
					return true;
			}
			}
		}
		
		return false;
	}
}
