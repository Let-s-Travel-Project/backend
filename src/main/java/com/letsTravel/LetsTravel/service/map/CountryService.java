package com.letsTravel.LetsTravel.service.map;

import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.repository.map.CountryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Page<Country> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    public Country getCountryByCountryName(String countryName) {
        return countryRepository.findCountryByCountryName(countryName);
    }

}
