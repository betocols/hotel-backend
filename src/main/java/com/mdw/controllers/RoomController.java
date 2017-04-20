package com.mdw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mdw.daos.RoomDao;
import com.mdw.entities.RoomEntity;
import com.mdw.wrappers.RoomWrapper;

@Controller
public class RoomController {

    private RoomDao roomDao;
    
    @Autowired
    public void setRoomDao(RoomDao roomDao){
        this.roomDao=roomDao;
    }
    
    public RoomWrapper getRoom(Long id){
        RoomEntity room= roomDao.findById(id);
        Long identificador=room.getId();
        String image=room.getImage();
        String type=room.getType();
        String extraServices=room.getExtraServices();
        int hotel=room.getHotel();
        double price=room.getPrice();
        return new RoomWrapper(identificador, image, type, extraServices, hotel, price);
    }
}
