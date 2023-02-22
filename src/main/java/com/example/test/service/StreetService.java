package com.example.test.service;

import com.example.test.dto.StreetHouseAmountDto;

import java.util.List;

public interface StreetService {

    List<StreetHouseAmountDto> getStreets(Long cityId);
}
