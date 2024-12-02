package com.letsTravel.LetsTravel.domain.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class PageParamDto {

	private int page;
	private int size;
	private String orderby;
	private String sort = "DESC";

}
