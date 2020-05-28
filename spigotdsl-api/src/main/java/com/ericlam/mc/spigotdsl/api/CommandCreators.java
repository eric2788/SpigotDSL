package com.ericlam.mc.spigotdsl.api;

import com.ericlam.mc.spigotdsl.CommandHandler;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * here for command creation
 */
public interface CommandCreators {

    /**
     * Fast create a command
     * @param name command name
     * @param description command description
     * @param executor command executor
     */
    void create(@NotNull String name, @NotNull String description, CommandHandler executor);

    /**
     * Create a command with builder
     * @param name command name
     * @return command builder
     */
    CommandBuilder command(String name);

    /**
     * a builder to build command
     */
    interface CommandBuilder {

        /**
         * set the command description
         * @param description description
         * @return builder
         */
        CommandBuilder description(String description);

        /**
         * set the command permission
         * @param permission command permission
         * @return builder
         */
        CommandBuilder permission(String permission);

        /**
         * set the command args
         * @param args command args
         * @return builder
         */
        CommandBuilder args(String... args);

        /**
         * set the command executuor
         * @param handler command executor
         */
        void executor(CommandHandler handler);

        /**
         * set the child command
         * @param creators child command creators
         */
        void child(Consumer<CommandCreators> creators);
    }

}
