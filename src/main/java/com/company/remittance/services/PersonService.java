package com.company.remittance.services;

import com.company.remittance.entities.Person;

public interface PersonService {
    Person find(String number);
}
