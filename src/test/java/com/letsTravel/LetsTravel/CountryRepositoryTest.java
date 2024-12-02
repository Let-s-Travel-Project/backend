package com.letsTravel.LetsTravel;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public void findAllConuntriesByOrderByCountryNameTranslatedTest() {
		Country country1 = Country.builder().countryCode("A1").countryName("A1Country").countryNameTranslated("2").build();
		Country country2 = Country.builder().countryCode("A2").countryName("A2Country").countryNameTranslated("3").build();
		Country country3 = Country.builder().countryCode("A3").countryName("A3Country").countryNameTranslated("0").build();
		Country country4 = Country.builder().countryCode("A4").countryName("A4Country").countryNameTranslated("1").build();

		Country savedCountry1 = countryRepository.save(country1);
		Country savedCountry2 = countryRepository.save(country2);
		Country savedCountry3 = countryRepository.save(country3);
		Country savedCountry4 = countryRepository.save(country4);

		List<Country> countryList = countryRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "countryNameTranslated"))).getContent();
		for (int i = 0; i < countryList.size(); i++) {
			System.out.println(countryList.get(i).getCountryNameTranslated());
			Assertions.assertEquals(i, Integer.parseInt(countryList.get(i).getCountryNameTranslated()));
		}
		Assertions.assertEquals(4, countryList.size());
	}
}
