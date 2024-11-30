package com.letsTravel.LetsTravel.repository.map;

import com.letsTravel.LetsTravel.domain.map.entity.Poi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiRepositoy extends JpaRepository<Poi, Short> {

    Poi findByPoiName(String poiName);
}
