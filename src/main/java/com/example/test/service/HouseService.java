package com.example.test.service;

import com.example.test.dto.CityStreetHouseDto;
import com.example.test.dto.HouseCityStreetApartmentAmountDto;

import java.util.List;

public interface HouseService {
    List<HouseCityStreetApartmentAmountDto> getHousesByCityId(Long cityId);

    List<HouseCityStreetApartmentAmountDto> getHousesByStreetId(Long streetId);

    Object getHouseId(CityStreetHouseDto cityStreetHouseDto);
}
