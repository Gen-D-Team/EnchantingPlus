package com.enchantingplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Enchanting implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Call "enct" as a command
        if (command.getName().equalsIgnoreCase("enct")) {
            
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only Player Can You Use This Command");
            }
        }
        return true;
    }
}
