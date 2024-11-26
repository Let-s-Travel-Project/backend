package com.letsTravel.LetsTravel.backup.domain.plan;

import java.util.List;

import com.letsTravel.LetsTravel.backup.domain.member.MemberBasicInfoReadDTO;
import com.letsTravel.LetsTravel.backup.domain.schedule.ScheduleInfoDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlanDetailDTO {
	private PlanInfoDTO planInfo;
	private List<MemberBasicInfoReadDTO> planShareMembers;
	private List<ScheduleInfoDTO> schedules;
}