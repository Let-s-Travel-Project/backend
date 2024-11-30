package com.letsTravel.LetsTravel.repository.map;

import com.letsTravel.LetsTravel.domain.map.entity.City;
import com.letsTravel.LetsTravel.domain.map.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Integer> {

    void deleteByCityAndLocalityName(City city, String localityName);
    List<Locality> findAllByCity(City city);
    Locality findByCityAndAndLocalityName(City city, String localityName);

}
