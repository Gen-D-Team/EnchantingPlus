package com.enchantingplus.CustomEnchant;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.enchantments.Enchantment;

public class CustomeEnchants {
    
    public static final Enchantment TELEPATHY = new EnchantmentWrapper("telepathy", "Telepathy", 1);
    public static final Enchantment HURRICANE = new EnchantmentWrapper("hurricane", "Hurricane", 1);

    public static void register() {
        boolean telepathy = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(TELEPATHY);
        boolean hurricane = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(HURRICANE);
        if (!telepathy && !hurricane) {
            registerEnchantment(TELEPATHY);
            registerEnchantment(HURRICANE);
        }
    }

    // register the enchantment
    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;

        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }

        if (registered) {
            System.out.println("Registered");
        }
    }
}
