package com.mdw.function;

import com.mdw.entities.ConfirmEntity;
import com.mdw.entities.ReservationEntity;
import com.mdw.entities.RoomEntity;
import com.mdw.wrappers.ReservationWrapper;

public class ReservationConverter {

    public static ReservationEntity wrapperToEntity(ReservationWrapper wrapper, RoomEntity room, ConfirmEntity confirm) {
        return ReservationEntity.builder()
                .numberOfPersons(wrapper.getNumberOfPersons())
                .reservationCode(wrapper.getReservationCode())
                .reservationDate(wrapper.getReservationDate())
                .confirmation(confirm)
                .room(room)
                .id(wrapper.getId())
                .build();
    }

    public static ReservationWrapper entityToWrapper(ReservationEntity entity) {
        return ReservationWrapper.builder()
                .numberOfPersons(entity.getNumberOfPersons())
                .reservationCode(entity.getReservationCode())
                .reservationDate(entity.getReservationDate())
                .confirmationId(entity.getConfirmation().getId())
                .roomId(entity.getRoom().getId())
                .id(entity.getId())
                .build();
    }
}
