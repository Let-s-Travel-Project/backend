package com.letsTravel.LetsTravel.repository.map;

import com.letsTravel.LetsTravel.domain.map.entity.Locality;
import com.letsTravel.LetsTravel.domain.map.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findAllByLocality(Locality locality);

    Place findByLocalityAndPlaceName(Locality locality, String placeName);
}
