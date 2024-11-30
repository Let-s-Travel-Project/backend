package com.letsTravel.LetsTravel.controller.map;

import com.letsTravel.LetsTravel.domain.map.dto.MapDto;
import com.letsTravel.LetsTravel.domain.map.entity.City;
import com.letsTravel.LetsTravel.service.map.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping("/list")
    public ResponseEntity<List<City>> getAllCities(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(cityService.getAllCities(mapDto.countryName));
    }

    @GetMapping
    public ResponseEntity<City> getCity(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(cityService.getCity(
                mapDto.cityName,
                mapDto.countryName
        ));
    }

    @PostMapping
    public ResponseEntity<City> addCity(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(cityService.addCity(
                mapDto.cityName,
                mapDto.countryName
        ));
    }

    @PutMapping
    public ResponseEntity<City> updateCity(
            @RequestParam String oldCityName,
            @RequestParam String newCityName,
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(cityService.updateCity(
                oldCityName,
                newCityName,
                mapDto.countryName
        ));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCity(
            @RequestBody MapDto mapDto
    ) {
        cityService.deleteCity(
                mapDto.cityName,
                mapDto.countryName
        );
        return ResponseEntity.noContent().build();
    }

}
