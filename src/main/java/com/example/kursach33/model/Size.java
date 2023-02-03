package com.example.kursach33.model;

import org.springframework.lang.Nullable;

public enum Size {
    SIZE_34(34),
    SIZE_35(35),
    SIZE_36(36),
    SIZE_37(37);

    private final int size;

    Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Nullable
    public static Size parse(int size) {
        for (Size s : values()) {
            if (Float.compare(s.size, size) == 0) {
                return s;
            }
        }
        return null;
    }
}
