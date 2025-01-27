package com.example.triomics.dto;


import lombok.*;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for Person.
 * This class is used to transfer person data between processes.
 * 
 * <p>Annotations used:
 * <ul>
 *   <li>{@code @Data} - Generates getters, setters, toString, equals, and hashCode methods.</li>
 *   <li>{@code @NoArgsConstructor} - Generates a no-argument constructor.</li>
 *   <li>{@code @AllArgsConstructor} - Generates a constructor with all fields as parameters.</li>
 *   <li>{@code @Builder} - Implements the builder pattern for object creation.</li>
 * </ul>
 * 
 * <p>Fields:
 * <ul>
 *   <li>{@code name} - The name of the person.</li>
 *   <li>{@code dob} - The date of birth of the person.</li>
 *   <li>{@code email} - The email address of the person.</li>
 *   <li>{@code address} - The physical address of the person.</li>
 * </ul>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {
    private String name;
    private LocalDateTime dob;
    private String email;
    private String address;
}
