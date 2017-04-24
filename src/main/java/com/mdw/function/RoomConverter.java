package com.mdw.function;

import com.mdw.entities.RoomEntity;
import com.mdw.wrappers.RoomWrapper;

public class RoomConverter {

    public static RoomWrapper entityToWrapper(RoomEntity entity) {
        RoomWrapper roomWrapper =
                RoomWrapper.builder()
                .id(entity.getId())
                .hotelId(entity.getHotel().getId())
                .roomType(entity.getType().getType())
                .price(entity.getType().getPrice())
                .singleBedCount(entity.getSingleBedCount())
                .doubleBedCount(entity.getDoubleBedCount())
                .queenBedCount(entity.getQueenBedCount())
                .kingBedCount(entity.getKingBedCount())
                .bathrooms(entity.getType().getBathrooms())
                .maxPersons(entity.getType().getMaxPersons())
                .hasTv(entity.getType().getHasTv())
                .hasWifi(entity.getType().getHasWifi())
                .hasHeating(entity.getType().getHasHeating())
                .hasAirConditioning(entity.getType().getHasAirConditioning())
                .build();

        return roomWrapper;
    }
}