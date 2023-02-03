package com.example.kursach33.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Sock {
    private Size size;
    private Color color;
    private int cottonPart;

    public Sock(Size size, Color color, int cottonPart) {
        this.size = size;
        this.color = color;
        this.cottonPart = cottonPart;
    }


}
