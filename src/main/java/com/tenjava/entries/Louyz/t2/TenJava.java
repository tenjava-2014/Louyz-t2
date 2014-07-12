package com.tenjava.entries.Louyz.t2;

import com.tenjava.entries.Louyz.t2.cable.CableManager;
import com.tenjava.entries.Louyz.t2.events.BlockBreakEvent;
import com.tenjava.entries.Louyz.t2.events.BlockPlaceEvent;
import com.tenjava.entries.Louyz.t2.events.InteractWrenchEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    /**
     * Get the plugin instance
     */
    public static Plugin getPlugin(){
        return TenJava.getPlugin(TenJava.class);
    }

    @Override
    public void onEnable(){
        // Register - Recipe
        CableManager.setupRecipes();
        // Register - Events
        Bukkit.getPluginManager().registerEvents(new BlockBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InteractWrenchEvent(), this);
    }
}