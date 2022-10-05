package com.company.remittance.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private T id;
}
