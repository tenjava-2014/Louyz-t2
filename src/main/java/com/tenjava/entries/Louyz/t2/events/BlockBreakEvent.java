package com.tenjava.entries.Louyz.t2.events;

import com.tenjava.entries.Louyz.t2.cable.CableManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener{
    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event){
        Block block = event.getBlock();

        // Check if block is a Stained Glass
        if (!(block.getType() == Material.STAINED_GLASS_PANE)) return;

        // Check if block is registered
        if (!CableManager.checkIfCableIsRegistered(event.getBlock().getLocation())) return;

        event.setCancelled(true);

    }
}
