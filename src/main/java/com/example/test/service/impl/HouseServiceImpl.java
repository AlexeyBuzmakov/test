package com.example.test.service.impl;

import com.example.test.dto.CityStreetHouseDto;
import com.example.test.dto.HouseCityStreetApartmentAmountDto;
import com.example.test.dto.HouseIdDto;
import com.example.test.dto.SuccessMessageDto;
import com.example.test.repository.HouseRepository;
import com.example.test.service.HouseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Override
    public List<HouseCityStreetApartmentAmountDto> getHousesByCityId(Long cityId) {
        return houseRepository.getHousesByCityId(cityId);
    }

    @Override
    public List<HouseCityStreetApartmentAmountDto> getHousesByStreetId(Long streetId) {
        return houseRepository.getHousesByStreetId(streetId);
    }

    @Override
    public Object getHouseId(CityStreetHouseDto cityStreetHouseDto) {
        //Непонетный момент с получением города, улицы и дома из строки, которая содержит адрес сделал через принимаемый DTO
        Optional<HouseIdDto> houseIdDto = houseRepository.getHouseIdByAddress(
                cityStreetHouseDto.city(),
                cityStreetHouseDto.street(),
                cityStreetHouseDto.house());
        if (houseIdDto.isPresent())
            return houseIdDto;
        return new SuccessMessageDto(false, "Address not found");
    }
}
