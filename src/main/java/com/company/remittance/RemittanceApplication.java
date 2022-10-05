package com.company.remittance;

import com.company.remittance.entities.Currency;
import com.company.remittance.entities.Person;
import com.company.remittance.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RemittanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemittanceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			CurrencyRepository currencyRepository,
			UserRepository userRepository,
			FundRepository fundRepository,
			PersonRepository personRepository,
			ExchangeRateRepository exchangeRateRepository
	) {
		return args -> {
			personRepository.save(new Person("Alex", "Jenkins", "Leroy"));
			personRepository.save(new Person("Jake", "Johnson", "Caleb"));
			var som = currencyRepository.save(new Currency("Kyrgyz som", "KGS"));
			var dollar = currencyRepository.save(new Currency("United Sates dollar", "USD"));
		};
	}
}
