package com.research.yatilab.controller;

import com.research.yatilab.model.Contact;
import com.research.yatilab.repo.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000") // allow React dev server
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping
    public ResponseEntity<?> submitContact(@Valid @RequestBody Contact contact) {
        try {
            contactRepository.save(contact);
            return ResponseEntity.ok("Contact saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving contact");
        }
    }
}

