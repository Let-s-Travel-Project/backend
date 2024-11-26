package com.letsTravel.LetsTravel.backup.repository;

import java.util.List;

import com.letsTravel.LetsTravel.backup.domain.metropolis.MetropolisCreateDTO;
import com.letsTravel.LetsTravel.backup.domain.metropolis.MetropolisReadDTO;

public interface MetropolisRepository {

	public List<MetropolisReadDTO> findMetropolises(String keyword, List<String> countryCodeList);
	public int addMetropolis(MetropolisCreateDTO cityCreateDTO);
}
