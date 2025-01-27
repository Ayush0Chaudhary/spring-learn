package com.example.triomics.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.triomics.dto.PersonDTO;
import com.example.triomics.entities.Person;
import com.example.triomics.services.PersonService;

import java.util.List;

/**
 * <ul>
 *   <li>REST controller for managing persons.</li>
 *   <li>Provides endpoints for creating, retrieving, updating, and deleting persons.</li>
 * </ul>
 * 
 * <p>Base URL: /api/v1/persons</p>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link PersonService} - Service layer for person operations</li>
 * </ul>
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>POST /api/v1/persons - Create a new person</li>
 *   <li>GET /api/v1/persons - Retrieve all persons</li>
 *   <li>GET /api/v1/persons/{id} - Retrieve a person by ID</li>
 *   <li>PUT /api/v1/persons/{id} - Update a person by ID</li>
 *   <li>DELETE /api/v1/persons/{id} - Delete a person by ID</li>
 * </ul>
 * 
 * <p>Author: Ayush Chaudhary</p>
 */
@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private static final Logger logger = LogManager.getLogger(PersonController.class);

    /**
     * Endpoint to create a new person.
     * 
     * @param personDTO Data transfer object containing person details.
     * @return ResponseEntity containing the created person.
     */
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.createPerson(personDTO));
    }

    /**
     * Endpoint to retrieve all persons.
     * 
     * @return ResponseEntity containing a list of all persons.
     */
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        logger.info("Fetching all persons.");
        logger.debug("Debugging getAllPersons method.");
        logger.error("Error occurred while fetching all persons.", new Exception("Sample exception"));
        return ResponseEntity.ok(personService.getAllPersons());
    }

    /**
     * Endpoint to retrieve a person by ID.
     * 
     * @param id ID of the person to retrieve.
     * @return ResponseEntity containing the person details.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    /**
     * Endpoint to update a person by ID.
     * 
     * @param id ID of the person to update.
     * @param personDTO Data transfer object containing updated person details.
     * @return ResponseEntity containing the updated person.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.updatePerson(id, personDTO));
    }

    /**
     * Endpoint to delete a person by ID.
     * 
     * @param id ID of the person to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
