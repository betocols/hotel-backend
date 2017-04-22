package com.mdw.controllers;

import com.mdw.daos.HotelChainDao;
import com.mdw.entities.HotelChainEntity;
import com.mdw.wrappers.HotelChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HotelChainController {

    @Autowired
    private HotelChainDao hotelChainDao;

    public void saveHotelChain(HotelChainWrapper hotelChainWrapper) {
        HotelChainEntity hotelChainEntity = HotelChainEntity.builder()
                .name(hotelChainWrapper.getName())
                .build();
        hotelChainDao.save(hotelChainEntity);
    }

    public List<HotelChainEntity> getAllCadenas() {
        return hotelChainDao.findAll();
    }
}
