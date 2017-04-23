package com.mdw.api;


import com.mdw.controllers.ReservationController;
import com.mdw.wrappers.ReservationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.VERSION + Uris.RESERVATION)
public class ReservationResource {

    @Autowired
    private ReservationController reservationController;

    @RequestMapping(method = RequestMethod.POST)
    public ReservationWrapper createReservation(@RequestBody @Validated ReservationWrapper reservation) {
        return reservationController.createReservation(reservation);
    }

}
