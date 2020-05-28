package com.ericlam.mc.spigotdsl;

import com.ericlam.mc.spigotdsl.api.DSLBuilder;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Java Plugin Instance
 */
public final class SpigotDSL {
    /**
     * here to get the DSLBuilder, single instance per plugin.
     * @param plugin java plugin
     * @return dsl builder
     */
    public static DSLBuilder adapt(JavaPlugin plugin){
        throw new RuntimeException("trying to run api in server");
    }
}
