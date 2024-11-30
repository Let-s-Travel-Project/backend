package com.letsTravel.LetsTravel.repository.map;

import com.letsTravel.LetsTravel.domain.map.entity.City;
import com.letsTravel.LetsTravel.domain.map.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Short> {

    void deleteAllByCityNameAndAndCountry(String cityName, Country country);
    List<City> findAllByCountry(Country country);
    City findCityByCityNameAndAndCountry(String cityName, Country country);
}
