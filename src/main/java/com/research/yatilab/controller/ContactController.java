package com.research.yatilab.controller;

import com.research.yatilab.model.Contact;
import com.research.yatilab.model.User;
import com.research.yatilab.repo.ContactRepository;
import com.research.yatilab.repo.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000") // allow React dev server
public class ContactController {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactController(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    // User submits contact info
    @PostMapping
    public ResponseEntity<?> submitContact(@Valid @RequestBody Contact contact, Principal principal) {
        try {
            // Principal comes from JWT authentication
            String username = principal.getName();
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            contact.setUser(user); // associate contact with logged-in user
            contactRepository.save(contact);

            return ResponseEntity.ok("Contact saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving contact");
        }
    }

    // IT support can view all contacts
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactRepository.findAll());
    }
}
