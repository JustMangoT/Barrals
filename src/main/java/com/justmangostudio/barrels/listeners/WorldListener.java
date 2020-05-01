package com.justmangostudio.barrels.listeners;

import com.justmangostudio.barrels.Barrels;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;

import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class WorldListener implements Listener {
    public WorldListener(Barrels plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onFireSpread(BlockBurnEvent e) {
        String id = BlockStorage.checkID(e.getBlock());
        if (id != null && id.startsWith("BARREL_")) e.setCancelled(true);
    }
}
