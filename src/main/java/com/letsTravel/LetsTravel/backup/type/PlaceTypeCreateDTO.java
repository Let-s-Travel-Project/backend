package com.letsTravel.LetsTravel.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaceTypeCreateDTO {

	private long placeSeq;
	private String type;
}