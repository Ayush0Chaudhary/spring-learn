package com.example.triomics.dto;


import lombok.*;

import java.time.LocalDateTime;

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
