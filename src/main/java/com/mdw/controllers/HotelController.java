package com.mdw.controllers;

import com.mdw.daos.HotelDao;
import com.mdw.entities.HotelEntity;
import com.mdw.function.HotelConverter;
import com.mdw.wrappers.HotelCompleteWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HotelController {

    private HotelDao hotelDao;

    @Autowired
    public void setHotelDao(HotelDao hotelDao){
        this.hotelDao = hotelDao;
    }

    public List<HotelCompleteWrapper> findAllHotelsComplete() {
        List<HotelEntity> hotelEntityList = hotelDao.findAll();
        List<HotelCompleteWrapper> hotelCompleteWrappers =
                hotelEntityList.stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        return hotelCompleteWrappers;
    }

    public List<HotelCompleteWrapper> findHotelsCompleteByCityAndZipCode(String city, String zipCode) {
        List<HotelEntity> hotelEntityList = hotelDao.findByCityAndZipCode(city, zipCode);
        List<HotelCompleteWrapper> hotelCompleteWrappers =
                hotelEntityList.stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        return hotelCompleteWrappers;
    }

    public List<HotelCompleteWrapper> findHotelsCompleteByCity(String city) {
        List<HotelEntity> hotelEntityList = hotelDao.findByCity(city);
        List<HotelCompleteWrapper> hotelCompleteWrappers =
                hotelEntityList.stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        return hotelCompleteWrappers;
    }

    public List<HotelCompleteWrapper> findHotelsCompleteByZipCode(String zipCode) {
        List<HotelEntity> hotelEntityList = hotelDao.findByZipCode(zipCode);
        List<HotelCompleteWrapper> hotelCompleteWrappers =
                hotelEntityList.stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        return hotelCompleteWrappers;
    }
}
