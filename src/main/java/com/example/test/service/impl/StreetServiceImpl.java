package com.example.test.service.impl;

import com.example.test.dto.StreetHouseAmountDto;
import com.example.test.repository.StreetRepository;
import com.example.test.service.StreetService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;
    @Override
    public List<StreetHouseAmountDto> getStreets(Long cityId) {
        return streetRepository.getStreets(cityId);
    }
}
