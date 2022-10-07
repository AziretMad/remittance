package com.company.remittance.repositories;

import com.company.remittance.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByNumber(UUID number);
}
