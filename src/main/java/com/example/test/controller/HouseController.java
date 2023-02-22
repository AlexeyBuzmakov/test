package com.example.test.controller;

import com.example.test.dto.CityStreetHouseDto;
import com.example.test.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping(params = {"city_id"})
    public ResponseEntity<?> getHousesByCityId(@RequestParam ("city_id") Long cityId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(houseService.getHousesByCityId(cityId));
    }

    @GetMapping(params = {"street_id"})
    public ResponseEntity<?> getHousesByStreetId(@RequestParam ("street_id") Long streetId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(houseService.getHousesByStreetId(streetId));
    }

    @GetMapping
    public ResponseEntity<?> getHouseIdByAddress(@RequestBody CityStreetHouseDto cityStreetHouseDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(houseService.getHouseId(cityStreetHouseDto));
    }
}
