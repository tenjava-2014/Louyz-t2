package com.tenjava.entries.Louyz.t2.cable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CableManager {
    private static List<Cable> cables = new ArrayList<Cable>();

    public static void registerCable(Cable cable){
        cables.add(cable);
        System.out.println("Energy > Cable has been registered!");
    }

    public static void removeCable(Location location) {
        Cable cable = new Cable(0, location);
        cables.remove(cable);
        System.out.println("Energy > Cable has been removed!");
    }

    public static boolean checkIfCableIsRegistered(Location location) {
        for (Cable cable : cables){
            if (cable.getCableLocation().equals(location)) {
                return true;
            }
        }
        return false;
    }

    public static void setupRecipes(){
        // Recipe: Wrench
        ItemStack wrench = new ItemStack(Material.GOLD_HOE);
        ItemMeta wrenchMeta = wrench.getItemMeta();
        wrenchMeta.setDisplayName("Wrench");
        wrench.setItemMeta(wrenchMeta);

        ShapedRecipe wRecipe = new ShapedRecipe(wrench);
        wRecipe.shape("@ @",
                " # ",
                " # ");
        wRecipe.setIngredient('@', Material.GOLD_INGOT);
        wRecipe.setIngredient('#', Material.STICK);
        Bukkit.getServer().addRecipe(wRecipe);

        // Recipe: Cable
        ItemStack cable = new ItemStack(Material.STAINED_GLASS_PANE, 16, (byte) 15);
        ItemMeta cableMeta = cable.getItemMeta();
        cableMeta.setDisplayName("Cable");
        cable.setItemMeta(cableMeta);

        ShapedRecipe cRecipe = new ShapedRecipe(cable);
        cRecipe.shape("@@@",
                "###",
                "@@@");
        cRecipe.setIngredient('@', Material.THIN_GLASS);
        cRecipe.setIngredient('#', Material.REDSTONE);
        Bukkit.getServer().addRecipe(cRecipe);

        // Recipe: Battery
        ItemStack battery = new ItemStack(Material.LEVER);
        ItemMeta batteryMeta = battery.getItemMeta();
        batteryMeta.setDisplayName("Battery");
        battery.setItemMeta(batteryMeta);

        ShapedRecipe bRecipe = new ShapedRecipe(battery);
        bRecipe.shape(" $ ",
                " # ",
                " @ ");
        bRecipe.setIngredient('$', Material.REDSTONE_TORCH_ON);
        bRecipe.setIngredient('#', Material.REDSTONE_LAMP_OFF);
        bRecipe.setIngredient('@', Material.DIODE);
        Bukkit.getServer().addRecipe(bRecipe);
    }
}