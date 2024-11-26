package com.letsTravel.LetsTravel.backup.domain.city;

import com.letsTravel.LetsTravel.backup.domain.metropolis.MetropolisCreateDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MetropolisCityCreateDTO {

	private MetropolisCreateDTO metropolisCreateDTO;
	private long citySeq;
}
