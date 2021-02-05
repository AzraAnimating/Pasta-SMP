/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.listener;

import com.zyonicsoftware.mineraper.mads.playerToolBuilder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {


    @EventHandler
    public void onPlayerJoinListener(PlayerJoinEvent event) {
        if(!event.getPlayer().getInventory().contains(Material.MAP)) {
            event.getPlayer().getInventory().addItem(new ItemBuilder(Material.MAP).build());
        }
    }


}
