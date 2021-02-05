/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.listener;

import com.zyonicsoftware.mineraper.mads.playerToolBuilder.ItemBuilder;
import de.azraanimating.pastasmp.util.DeathMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class PlayerDeathListener implements Listener {

    DeathMessage deathMessage = new DeathMessage();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        EntityDamageEvent.DamageCause damageCause = Objects.requireNonNull(player.getLastDamageCause()).getCause();

        if(!player.getInventory().contains(Material.MAP)) {
            player.getInventory().addItem(new ItemBuilder(Material.MAP).build());
        }

        DeathMessage.Type type = DeathMessage.Type.valueOf(damageCause.toString());

        if(damageCause.equals(EntityDamageEvent.DamageCause.HOT_FLOOR)) {
            type = DeathMessage.Type.LAVA;
        } else if(damageCause.equals(EntityDamageEvent.DamageCause.WITHER)) {
            type = DeathMessage.Type.PROJECTILE;
        } else if(damageCause.equals(EntityDamageEvent.DamageCause.SUICIDE)) {
            type = DeathMessage.Type.DEFAULT;
        }

        event.setDeathMessage(deathMessage.getSinglePlayerDeathMessage(type , player.getName()));

    }

}
