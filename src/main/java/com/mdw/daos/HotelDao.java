package com.mdw.daos;

import com.mdw.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelDao extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findByCity(String city);
    List<HotelEntity> findByZipCode(String zipCode);
    List<HotelEntity> findByCityAndZipCode(String city, String zipCode);
}
