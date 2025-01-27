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
