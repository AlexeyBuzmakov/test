package com.example.test.repository;

import com.example.test.dto.StreetHouseAmountDto;
import com.example.test.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

    @Query(value = """
            SELECT NEW com.example.test.dto.StreetHouseAmountDto(s.name, COUNT (h.number))
            FROM Street s
            INNER JOIN City c on s.city.id = c.id
            INNER JOIN House h on h.street.id = s.id
            WHERE c.id = :cityId
            GROUP BY s.name
            """)
    List<StreetHouseAmountDto> getStreets(Long cityId);
}
