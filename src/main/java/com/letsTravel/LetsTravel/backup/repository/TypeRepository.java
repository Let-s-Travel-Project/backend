package com.letsTravel.LetsTravel.backup.repository;

import com.letsTravel.LetsTravel.backup.domain.type.PlaceTypeCreateDTO;
import com.letsTravel.LetsTravel.backup.domain.type.PrimaryTypeDetailDTO;
import com.letsTravel.LetsTravel.backup.domain.type.PrimaryTypeUpdateDTO;

public interface TypeRepository {

	public int modifyTypeNameTranslated(PrimaryTypeDetailDTO typeTranslateDTO);
	public int addPlaceType(PlaceTypeCreateDTO type);
	public int modifyPrimaryType(PrimaryTypeUpdateDTO primaryTypeUpdateDTO);
}
