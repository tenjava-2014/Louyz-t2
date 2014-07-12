package com.tenjava.entries.Louyz.t2.events;

import com.tenjava.entries.Louyz.t2.cable.CableManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractWrenchEvent implements Listener{
    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Block block = event.getClickedBlock();

        // Check if player have a Wrench
        if (!(p.getItemInHand().getType() == Material.GOLD_HOE)) return;
        if (!(p.getItemInHand().hasItemMeta())) return;
        if (!(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("Wrench"))) return;

        // Check the Action
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;

        // Check the type of Block
        if (!(block.getType() == Material.STAINED_GLASS_PANE)){
            event.setCancelled(true);
            return;
        }

        // ItemStack: Cable
        ItemStack cable = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta cableMeta = cable.getItemMeta();
        cableMeta.setDisplayName("Cable");
        cable.setItemMeta(cableMeta);

        // Drop Cable and Play Sound
        block.setType(Material.AIR);
        CableManager.removeCable(block.getLocation());
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 1);
        Bukkit.getWorld(p.getWorld().getName()).dropItem(block.getLocation().add(0, 2, 0), cable);
    }
}