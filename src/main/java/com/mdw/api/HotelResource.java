package com.mdw.api;

import com.mdw.controllers.HotelController;
import com.mdw.wrappers.HotelCompleteWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(Uris.VERSION + Uris.HOTEL)
public class HotelResource {

    @Autowired
    private HotelController hotelController;

    @RequestMapping(method = RequestMethod.GET)
    public List<HotelCompleteWrapper> searchHotelsWithRooms(
        @RequestParam(name = "city", required = false) String city,
        @RequestParam(name = "zip_code", required = false) String zipCode) {
        List<HotelCompleteWrapper> hotelCompleteWrappers;

        if (city != null && city.length() != 0 && zipCode != null && zipCode.length() != 0) {
            hotelCompleteWrappers = hotelController.findHotelsCompleteByCityAndZipCode(city, zipCode);
        } else if (city != null && city.length() != 0) {
            hotelCompleteWrappers = hotelController.findHotelsCompleteByCity(city);
        } else if (zipCode != null && zipCode.length() != 0) {
            hotelCompleteWrappers = hotelController.findHotelsCompleteByZipCode(zipCode);
        } else {
            hotelCompleteWrappers = hotelController.findAllHotelsComplete();
        }

        return hotelCompleteWrappers;
    }
}
