package com.company.remittance;

import com.company.remittance.entities.*;
import com.company.remittance.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@SpringBootApplication
public class RemittanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemittanceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(
//			CurrencyRepository currencyRepository,
//			UserRepository userRepository,
//			FundRepository fundRepository,
//			PersonRepository personRepository,
//			ExchangeRateRepository exchangeRateRepository,
//			PasswordEncoder passwordEncoder
//	) {
//		return args -> {
//			personRepository.save(new Person("Alex", "Jenkins", "Leroy"));
//			personRepository.save(new Person("Jake", "Johnson", "Caleb"));
//			var som = currencyRepository.save(new Currency("Kyrgyz som", "KGS"));
//			var dollar = currencyRepository.save(new Currency("United Sates dollar", "USD"));
//			exchangeRateRepository.save(new ExchangeRate(som, dollar, new BigDecimal("82.80"), new BigDecimal("83.80")));
//			var fundA = fundRepository.save(new Fund("Fund A", new BigDecimal("99999999.99"), som));
//			var fundB = fundRepository.save(new Fund("Fund B", new BigDecimal("99999999.99"), dollar));
//			userRepository.save(new User("userA", passwordEncoder.encode("userA"), fundA));
//			userRepository.save(new User("userB", passwordEncoder.encode("userB"), fundB));
//		};
//	}
}
