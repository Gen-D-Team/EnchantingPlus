package com.enchantingplus;

import java.util.Collection;
import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.enchantingplus.CustomEnchant.CustomeEnchants;

// import com.enchantingplus.CustomEnchant.CustomEnchants;

/*
 * enchantplus java plugin
 */
public class Plugin extends JavaPlugin implements Listener {
  private static final Logger LOGGER = Logger.getLogger("enchantplus");
  public static Object logger;
  private Enchanting enchant;

  @Override
  public void onEnable() {
    LOGGER.info("enchantplus-devbuild-0.3 enabled");
    enchant = new Enchanting();
    CustomeEnchants.register();

    getCommand("enct").setExecutor(enchant);
    getCommand("setlore").setExecutor(enchant);
    getCommand("delenct").setExecutor(enchant);
    getCommand("rename").setExecutor(enchant);
    getCommand("delore").setExecutor(enchant);

    this.getServer().getPluginManager().registerEvents(this, this);
  }

  @Override
  public void onDisable() {
    LOGGER.info("enchantplus-devbuild-0.3 disabled");
  }

  @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand() == null)
            return;
        if (!event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
            return;
        if (!event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomeEnchants.TELEPATHY))
            return;
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().getGameMode() == GameMode.SPECTATOR)
            return;
        if (event.getPlayer().getInventory().firstEmpty() == -1)
            return;
        if (event.getBlock().getState() instanceof Container)
            return;

        event.setDropItems(false);
        Player player = event.getPlayer();
        Block block = event.getBlock();

        Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());
        if (drops.isEmpty())
            return;
        player.getInventory().addItem(drops.iterator().next());
    }
}
