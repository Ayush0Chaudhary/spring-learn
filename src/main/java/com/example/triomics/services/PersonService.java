package com.example.triomics.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.example.triomics.dto.PersonDTO;
import com.example.triomics.entities.Person;
import com.example.triomics.exception.ResourceNotFoundException;
import com.example.triomics.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Person entities.
 * Provides methods for creating, retrieving, updating, and deleting Person records.
 * Utilizes PersonRepository for database operations and maps between Person and PersonDTO.
 * 
 * Annotations:
 * - @Service: Indicates that this class is a Spring service component.
 * - @Slf4j: Provides a logger instance for logging purposes.
 * - @RequiredArgsConstructor: Generates a constructor with required arguments (final fields).
 * 
 * Methods:
 * - createPerson(PersonDTO personDTO): Creates a new Person entity from the provided PersonDTO and saves it to the database.
 * - getAllPersons(): Retrieves all Person entities from the database and maps them to PersonDTOs.
 * - getPersonById(Long id): Retrieves a Person entity by its ID and maps it to a PersonDTO. Throws ResourceNotFoundException if not found.
 * - updatePerson(Long id, PersonDTO personDTO): Updates an existing Person entity with the provided PersonDTO data. Throws ResourceNotFoundException if not found.
 * - deletePerson(Long id): Deletes a Person entity by its ID. Throws ResourceNotFoundException if not found.
 * - toEntity(PersonDTO dto): Converts a PersonDTO to a Person entity.
 * - toDTO(Person entity): Converts a Person entity to a PersonDTO.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person createPerson(PersonDTO personDTO) {
        return personRepository.save(toEntity(personDTO));
    }

    public List<PersonDTO> getAllPersons() {
        log.info("Fetching all persons");
        return personRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO getPersonById(Long id) {
        Person personFromDb = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        return toDTO(personFromDb);
    }

    public Person updatePerson(Long id, PersonDTO personDTO) {
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        existingPerson.setName(personDTO.getName());
        existingPerson.setDob(personDTO.getDob());
        existingPerson.setEmail(personDTO.getEmail());
        existingPerson.setAddress(personDTO.getAddress());
        return personRepository.save(existingPerson);
    }

    public void deletePerson(Long id) {
        personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        personRepository.deleteById(id);
    }

    private Person toEntity(PersonDTO dto) {
        return Person.builder()
                .name(dto.getName())
                .dob(dto.getDob())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();
    }

    private PersonDTO toDTO(Person entity) {
        return PersonDTO.builder()
                .name(entity.getName())
                .dob(entity.getDob())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .build();
    }
}
