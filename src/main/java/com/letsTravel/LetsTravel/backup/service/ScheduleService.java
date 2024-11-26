package com.letsTravel.LetsTravel.backup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsTravel.LetsTravel.backup.domain.schedule.ScheduleUpdateDTO;
import com.letsTravel.LetsTravel.backup.repository.ScheduleRepository;

@Service
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;

	public ScheduleService(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	public int updateSchedule(List<ScheduleUpdateDTO> scheduleUpdateList) {
		int result = 0;
		for (int i = 0; i < scheduleUpdateList.size(); i++) {
			result += scheduleRepository.modifySchedule(scheduleUpdateList.get(i));
		}
		return result;
	}

}
