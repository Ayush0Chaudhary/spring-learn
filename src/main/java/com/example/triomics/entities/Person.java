package com.example.triomics.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



/**
 * Represents a person entity with basic personal information.
 * This class is annotated with JPA and Lombok annotations to facilitate
 * database operations and reduce boilerplate code.
 * 
 * Annotations:
 * <ul>
 *   <li>@Entity: Specifies that the class is an entity and is mapped to a database table.</li>
 *   <li>@Data: A Lombok annotation to generate getters, setters, toString, equals, and hashCode methods.</li>
 *   <li>@NoArgsConstructor: A Lombok annotation to generate a no-argument constructor.</li>
 *   <li>@AllArgsConstructor: A Lombok annotation to generate a constructor with all fields.</li>
 *   <li>@Builder: A Lombok annotation to implement the builder pattern for the class.</li>
 * </ul>
 * 
 * Fields:
 * <ul>
 *   <li>id: The unique identifier for the person. It is auto-generated.</li>
 *   <li>name: The name of the person. This field is mandatory.</li>
 *   <li>dob: The date of birth of the person. This field is mandatory.</li>
 *   <li>email: The email address of the person. This field is mandatory and must be unique.</li>
 *   <li>address: The address of the person. This field is mandatory.</li>
 * </ul>
 */
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
