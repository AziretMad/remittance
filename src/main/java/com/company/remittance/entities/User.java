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
@Table(name = "users")
public class User extends AbstractEntity<Long> {
   @Column(unique = true, nullable = false)
   private String username;
   private String password;
   @ManyToOne
   @JoinColumn(name = "fund_id", nullable = false)
   private Fund fund;

   public User(String username, String password, Fund fund) {
      this.username = username;
      this.password = password;
      this.fund = fund;
   }
}
