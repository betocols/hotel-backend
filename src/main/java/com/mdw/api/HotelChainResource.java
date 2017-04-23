package com.mdw.api;

import com.mdw.controllers.HotelChainController;
import com.mdw.entities.HotelChainEntity;
import com.mdw.wrappers.HotelChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Uris.VERSION + Uris.CHAIN)
public class HotelChainResource {

    @Autowired
    private HotelChainController hotelChainController;

    @RequestMapping(method = RequestMethod.POST)
    public void saveCadena(@RequestBody HotelChainWrapper hotelChainWrapper) {
        hotelChainController.saveHotelChain(hotelChainWrapper);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<HotelChainEntity> getAllCadenas() {
        return hotelChainController.getAllCadenas();
    }
}
