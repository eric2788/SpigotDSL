package com.ericlam.mc.spigotdsl;


import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * a FileConfiguration for message that auto translate the color and add the prefix
 */
public abstract class MessageConfiguration extends YamlConfiguration {

    /**
     * translate color
     * @param msg text to translate
     * @return if msg is null then it will return empty string
     */
    @NotNull
    public static String translate(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg != null ? msg : "");
    }

    /**
     * get the prefix text with translated color
     * @return prefix text
     */
    @NotNull
    public abstract String getPrefix();

    /**
     * get string without color and prefix.
     * @param path path
     * @return string without color and prefix.
     */
    @NotNull
    public abstract String getPureString(@NotNull String path);

    /**
     * get string list without color and prefix
     * @param path path
     * @return string list without color and prefix.
     */
    @NotNull
    public abstract List<String> getPureList(@NotNull String path);

}
