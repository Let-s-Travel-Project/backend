package com.letsTravel.LetsTravel.backup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letsTravel.LetsTravel.backup.domain.metropolis.MetropolisListWrapper;
import com.letsTravel.LetsTravel.backup.service.MetropolisService;

@RestController
@RequestMapping(value = "/api")
public class MetropolisController {

	private final MetropolisService metropolisService;

	@Autowired
	public MetropolisController(MetropolisService metropolisService) {
		this.metropolisService = metropolisService;
	}

	@GetMapping("/metropolis")
	public MetropolisListWrapper readMetropolises(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "country-code", required = false) List<String> countryCodeList) {
		MetropolisListWrapper metropolisListWrapper = new MetropolisListWrapper(metropolisService.findMetropolises(keyword, countryCodeList));
		return metropolisListWrapper;
	}
}
