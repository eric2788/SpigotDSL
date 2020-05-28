package com.ericlam.mc.spigotdsl.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * some fast create list utils copied from jdk11
 */
public class ListCreator {
    public static <T> List<T> of(T... elements) {
        return Arrays.asList(elements);
    }

    public static <T> List<T> of(Supplier<T>... elementsGetter) {
        return Arrays.stream(elementsGetter).map(Supplier::get).collect(Collectors.toList());
    }
}
