package com.example.test.repository;

import com.example.test.dto.CityHouseAmountDto;
import com.example.test.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = """
            SELECT NEW com.example.test.dto.CityHouseAmountDto(c.name, COUNT (h.number))  
            FROM City c
            INNER JOIN Street s on s.city.id = c.id
            INNER JOIN House h on h.street.id = s.id
            GROUP BY c.name
            """)
    List<CityHouseAmountDto> getCities();
}
