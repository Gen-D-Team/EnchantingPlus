package com.enchantingplus;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * enchantplus java plugin
 */
public class Plugin extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("enchantplus");
  private Enchanting enchant;

  public void onEnable() {
    LOGGER.info("enchantplus-devbuild-0.2 enabled");
    enchant = new Enchanting();

    getCommand("enct").setExecutor(enchant);
    getCommand("setlore").setExecutor(enchant);
    getCommand("delenct").setExecutor(enchant);
    getCommand("rename").setExecutor(enchant);
  }

  public void onDisable() {
    LOGGER.info("enchantplus-devbuild-0.2 disabled");
  }
}
