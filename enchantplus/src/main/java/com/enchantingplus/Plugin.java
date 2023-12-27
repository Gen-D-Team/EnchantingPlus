package com.enchantingplus;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * enchantplus java plugin
 */
public class Plugin extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("enchantplus");
  private Enchanting enchant;
  private Lore lore;

  public void onEnable() {
    LOGGER.info("enchantplus-devbuild-0.2 enabled");
    enchant = new Enchanting();
    lore = new Lore();

    getCommand("enct").setExecutor(enchant);
    getCommand("setlore").setExecutor(lore);
  }

  public void onDisable() {
    LOGGER.info("enchantplus-devbuild-0.2 disabled");
  }
}
