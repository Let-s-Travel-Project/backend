package com.letsTravel.LetsTravel.controller.map;

import com.letsTravel.LetsTravel.domain.map.dto.MapDto;
import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.service.map.CountryService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {

	private final CountryService countryService;

	@GetMapping("/list")
	public ResponseEntity<List<Country>> getAllCountries(
			@RequestParam(value = "page") int page,
			@RequestParam(value = "size") int size,
			@RequestParam(value = "orderby") String orderBy,
			@RequestParam(value = "sort") String sort
			) {
		Pageable pageable = sort.equals("DESC") ? PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, orderBy)): PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, orderBy));
		return ResponseEntity.ok(countryService.getAllCountries(pageable).getContent());
	}

	@GetMapping
	public ResponseEntity<Country> getCountry(@RequestBody MapDto mapDto) {
		return ResponseEntity.ok(countryService.getCountryByCountryName(mapDto.countryName));
	}

}
