package com.mdw.controllers;

import com.mdw.daos.ReservationDao;
import com.mdw.daos.RoomDao;
import com.mdw.entities.ReservationEntity;
import com.mdw.entities.RoomEntity;
import com.mdw.function.ReservationConverter;
import com.mdw.wrappers.ReservationWrapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.ValidationException;
import java.time.Instant;

@Controller
public class ReservationController {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private RoomDao roomDao;

    public ReservationWrapper createReservation(ReservationWrapper reservation) {
        RoomEntity roomEntity = roomDao.findById(reservation.getRoomId());

        if (roomEntity == null) {
            throw new ValidationException("Room should exist");
        }

        reservation.setReservationCode(RandomStringUtils.randomAlphanumeric(20).toUpperCase());

        reservation.setReservationDate(Instant.now());
        ReservationEntity entity =  ReservationConverter.wrapperToEntity(reservation, roomEntity);
        return ReservationConverter.entityToWrapper(reservationDao.save(entity));
    }
}
