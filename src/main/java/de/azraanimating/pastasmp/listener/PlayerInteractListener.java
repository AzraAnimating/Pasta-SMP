/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.listener;

import de.azraanimating.pastasmp.main.PastaSMP;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteractListener implements Listener {

    private final PastaSMP pastaSMP;

    public PlayerInteractListener(PastaSMP pastaSMP) {
        this.pastaSMP = pastaSMP;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getItem() != null) {
                if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Basic Levitation Wand")) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 1, false, false, false));
                } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Advanced Levitation Wand") || event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "TNT Levitation Wand")) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 5, false, false, false));
                }
            }
        } else if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if(event.getItem() != null) {
                if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Basic Levitation Wand")) {
                    if(event.getPlayer().getInventory().contains(Material.ARROW)) {
                        ItemStack[] items = event.getPlayer().getInventory().getContents();
                        for (ItemStack item : items) {
                            if (item != null) {
                                if (item.getType().equals(Material.ARROW)) {
                                    item.setAmount(item.getAmount() - 1);
                                    event.getPlayer().getLocation().getWorld().spawnArrow(event.getPlayer().getLocation().add(0, 1.7, 0), event.getPlayer().getLocation().getDirection(), 2, 0);
                                    return;
                                }
                            }
                        }
                    }
                } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Advanced Levitation Wand")) {
                    if(event.getPlayer().getInventory().contains(Material.FIRE_CHARGE)) {
                        ItemStack[] items = event.getPlayer().getInventory().getContents();
                        for (ItemStack item : items) {
                            if (item != null) {
                                if (item.getType().equals(Material.FIRE_CHARGE)) {
                                    item.setAmount(item.getAmount() - 1);
                                    event.getPlayer().getLocation().getWorld().spawnEntity(event.getPlayer().getLocation().add( 0, 1.7, 0), EntityType.SMALL_FIREBALL).setVelocity(event.getPlayer().getLocation().getDirection());
                                    return;
                                }
                            }
                        }
                    }
                } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "TNT Levitation Wand")) {
                    if(event.getPlayer().getInventory().contains(Material.TNT)) {
                        ItemStack[] items = event.getPlayer().getInventory().getContents();
                        for (ItemStack item : items) {
                            if (item != null) {
                                if (item.getType().equals(Material.TNT)) {
                                    item.setAmount(item.getAmount() - 1);
                                    event.getPlayer().getLocation().getWorld().spawnEntity(event.getPlayer().getLocation().add(0, 1.7, 0), EntityType.PRIMED_TNT).setVelocity(event.getPlayer().getLocation().getDirection());
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
