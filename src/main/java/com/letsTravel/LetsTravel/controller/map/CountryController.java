package com.letsTravel.LetsTravel.controller.map;

import com.letsTravel.LetsTravel.domain.map.dto.MapDto;
import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.domain.util.PageParamDto;
import com.letsTravel.LetsTravel.service.map.CountryService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {

	private final CountryService countryService;

	@GetMapping("list")
	public ResponseEntity<List<Country>> getAllCountries(@ModelAttribute("pageParamDto") PageParamDto pageParamDto) {
		System.out.println(pageParamDto);
		return ResponseEntity.ok(countryService.getAllCountries(pageParamDto));
	}

	@GetMapping
	public ResponseEntity<Country> getCountry(@RequestBody MapDto mapDto) {
		return ResponseEntity.ok(countryService.getCountryByCountryName(mapDto.countryName));
	}

}
