package com.enchantingplus;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchanting implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Call "enct" as a command
        if (command.getName().equalsIgnoreCase("enct")) {
            
            // Check if player using or not player
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only Player Can You Use This Command");
                return true;
            }

            // Assign this as a "/" command
            Player player = (Player) sender;
            
            // Check if user is trammission in 2 parameters
            if (args.length < 2) {
                player.sendMessage("Usage: /enct <enchantment> <level>");
                return true;
            }

            // Assign 2 variables as  enchantment name and level of the enchantment
            String enchantmentName = args[0];

            int level;


            // Convert the second parameter into integer
            try {
                level = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                player.sendMessage("Enchant level must be a number");
                return true;
            }

            Enchantment enchantment = Enchantment.getByName(enchantmentName);

            if (enchantment == null) {
                player.sendMessage("This enchantment is not available");
                return true;
            }

            if (level < 1 || level > 50) {
                player.sendMessage("The level must be between 1 and 50");
                return true;
            }

            if (!player.hasPermission("enchant.use")) {
                player.sendMessage("You can not use this command");
                return true;
            }

            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            meta.addEnchant(enchantment, level, true);
            item.setItemMeta(meta);

            player.sendMessage("Item Enchanted Successfully");
        }
        return true;
    }
}
