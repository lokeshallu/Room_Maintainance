package com.example.roommaintennance.controller;


import com.example.roommaintennance.model.KathaBook;
import com.example.roommaintennance.service.KathaBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/katha")
public class KathaBookController {

    @Autowired
    private KathaBookService kathaBookService;

    
    // Endpoint to add new item
    @PostMapping("/add")
    public ResponseEntity<KathaBook> addItem(@RequestBody KathaBook kathaBook) {
        KathaBook newItem = kathaBookService.addItem(kathaBook);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    // Endpoint to modify existing item
    @PutMapping("/modify/{id}")
    public ResponseEntity<KathaBook> modifyItem(@PathVariable Long id, @RequestBody KathaBook kathaBook) {
        Optional<KathaBook> updatedItem = kathaBookService.modifyItem(id, kathaBook);
        return updatedItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint to get all items
    @GetMapping("/all")
    public List<KathaBook> getAllItems() {
        return kathaBookService.getAllItems();
    }
}


