package com.example.test.controller;

import com.example.test.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/streets")
@RequiredArgsConstructor
public class StreetController {

    private final StreetService streetService;

    @GetMapping
    public ResponseEntity<?> getStreets(@RequestParam("city_id") Long cityId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(streetService.getStreets(cityId));
    }
}
