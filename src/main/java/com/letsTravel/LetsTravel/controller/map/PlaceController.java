package com.letsTravel.LetsTravel.controller.map;

import com.letsTravel.LetsTravel.domain.map.dto.MapDto;
import com.letsTravel.LetsTravel.domain.map.entity.Place;
import com.letsTravel.LetsTravel.service.map.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("list")
    public ResponseEntity<List<Place>> getAllPlaces(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(placeService.getAllPlaces(
                mapDto.localityName,
                mapDto.cityName,
                mapDto.countryName
        ));
    }

    @GetMapping
    public ResponseEntity<Place> getPlace(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(placeService.getPlace(
                mapDto.placeName,
                mapDto.localityName,
                mapDto.cityName,
                mapDto.countryName
        ));
    }

    @PostMapping
    public ResponseEntity<Place> addPlace(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(placeService.addPlace(mapDto.latitude, mapDto.longitude));
    }

    @PutMapping
    public ResponseEntity<Place> updatePlace(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(placeService.updatePlace(mapDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePlace(
            @RequestBody MapDto mapDto
    ) {
        placeService.deletePlace(mapDto);
        return ResponseEntity.noContent().build();
    }

}
