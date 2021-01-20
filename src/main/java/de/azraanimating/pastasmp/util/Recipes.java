/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.util;

import de.azraanimating.pastasmp.main.PastaSMP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Recipes {

    private final PastaSMP pastaSMP;

    public Recipes(PastaSMP pastaSMP) {
        this.pastaSMP = pastaSMP;
    }

    public void load() {
        this.loadBasicLevitationWand();
        this.loadAdvancedLevitationWand();
    }

    private void loadBasicLevitationWand() {
        ItemStack basicLevitationWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = basicLevitationWand.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Basic Levitation Wand");
        basicLevitationWand.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this.pastaSMP, "basic_levitation_wand");

        ShapedRecipe shapedRecipe = new ShapedRecipe(key, basicLevitationWand);

        shapedRecipe.shape("B", "B", "S");

        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(shapedRecipe);
    }

    private void loadAdvancedLevitationWand() {
        ItemStack advancedLevitationWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = advancedLevitationWand.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Advanced Levitation Wand");;
        advancedLevitationWand.setItemMeta(meta);

        advancedLevitationWand.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        advancedLevitationWand.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        NamespacedKey key = new NamespacedKey(this.pastaSMP, "advanced_levitation_wand");

        ShapedRecipe shapedRecipe = new ShapedRecipe(key, advancedLevitationWand);

        ItemStack basicLevitationWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta basicLevitationWandmeta = basicLevitationWand.getItemMeta();
        basicLevitationWandmeta.setDisplayName(ChatColor.YELLOW + "Basic Levitation Wand");
        basicLevitationWand.setItemMeta(basicLevitationWandmeta);

        shapedRecipe.shape("W", "B", "B");

        shapedRecipe.setIngredient('W', basicLevitationWand);
        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);

        Bukkit.addRecipe(shapedRecipe);
    }

}
