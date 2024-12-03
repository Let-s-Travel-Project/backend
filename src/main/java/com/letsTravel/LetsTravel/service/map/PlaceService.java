package com.letsTravel.LetsTravel.service.map;

import com.letsTravel.LetsTravel.domain.map.dto.MapDto;
import com.letsTravel.LetsTravel.domain.map.entity.*;
import com.letsTravel.LetsTravel.repository.map.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final LocalityRepository localityRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<Place> getAllPlaces(String localityName, String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = cityRepository.findCityByCityNameAndAndCountry(cityName, country);
        Locality locality = localityRepository.findByCityAndAndLocalityName(city, localityName);

        return placeRepository.findAllByLocality(locality);
    }

    public Place getPlace(String placeName, String localityName, String cityName, String countryName) {
        Country country = countryRepository.findCountryByCountryName(countryName);
        City city = cityRepository.findCityByCityNameAndAndCountry(cityName, country);
        Locality locality = localityRepository.findByCityAndAndLocalityName(city, localityName);

        return placeRepository.findByLocalityAndPlaceName(locality, placeName);
    }

    public Place addPlace(
            String latitude,
            String longitude
    ) {
        // geocoding 로직
        // 토큰도 저장해야함.
        Place place = Place.builder().build();
        return place;   // placeRepository.save(place);
    }

    public Place updatePlace(MapDto mapDto) {

        // 로직 추가
        Place place = Place.builder().build();

        return place;
    }

    public void deletePlace(MapDto mapDto) {
        // 로직 추가

        placeRepository.deleteById(1);
    }
}
