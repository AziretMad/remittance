package com.company.remittance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity<Long> {
   @Column(unique = true, nullable = false)
   private String username;
   private String password;
   @ManyToOne
   @JoinColumn(name = "fund_id", nullable = false)
   private Fund fund;
}
