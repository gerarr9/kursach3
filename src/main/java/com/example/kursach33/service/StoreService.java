package com.example.kursach33.service;


import com.example.kursach33.model.Color;
import com.example.kursach33.model.Size;
import com.example.kursach33.model.Sock;
import com.example.kursach33.model.SockItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class StoreService {
    Map<Sock, Integer> socks = new HashMap<>();

    public void add(SockItem sockItem) {
        if (isNonValid(sockItem)) {
            throw new IndexOutOfBoundsException();
        }
        Sock sock = sockItem.getSock();
        if (socks.containsKey(sock)) {
            socks.replace(sock, socks.get(sock) + sockItem.getQuantity());
        } else {
            socks.put(sock, sockItem.getQuantity());
        }

    }

    public void minus(SockItem sockItem) {
        Sock sock = sockItem.getSock();
        if (!socks.containsKey(sock) || isNonValid(sockItem)) {
            throw new IndexOutOfBoundsException();
        }
        int avaible = socks.get(sock);
        int result = avaible - sockItem.getQuantity();
        if (result < 0) {
            throw new IndexOutOfBoundsException();
        }
        socks.replace(sock, result);
    }


    private boolean isNonValid(SockItem sockItem) {
        Sock sock = sockItem.getSock();
        return sock.getCottonPart() < 0 || sock.getCottonPart() > 100 || sockItem.getQuantity() <= 0;
    }


    public int count(String color, int size, int cottonMin, int cottonMax) {
        Color c = Color.parse((color));
        Size s = Size.parse(size);
        if (Objects.isNull(c) || Objects.isNull(s) || cottonMin >= cottonMax || cottonMin < 0 || cottonMax > 100) {
            throw new IndexOutOfBoundsException();
        }
        for (Map.Entry<Sock, Integer> entry : socks.entrySet()) {
            Sock sock = entry.getKey();
            int availabe = entry.getValue();
            if (sock.getColor() == c && sock.getSize() == s && sock.getCottonPart() >= cottonMin && sock.getCottonPart() <= cottonMax) {
                return availabe;
            }
        }
        return 0;
    }

    public void remove(SockItem sockItem) {

    }
}
