package com.letsTravel.LetsTravel.repository.map;

import com.letsTravel.LetsTravel.domain.map.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findCountryByCountryName(String countryName);

}
