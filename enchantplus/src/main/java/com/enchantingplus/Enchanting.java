package com.enchantingplus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

// This will handle all of the commands in the plugin
public class Enchanting implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // Call "enct" as a command
        if (command.getName().equalsIgnoreCase("enct")) {
            int level;
            String enchantmentName = args[0];

            // Check if user is a player or not
            if (!(sender instanceof Player)) {
                return false;
            }

            // Check if user type in enough
            if (args.length < 2) {
                player.sendMessage(ChatColor.GOLD + "Usage: /enct <enchantment> <level>");
                return true;
            }

            // Check if user is type in level is a number
            try {
                level = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                player.sendMessage("Enchant level must be a number");
                return false;
            }

            // Enchantment level is between 1 and 50
            if (level < 1 || level > 50) {
                player.sendMessage(ChatColor.RED + "Enchant level must be between 1 and 50");
                return true;
            }

            // Check player permission
            if (!player.hasPermission("enchant.use")) {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this");
                return true;
            }

            // Create a key for enchantment list
            NamespacedKey key = NamespacedKey.minecraft(enchantmentName);
            // Take the enchant that matches the key
            Enchantment enchantment = Enchantment.getByKey(key);

            if (enchantment == null) {
                player.sendMessage(ChatColor.RED + "This enchantment is not available");
                return false;
            }

            // Take item from the mainhand of player
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item == null) {
                player.sendMessage(ChatColor.RED + "You're not holding any item");
                return true;
            }

            // Take item data
            ItemMeta meta = item.getItemMeta();

            if (meta.getEnchants().containsKey(enchantment)) {
                player.sendMessage(ChatColor.RED + "This enchant is already in this item");
            }

            meta.addEnchant(enchantment, level, true);

            // Set data item again
            item.setItemMeta(meta);

            player.sendMessage(ChatColor.GREEN + "Item Enchanted Successfully!");
        }

        // Remove Enchant
        if (command.getName().equalsIgnoreCase("delenct")) {
            String enchantmentName = args[0];

            if (args.length < 1) {
                player.sendMessage(ChatColor.RED + "Usage: /delenct <enchantment>");
                return true;
            }

            NamespacedKey key = NamespacedKey.minecraft(enchantmentName);

            Enchantment enchantment = Enchantment.getByKey(key);

            ItemStack mainhand = player.getInventory().getItemInMainHand();
            mainhand.removeEnchantment(enchantment);
            player.sendMessage(ChatColor.GREEN + "Remove Enchant Successfully");

            return true;
        }

        if (command.getName().equalsIgnoreCase("setlore")) {

            if (args.length < 1) {
                player.sendMessage("usage: /setlore <lore>");
                return true;
            }

            String context = String.join(" ", args);

            context = context.replace("&", "§");

            ItemStack item = player.getInventory().getItemInMainHand();

            ItemMeta meta = item.getItemMeta();

            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();

            lore.add(context);

            meta.setLore(lore);

            item.setItemMeta(meta);

            return true;
        }

        if (command.getName().equalsIgnoreCase("delore")) {
            if (args.length < 1) {
                player.sendMessage(ChatColor.GREEN + "usage: /delore <line>");
                return true;
            }

            String context = args[0];

            ItemStack item = player.getInventory().getItemInMainHand();

            ItemMeta meta = item.getItemMeta();

            List<String> lore = meta.getLore();

            int line;

            try {
                line = Integer.parseInt(context);
                if (lore == null) {
                    player.sendMessage("Item does not have any lore");
                } else {
                    for (int i = 0; i < lore.size(); i++) {
                        if (i == line) {
                            lore.remove(line);
                            meta.setLore(lore);
                            item.setItemMeta(meta);
                        }
                    }
                }
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + context + "is not a number");
            }

            return true;
        }

        if (command.getName().equalsIgnoreCase("rename")) {
            ItemStack item = player.getInventory().getItemInMainHand();

            ItemMeta meta = item.getItemMeta();

            // Add name
            String context = args[0];

            context = context.replace("&", "§");

            if (context.length() < 1) {
                player.sendMessage(ChatColor.RED + "Usage: /rename <name>");
            }

            meta.setDisplayName(context);
            item.setItemMeta(meta);
        }

        return false;
    }

}
