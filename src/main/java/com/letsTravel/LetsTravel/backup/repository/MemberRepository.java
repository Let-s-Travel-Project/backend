package com.letsTravel.LetsTravel.backup.repository;

import java.util.List;

import com.letsTravel.LetsTravel.backup.domain.member.MemberBasicInfoReadDTO;

public interface MemberRepository {
	List<MemberBasicInfoReadDTO> findPlanShareMemberByPlanSeq(int planSeq);
}
