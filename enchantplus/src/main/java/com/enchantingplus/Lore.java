package com.enchantingplus;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Lore implements CommandExecutor{
    private List<String> lore;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;

        if (!(sender instanceof Player)) {
            player.sendMessage("Only Player Could Use This Command");
            return true;
        }

        if (command.getName().equalsIgnoreCase("setlore")) {
            ItemStack item = player.getInventory().getItemInMainHand();
            return true;
        }
        return true;
    }
}
