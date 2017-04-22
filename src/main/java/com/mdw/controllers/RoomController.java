package com.mdw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mdw.daos.RoomDao;
import com.mdw.entities.RoomEntity;
import com.mdw.wrappers.RoomWrapper;

import java.util.stream.Collectors;

@Controller
public class RoomController {

    private RoomDao roomDao;

    @Autowired
    public void setRoomDao(RoomDao roomDao){
        this.roomDao=roomDao;
    }

    public RoomWrapper getRoom(Long id){
        RoomEntity room= roomDao.findById(id);

        return RoomWrapper.builder()
                .id(room.getId())
                .hotelId(room.getHotel().getId())
                .roomType(room.getType().getType())
                .price(room.getType().getPrice())
                .singleBedCount(room.getSingleBedCount())
                .doubleBedCount(room.getDoubleBedCount())
                .queenBedCount(room.getQueenBedCount())
                .kingBedCount(room.getKingBedCount())
                .bathrooms(room.getType().getBathrooms())
                .hasTv(room.getType().getHasTv())
                .hasWifi(room.getType().getHasWifi())
                .hasHeating(room.getType().getHasHeating())
                .hasAirConditioning(room.getType().getHasAirConditioning())
                .images(room.getImages().stream().map(x -> x.getImage().getFilePath()).collect(Collectors.toList()))
                .build();
    }
}
