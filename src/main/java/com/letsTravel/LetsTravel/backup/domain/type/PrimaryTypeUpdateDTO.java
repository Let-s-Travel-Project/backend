package com.letsTravel.LetsTravel.backup.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrimaryTypeUpdateDTO {

	private long placeSeq;
	private String primaryType;
}
