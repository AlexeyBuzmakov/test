package com.example.test.repository;

import com.example.test.dto.HouseCityStreetApartmentAmountDto;
import com.example.test.dto.HouseIdDto;
import com.example.test.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query(value = """
            SELECT NEW com.example.test.dto.HouseCityStreetApartmentAmountDto(h.number, c.name, s.name, COUNT (a.area)) 
            FROM House h
            INNER JOIN Apartment a on h.id = a.house.id
            INNER JOIN Street s on s.id = h.street.id
            INNER JOIN City c on c.id = s.city.id
            WHERE c.id = :cityId
            GROUP BY h.number, c.name, s.name
                """)
    List<HouseCityStreetApartmentAmountDto> getHousesByCityId(Long cityId);

    @Query(value = """
            SELECT NEW com.example.test.dto.HouseCityStreetApartmentAmountDto(h.number, c.name, s.name, COUNT (a.area)) 
            FROM House h
            INNER JOIN Apartment a on h.id = a.house.id
            INNER JOIN Street s on s.id = h.street.id
            INNER JOIN City c on c.id = s.city.id
            WHERE s.id = :streetId
            GROUP BY h.number, c.name, s.name
                """)
    List<HouseCityStreetApartmentAmountDto> getHousesByStreetId(Long streetId);

    @Query(value = """
            SELECT NEW com.example.test.dto.HouseIdDto(h.id) 
            FROM House h
            INNER JOIN Street s on s.id = h.street.id
            INNER JOIN City c on c.id = s.city.id
            WHERE c.name = :city AND s.name = :street AND h.number = :number
            """)
    Optional<HouseIdDto> getHouseIdByAddress(String city, String street, String number);
}
