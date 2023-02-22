package com.example.test.service.impl;

import com.example.test.dto.CityHouseAmountDto;
import com.example.test.repository.CityRepository;
import com.example.test.service.CityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    @Override
    public List<CityHouseAmountDto> getCities() {
        return cityRepository.getCities();
    }
}
