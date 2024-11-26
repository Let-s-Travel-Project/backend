package com.letsTravel.LetsTravel.backup.domain.schedule;

import java.sql.Time;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleCreateDTO {

	private int planSeq;
	private String placeId;
	private int dateSeq;
	private int visitSeq;
	private Time visitTime;
	
	public ScheduleCreateDTO(ScheduleInfoDTO scheduleDetailDTO) {
		this.placeId = scheduleDetailDTO.getPlace().getId();
		this.dateSeq = scheduleDetailDTO.getDateSeq();
		this.visitSeq = scheduleDetailDTO.getVisitSeq();
		this.visitTime = scheduleDetailDTO.getVisitTime();
	}
}