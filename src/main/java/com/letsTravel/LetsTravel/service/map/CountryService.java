package com.letsTravel.LetsTravel.service.map;

import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.domain.util.PageParamDto;
import com.letsTravel.LetsTravel.repository.map.CountryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

	private final CountryRepository countryRepository;

	public List<Country> getAllCountries(PageParamDto pageParamDto) {
		Pageable pageable = PageRequest.of(pageParamDto.getPage(), pageParamDto.getSize(), Sort.by(Sort.Direction.fromString(pageParamDto.getSort()), pageParamDto.getOrderby()));
		return countryRepository.findAll(pageable).getContent();
	}

	public Country getCountryByCountryName(String countryName) {
		return countryRepository.findCountryByCountryName(countryName);
	}

}
