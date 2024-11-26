package com.letsTravel.LetsTravel.backup.domain.plan;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlanInfoDTO {
	private int planSeq;
	private int memSeq;
	private String planName;
	private String countryCode;
	private Date planStart;
	private int planNDays;
}
