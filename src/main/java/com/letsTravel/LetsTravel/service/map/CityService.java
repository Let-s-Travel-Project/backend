package com.letsTravel.LetsTravel.service.map;

import com.letsTravel.LetsTravel.domain.map.entity.City;
import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.repository.map.CityRepository;
import com.letsTravel.LetsTravel.repository.map.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<City> getAllCities(String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);

        return cityRepository.findAllByCountry(country);
    }
    public City getCity(String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);

        return cityRepository.findCityByCityNameAndAndCountry(cityName, country);
    }

    public City addCity(String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = City.builder()
                .cityName(cityName)
                .country(country)
                .build();
        return cityRepository.save(city);
    }

    public City updateCity(String oldCityName, String newCityName, String countyName) {
        Country country = countryRepository.findCountryByCountryName(countyName);
        City existingCity = cityRepository.findCityByCityNameAndAndCountry(oldCityName, country);
        City updatedCity = City.builder()
                .id(existingCity.getId())
                .cityName(newCityName)
                .country(existingCity.getCountry())
                .build();
        return cityRepository.save(updatedCity);
    }

    public void deleteCity(String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);

        cityRepository.deleteAllByCityNameAndAndCountry(cityName,country);
    }


}
