package com.example.kursach33.controller;


import com.example.kursach33.model.SockItem;
import com.example.kursach33.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")

public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public ResponseEntity<?> addSock(@RequestBody SockItem sockItem) {
        storeService.add(sockItem);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> minus(@RequestBody SockItem sockItem) {
        storeService.minus(sockItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Integer> count(@RequestParam String color,
                                         @RequestParam int size,
                                         @RequestParam int cottonMin,
                                         @RequestParam int cottonMax) {
        int availabe = storeService.count(color, size, cottonMin, cottonMax);
        return ResponseEntity.ok(availabe);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody SockItem sockItem) {
        storeService.remove(sockItem);
        return ResponseEntity.ok().build();
    }
}
