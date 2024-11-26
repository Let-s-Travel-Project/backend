package com.letsTravel.LetsTravel.backup.repository;

import java.util.List;

import com.letsTravel.LetsTravel.backup.domain.schedule.ScheduleCreateDTO;
import com.letsTravel.LetsTravel.backup.domain.schedule.ScheduleInfoDTO;
import com.letsTravel.LetsTravel.backup.domain.schedule.ScheduleUpdateDTO;

public interface ScheduleRepository {

	int addSchedule(ScheduleCreateDTO scheduleCreateDTO);
	int modifySchedule(ScheduleUpdateDTO scheduleUpdateDTO);
	List<ScheduleInfoDTO> findSchedulesByPlanSeq(int planSeq);
}
