package com.enchantingplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lore implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        // String loreItem = args[0];
        if (!(sender instanceof Player)) {
            return false;
        }

        if (command.getName().equalsIgnoreCase("setlore")) {
            player.sendMessage("This is setlore command");
            return true;
        }

        if (command.getName().equalsIgnoreCase("addlore")) {
            player.sendMessage("This is addlore command");
            return true;
        }

        if (command.getName().equalsIgnoreCase("rename")) {
            player.sendMessage("This is rename command");
            return true;
        }

        return true;
    }
}
