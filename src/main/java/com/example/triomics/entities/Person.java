package com.example.triomics.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dob;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;
}
