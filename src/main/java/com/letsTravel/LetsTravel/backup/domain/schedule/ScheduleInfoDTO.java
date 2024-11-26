package com.letsTravel.LetsTravel.backup.domain.schedule;

import java.sql.Time;

import com.letsTravel.LetsTravel.backup.domain.place.Place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleInfoDTO {
	
	private int scheduleSeq;
	private Place place;
	private int dateSeq;
	private int visitSeq;
	private Time visitTime;
}
