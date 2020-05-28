package com.ericlam.mc.spigotdsl.api;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.Map;
import java.util.function.Consumer;

/**
 * here to do the api action
 */
public interface DSLBuilder {

    /**
     * register events
     * @param listeners event listeners
     */
    void listenEvents(Consumer<EventListeners> listeners);

    /**
     * register commands
     * @param creators command creator
     */
    void createCommands(Consumer<CommandCreators> creators);

    /**
     * create yaml
     * @param creators file creator
     * @return map of registered configuration
     */
    Map<String, FileConfiguration> createFile(Consumer<YamlCreators> creators);

}
