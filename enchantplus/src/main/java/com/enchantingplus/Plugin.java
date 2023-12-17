package com.enchantingplus;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * enchantplus java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("enchantplus");

  public void onEnable()
  {
    LOGGER.info("enchantplus enabled");
  }

  public void onDisable()
  {
    LOGGER.info("enchantplus disabled");
  }
}
