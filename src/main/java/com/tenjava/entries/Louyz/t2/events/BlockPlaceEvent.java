package com.tenjava.entries.Louyz.t2.events;

import com.tenjava.entries.Louyz.t2.cable.Cable;
import com.tenjava.entries.Louyz.t2.cable.CableManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockPlaceEvent implements Listener{
    @EventHandler
    public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event){

        // Get ItemMeta of Block
        ItemStack blockPlaced = event.getItemInHand();
        ItemMeta blockPlacedMeta = blockPlaced.getItemMeta();

        // Check if block is null
        if (blockPlaced == null) return;

        // Check if block is a Stained Glass Pane
        if (!(blockPlaced.getType() == Material.STAINED_GLASS_PANE)) return;

        // Check if block have a ItemMeta
        if (!blockPlaced.hasItemMeta()) return;

        // Get the Block Name
        String blockName = blockPlacedMeta.getDisplayName();
        // Check if Block Name
        if (!blockName.equalsIgnoreCase("Cable")) return;

        if (CableManager.checkIfCableIsRegistered(event.getBlock().getLocation())) return;

        CableManager.registerCable(new Cable(10, event.getBlock().getLocation()));
    }
}