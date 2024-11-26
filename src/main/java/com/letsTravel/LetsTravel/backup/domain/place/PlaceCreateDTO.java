package com.letsTravel.LetsTravel.backup.domain.place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceCreateDTO {

	private String id;
	private String displayName;
	private String languageCode;
	private String formattedAddress;
	private Location location;
	private String googleMapsUri;

}
