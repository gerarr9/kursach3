package com.example.kursach33.model;

import org.springframework.lang.Nullable;

public enum Color {
    RED,
    BLUE,
    BLACK,
    GREEN,
    WHITE,
    PINK;

    @Nullable
    public static Color parse(String color) {
        for (Color c : values()) {
            if (c.name().equals(color)) {
                return c;
            }
        }
        return null;
    }
}
