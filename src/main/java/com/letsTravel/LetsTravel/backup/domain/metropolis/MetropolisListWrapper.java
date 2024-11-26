package com.letsTravel.LetsTravel.backup.domain.metropolis;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MetropolisListWrapper {
	private List<MetropolisReadDTO> metropolis;
}
