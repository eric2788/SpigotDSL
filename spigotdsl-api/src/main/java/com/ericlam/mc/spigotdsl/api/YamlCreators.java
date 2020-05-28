package com.ericlam.mc.spigotdsl.api;

/**
 * Here to create the yaml
 */
public interface YamlCreators {

    /**
     * fast create yaml and add into the config map
     * @param yml yaml name, must include .yml
     */
    void create(String yml);

    /**
     * set the prefix path, if prefix path is not null then it will be treat as MessageConfiguration
     * @see com.ericlam.mc.spigotdsl.MessageConfiguration
     * @param path prefix path, can be null
     * @return builder
     */
    YamlBuilder prefix(String path);

    /**
     * set the folder path, the path will after plugin.getDataFolder()
     * @param path folder path
     * @return builder
     */
    YamlBuilder folder(String path);

    /**
     * a builder to create yaml
     */
    interface YamlBuilder{

        /**
         * set the folder path, the path will after plugin.getDataFolder()
         * @param path folder path
         * @return builder
         */
        YamlBuilder folder(String path);

        /**
         * set the prefix path, if prefix path is not null then it will be treat as MessageConfiguration
         * @see com.ericlam.mc.spigotdsl.MessageConfiguration
         * @param path prefix path, can be null
         * @return builder
         */
        YamlBuilder prefix(String path);

        /**
         * create the yaml and add into the config map
         * @param yml yaml name, must include .yml
         */
        void create(String yml);

    }

}
