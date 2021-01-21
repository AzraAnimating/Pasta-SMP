/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.util;

import com.destroystokyo.paper.Namespaced;
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

    private ItemStack basicLevitationWand;
    private ItemStack advancedLevitationWand;

    private final PastaSMP pastaSMP;

    public Recipes(PastaSMP pastaSMP) {
        this.pastaSMP = pastaSMP;
    }

    public void load() {
        this.loadBasicLevitationWand();
        this.loadAdvancedLevitationWand();
        this.loadRoseTNT();
        this.loadLightningRod();
        this.loadTntWand();
    }

    private void loadBasicLevitationWand() {
        this.basicLevitationWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = basicLevitationWand.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Basic Levitation Wand");
        basicLevitationWand.setItemMeta(meta);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(0, ChatColor.GRAY + "Allows you to fly and shoots Arrows from your inventory");

        meta.setLore(lore);

        basicLevitationWand.setItemMeta(meta);


        NamespacedKey key = new NamespacedKey(this.pastaSMP, "basic_levitation_wand");

        ShapedRecipe shapedRecipe = new ShapedRecipe(key, basicLevitationWand);

        shapedRecipe.shape("B", "B", "S");

        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(shapedRecipe);
    }

    private void loadAdvancedLevitationWand() {

        this.advancedLevitationWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = advancedLevitationWand.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Advanced Levitation Wand");

        ArrayList<String> lore = new ArrayList<>();
        lore.add(0, ChatColor.GRAY + "Allows you to fly and shoots Fire Charges from your Inventory");

        meta.setLore(lore);

        advancedLevitationWand.setItemMeta(meta);

        advancedLevitationWand.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        advancedLevitationWand.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //Crafting
        NamespacedKey key = new NamespacedKey(this.pastaSMP, "advanced_levitation_wand");

        ShapedRecipe shapedRecipe = new ShapedRecipe(key, advancedLevitationWand);

        shapedRecipe.shape("W", "W", "B");

        shapedRecipe.setIngredient('W', basicLevitationWand);
        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);

        Bukkit.addRecipe(shapedRecipe);
    }

    private void loadRoseTNT() {
        ItemStack roseTnt = new ItemStack(Material.POPPY);
        ItemMeta meta = roseTnt.getItemMeta();
        meta.setDisplayName("Poppy");

        ArrayList<String> lore = new ArrayList<>();

        lore.add(0, ChatColor.RED + "This Rose explodes on being dropped");

        meta.setLore(lore);

        roseTnt.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this.pastaSMP, "rose_tnt");

        ShapedRecipe shapedRecipe = new ShapedRecipe(key, roseTnt);

        shapedRecipe.shape("NTN", "TRT", "NTN");

        shapedRecipe.setIngredient('T', Material.TNT);
        shapedRecipe.setIngredient('R', Material.POPPY);

        Bukkit.addRecipe(shapedRecipe);
    }

    private void loadLightningRod() {
        ItemStack lightningStaff = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = lightningStaff.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Lightning Staff");
        lightningStaff.setItemMeta(meta);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(0, ChatColor.GRAY + "Draws Lighting wherever it is dropped");

        meta.setLore(lore);

        lightningStaff.setItemMeta(meta);

        lightningStaff.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        lightningStaff.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        NamespacedKey key = new NamespacedKey(this.pastaSMP, "lightning_staff");

        ShapedRecipe shapedRecipe = new ShapedRecipe(key, lightningStaff);

        shapedRecipe.shape("III", "ISI", "III");

        shapedRecipe.setIngredient('I', Material.IRON_INGOT);
        shapedRecipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(shapedRecipe);
    }

    public void loadTntWand() {
        ItemStack tntWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = tntWand.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "TNT Levitation Wand");;

        ArrayList<String> lore = new ArrayList<>();
        lore.add(0, ChatColor.GRAY + "Throws TNT from your inventory");

        meta.setLore(lore);
        tntWand.setItemMeta(meta);

        tntWand.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        tntWand.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        NamespacedKey key = new NamespacedKey(this.pastaSMP, "tnt_levitation_wand");

        ShapedRecipe shapedRecipe = new ShapedRecipe(key, tntWand);

        shapedRecipe.shape("TTT", "TBT", "TTT");

        shapedRecipe.setIngredient('B', advancedLevitationWand);
        shapedRecipe.setIngredient('T', Material.TNT);

        Bukkit.addRecipe(shapedRecipe);
    }

}
