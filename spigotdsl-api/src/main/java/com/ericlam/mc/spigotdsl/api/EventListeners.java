package com.ericlam.mc.spigotdsl.api;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;

import java.util.function.Consumer;

/**
 * here to register all events
 */
public interface EventListeners {

    /**
     * fast register an event
     * @param event event class name
     * @param handler event handler
     * @param <E> bukkit event
     */
    <E extends Event> void listen(Class<E> event, Consumer<E> handler);

    /**
     * register an event with builder
     * @param event event class name
     * @param <E> bukkit event
     * @return event listen builder
     */
    <E extends Event> ListenBuilder<E> event(Class<E> event);

    /**
     * a builder to create event handler
     * @param <E> bukkit event
     */
    interface ListenBuilder<E extends Event> {

        /**
         * set the priority for that event
         * @param priority event priority
         * @return builder
         */
        ListenBuilder<E> priority(EventPriority priority);

        /**
         * set whether to not execute when setCancelled is true
         * @param ignoreCancelled set the ignoreCancelled
         * @return builder
         */
        ListenBuilder<E> ignoreCancelled(boolean ignoreCancelled);

        /**
         * set the event handler
         * @param handler event handler
         */
        void listen(Consumer<E> handler);

    }

}
