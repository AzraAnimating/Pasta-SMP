/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.listener;

import de.azraanimating.pastasmp.main.PastaSMP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

    private final PastaSMP pastaSMP;

    public PlayerDropItemListener(PastaSMP pastaSMP) {
        this.pastaSMP = pastaSMP;
    }

    @EventHandler
    public void onPlayerItemDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getLore() != null) {
            if (event.getItemDrop().getItemStack().getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.RED + "This Rose explodes on being dropped")) {
                //Rose Dynamite
                this.pastaSMP.getServer().getScheduler().runTaskLater(this.pastaSMP, () -> event.getItemDrop().getLocation().getWorld().createExplosion(event.getItemDrop().getLocation(), 5, false, true), 20);

            }
        }
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Lightning Staff")) {

            //Lightning-Rod
            this.pastaSMP.getServer().getScheduler().runTaskLater(this.pastaSMP, () -> {
                for (int i = 0; i < 100; i++) {
                    event.getItemDrop().getLocation().getWorld().strikeLightning(event.getItemDrop().getLocation());
                }

            }, 100);

        }
    }

}
