package com.letsTravel.LetsTravel;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.repository.map.CountryRepository;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryRepositoryTest {
	
	@Autowired
	private CountryRepository countryRepository;

	@Test
	public void findAllConuntries() {
		Country country1 = Country.builder()
				.countryCode("A1")
				.countryName("A1Country")
				.countryNameTranslated("A1국가")
				.build();
		Country country2 = Country.builder()
				.countryCode("A2")
				.countryName("A2Country")
				.countryNameTranslated("A2국가")
				.build();
		
		Country savedCountry1 = countryRepository.save(country1);
		Country savedCountry2 = countryRepository.save(country2);
		
		List<Country> countryList = countryRepository.findAll();
		for(Country country: countryList)
			System.out.println(country.getCountryCode());
		Assertions.assertEquals(2, countryList.size());
	}
}
