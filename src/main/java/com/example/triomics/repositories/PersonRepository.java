package com.example.triomics.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.triomics.entities.Person;

/**
 * Repository interface for managing {@link Person} entities.
 * 
 * <p>This interface extends {@link JpaRepository} which provides JPA related methods
 * for standard data access operations such as saving, deleting, and finding entities.
 * The {@link PersonRepository} interface is annotated with {@link Repository} to indicate
 * that it's a Spring Data repository.</p>
 * 
 * <p>By extending {@link JpaRepository}, this interface inherits several methods for working
 * with {@link Person} persistence, including methods for saving, deleting, and finding {@link Person} entities.
 * The generic parameters specify the domain type as {@link Person} and the ID type as {@link Long}.</p>
 * 
 * <p>Spring Data JPA will automatically provide the implementation for this interface at runtime.</p>
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
