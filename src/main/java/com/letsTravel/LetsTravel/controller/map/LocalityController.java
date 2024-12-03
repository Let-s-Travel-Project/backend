package com.letsTravel.LetsTravel.controller.map;

import com.letsTravel.LetsTravel.domain.map.dto.MapDto;
import com.letsTravel.LetsTravel.domain.map.entity.Locality;
import com.letsTravel.LetsTravel.service.map.LocalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/localities")
public class LocalityController {

    private final LocalityService localityService;

    @GetMapping("/list")
    public ResponseEntity<List<Locality>> getAllLocalities(
            @ModelAttribute MapDto mapDto
    ) {
        return ResponseEntity.ok(localityService.getAllLocalities(
                mapDto.cityName,
                mapDto.countryName
        ));
    }

    @GetMapping
    public ResponseEntity<Locality> getLocality(
            @ModelAttribute MapDto mapDto
    ) {
        return ResponseEntity.ok(localityService.getLocality(
                mapDto.localityName,
                mapDto.cityName,
                mapDto.countryName
        ));
    }

    @PostMapping
    public ResponseEntity<Locality> addLocality(
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(localityService.addLocality(
                mapDto.localityName,
                mapDto.cityName,
                mapDto.countryName
        ));
    }

    @PutMapping
    public ResponseEntity<Locality> updateLocality(
            @RequestParam String oldLocalityName,
            @RequestParam String newLocalityName,
            @RequestBody MapDto mapDto
    ) {
        return ResponseEntity.ok(
                localityService.updateLocality(
                        oldLocalityName,
                        newLocalityName,
                        mapDto.cityName,
                        mapDto.countryName
                ));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLocality(
            @RequestBody MapDto mapDto
    ) {
        localityService.deleteLocality(
                mapDto.localityName,
                mapDto.cityName,
                mapDto.countryName
        );
        return ResponseEntity.noContent().build();
    }

}
