package com.example.triomics.controllers;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.triomics.dto.PersonDTO;
import com.example.triomics.entities.Person;
import com.example.triomics.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.createPerson(personDTO));
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.updatePerson(id, personDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
