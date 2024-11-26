package com.letsTravel.LetsTravel.backup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsTravel.LetsTravel.backup.domain.schedule.ScheduleUpdateDTO;
import com.letsTravel.LetsTravel.backup.service.ScheduleService;

@RestController
@RequestMapping("/api")
public class ScheduleController {

	private final ScheduleService scheduleService;
	
	@Autowired
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	@PutMapping("/schedule")
	public int updateSchedule(@RequestBody List<ScheduleUpdateDTO> scheduleUpdateList) {
		return scheduleService.updateSchedule(scheduleUpdateList);
	}
}
