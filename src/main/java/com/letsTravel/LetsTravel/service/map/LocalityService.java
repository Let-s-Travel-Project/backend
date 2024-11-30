package com.letsTravel.LetsTravel.service.map;

import com.letsTravel.LetsTravel.domain.map.entity.City;
import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.domain.map.entity.Locality;
import com.letsTravel.LetsTravel.repository.map.CityRepository;
import com.letsTravel.LetsTravel.repository.map.CountryRepository;
import com.letsTravel.LetsTravel.repository.map.LocalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalityService {

    private final LocalityRepository localityRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<Locality> getAllLocalities(String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = cityRepository.findCityByCityNameAndAndCountry(cityName, country);

        return localityRepository.findAllByCity(city);
    }

    public Locality getLocality(String localityName, String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = cityRepository.findCityByCityNameAndAndCountry(cityName, country);

        return localityRepository.findByCityAndAndLocalityName(city, localityName);
    }

    public Locality addLocality(String localityName, String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = cityRepository.findCityByCityNameAndAndCountry(cityName, country);
        Locality locality = Locality.builder()
                .localityName(localityName)
                .city(city)
                .build();

        return localityRepository.save(locality);
    }

    public Locality updateLocality(
            String oldLocalityName,
            String newLocalityName,
            String cityName,
            String countryName
    ) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = cityRepository.findCityByCityNameAndAndCountry(cityName, country);
        Locality existingLocality = localityRepository.findByCityAndAndLocalityName(city, oldLocalityName);
        Locality updatedLocality = Locality.builder()
                .id(existingLocality.getId())
                .localityName(newLocalityName)
                .build();

        return localityRepository.save(updatedLocality);
    }

    public void deleteLocality(String localityName, String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = cityRepository.findCityByCityNameAndAndCountry(cityName, country);

        localityRepository.deleteByCityAndLocalityName(city, localityName);
    }

}
