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
            return false;
        }

        if (command.getName().equalsIgnoreCase("setlore")) {
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item == null) {
                player.sendMessage("You aren't holding an item");
                return true;
            }

            ItemMeta meta = item.getItemMeta();

            String loreline = args[0];

            lore.add(loreline);
            meta.setLore(lore);
            item.setItemMeta(meta);

            player.sendMessage("Lore added successfully to item");

            return true;
        }
        return true;
    }
}
