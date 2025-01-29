package com.example.triomics.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.triomics.entities.Person;

/**
 * Repository interface for managing {@link Person} entities.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
