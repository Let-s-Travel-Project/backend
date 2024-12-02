package com.letsTravel.LetsTravel.repository.map;

import com.letsTravel.LetsTravel.domain.map.entity.Country;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findCountryByCountryName(String countryName);
}
