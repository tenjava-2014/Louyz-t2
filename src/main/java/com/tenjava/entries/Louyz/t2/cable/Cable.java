package com.tenjava.entries.Louyz.t2.cable;

import org.bukkit.Location;

public class Cable {
    private int energyLevel;
    private Location cableLocation;

    public Cable(int energyLevel, Location cableLocation){
        this.energyLevel = energyLevel;
        this.cableLocation = cableLocation;
    }

    /**
     * Get the Energy Level
     */
    public int getEnergyLevel(){
        return this.energyLevel;
    }

    /**
     * Get the Cable Location
     */
    public Location getCableLocation(){
        return this.cableLocation;
    }

    /**
     * Set the Energy Level
     */
    public void setEnergyLevel(int energyLevel){
        this.energyLevel = energyLevel;
    }

}