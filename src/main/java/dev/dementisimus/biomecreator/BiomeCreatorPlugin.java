package dev.dementisimus.biomecreator;

import dev.dementisimus.capi.core.BukkitCoreAPI;
import dev.dementisimus.capi.core.database.Database;
import dev.dementisimus.capi.core.database.properties.DataSourceProperty;
import dev.dementisimus.capi.core.setup.SetupManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
/**
 * Copyright (c) by dementisimus,
 * licensed under Attribution-NonCommercial-NoDerivatives 4.0 International
 *
 * Class BiomeCreatorPlugin @ BiomeCreator
 *
 * @author dementisimus
 * @since 26.10.2021:19:06
 */
public class BiomeCreatorPlugin extends JavaPlugin {

    @Getter private BukkitCoreAPI bukkitCoreAPI;
    @Getter private SetupManager setupManager;
    @Getter private Database database;

    @Override
    public void onEnable() {
        this.bukkitCoreAPI = new BukkitCoreAPI(this);
        this.setupManager = this.bukkitCoreAPI.getSetupManager();

        this.bukkitCoreAPI.enableMainSetupStates();

        this.bukkitCoreAPI.enableDatabase(DataSource.PROPERTY);
        this.database = this.bukkitCoreAPI.getDatabase();

        this.bukkitCoreAPI.prepare(coreAPIInjector -> {
            coreAPIInjector.addInjectionModule(BiomeCreatorPlugin.class, this);

            this.bukkitCoreAPI.init(() -> {

            });
        });
    }

    public static class Strings {

        public static final String PREFIX = "§2§lBiome§f§lCreator §7§l»";

    }

    public static class DataSource implements DataSourceProperty {

        public static final DataSource PROPERTY = new DataSource();

        @Override
        public String name() {
            return "biomes";
        }

        @Override
        public Map<String, String> fields() {
            //ToDo: complete
            return Map.ofEntries();
        }
    }

    public static class Translations {

    }
}
