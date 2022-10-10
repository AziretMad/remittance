package com.company.remittance.services.impl;

import com.company.remittance.entities.Person;
import com.company.remittance.exceptions.InvalidPersonNumberException;
import com.company.remittance.repositories.PersonRepository;
import com.company.remittance.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
   private final PersonRepository personRepository;

   @Override
   public Person find(String number) {
      return personRepository
              .findByNumber(parseNumber(number))
              .orElseThrow(() -> new EntityNotFoundException("Person not found. Number: " + number));
   }

   private UUID parseNumber(String number) {
      try {
         return UUID.fromString(number);
      } catch (IllegalArgumentException e) {
         throw new InvalidPersonNumberException("Invalid person number");
      }
   }
}
