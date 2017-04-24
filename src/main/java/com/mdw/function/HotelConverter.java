package com.mdw.function;

import com.mdw.entities.HotelEntity;
import com.mdw.wrappers.HotelCompleteWrapper;
import com.mdw.wrappers.RoomWrapper;

import java.util.List;
import java.util.stream.Collectors;

public class HotelConverter {

    public static HotelCompleteWrapper entityToWrapper(HotelEntity entity) {
        HotelCompleteWrapper hotelCompleteWrapper =
                HotelCompleteWrapper.builder()
                .id(entity.getId())
                .name(entity.getName())
                .addressLine(entity.getAddressLine())
                .city(entity.getCity())
                .province(entity.getProvince())
                .zipCode(entity.getZipCode())
                .hotelChainName(entity.getHotelChain().getName())
                .build();

        List<RoomWrapper> roomWrapperList =
                entity.getRooms().stream()
                        .map(roomEntity -> RoomConverter.entityToWrapper(roomEntity)).collect(Collectors.toList());
        hotelCompleteWrapper.setRooms(roomWrapperList);

        return hotelCompleteWrapper;
    }
}
