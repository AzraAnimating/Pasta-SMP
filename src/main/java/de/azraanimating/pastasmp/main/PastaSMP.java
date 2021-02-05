/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.main;

import de.azraanimating.pastasmp.listener.PlayerDeathListener;
import de.azraanimating.pastasmp.listener.PlayerDropItemListener;
import de.azraanimating.pastasmp.listener.PlayerInteractListener;
import de.azraanimating.pastasmp.listener.PlayerJoinListener;
import de.azraanimating.pastasmp.util.Recipes;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PastaSMP extends JavaPlugin {

    private Recipes recipes;

    @Override
    public void onEnable() {
        this.recipes = new Recipes(this);
        recipes.load();
        this.registerListeners();
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners() {
        PluginManager pluginManager = this.getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerInteractListener(this), this);
        pluginManager.registerEvents(new PlayerDropItemListener(this), this);
        pluginManager.registerEvents(new PlayerDeathListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
    }

    public Recipes getRecipes() {
        return recipes;
    }
}
