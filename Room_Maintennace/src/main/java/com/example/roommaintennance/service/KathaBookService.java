package com.example.roommaintennance.service;



import com.example.roommaintennance.model.KathaBook;
import com.example.roommaintennance.repository.KathaBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KathaBookService {

    @Autowired
    private KathaBookRepository kathaBookRepository;

    // Add new item to the database
    public KathaBook addItem(KathaBook kathaBook) {
        return kathaBookRepository.save(kathaBook);
    }

    // Modify an existing item
    public Optional<KathaBook> modifyItem(Long id, KathaBook kathaBook) {
        Optional<KathaBook> existingItem = kathaBookRepository.findById(id);
        if (existingItem.isPresent()) {
            KathaBook updatedItem = existingItem.get();
            updatedItem.setItemName(kathaBook.getItemName());
            updatedItem.setDescription(kathaBook.getDescription());
            updatedItem.setStatus(kathaBook.getStatus());
            return Optional.of(kathaBookRepository.save(updatedItem));
        }
        return Optional.empty();
    }

    // Get all items
    public List<KathaBook> getAllItems() {
        return kathaBookRepository.findAll();
    }
}

