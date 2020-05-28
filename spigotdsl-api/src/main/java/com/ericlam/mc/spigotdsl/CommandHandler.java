package com.ericlam.mc.spigotdsl;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * API's own command executor
 */
@FunctionalInterface
public interface CommandHandler {
    void execute(CommandSender sender, List<String> args);
}
