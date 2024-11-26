package com.letsTravel.LetsTravel.backup.repository;

import com.letsTravel.LetsTravel.backup.domain.city.CityCreateDTO;
import com.letsTravel.LetsTravel.backup.domain.city.MetropolisCityCreateDTO;
import com.letsTravel.LetsTravel.backup.domain.city.PlaceCityCreateDTO;
import com.letsTravel.LetsTravel.backup.domain.metropolis.MetropolisCreateDTO;

public interface CityRepository {
	
	public Long addCity(CityCreateDTO cityCreateDTO, MetropolisCreateDTO metropolisCreateDTO);
	public int addMetropolisCity(MetropolisCityCreateDTO metropolisCityCreateDTO);
	public int addPlaceCity(PlaceCityCreateDTO placeCityCreateDTO);
}
