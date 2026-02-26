package com.research.yatilab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name; @Email(message = "Email should be valid")

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Subject is required")
    private String subject;

    @Size(min = 10, message = "Message must be at least 10 characters long")
    private String message;

    // Many contacts belong to one user
    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
