package com.mdw.controllers;

import com.mdw.daos.ReservationDao;
import com.mdw.entities.ReservationEntity;
import com.mdw.wrappers.ReservationWrapper;
import org.flywaydb.test.annotation.FlywayTest;
import javax.validation.ValidationException;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class ReservationControllerTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Autowired
    private ReservationController controller;

    @Autowired
    private ReservationDao dao;

    @Test
    public void testCreateReservation() {
        ReservationWrapper reservation = ReservationWrapper.builder()
                .numberOfPersons(2L)
                .confirmationId(1L)
                .roomId(1L)
                .build();
        controller.createReservation(reservation);

        ReservationEntity entity = dao.findAll().get(1);
        assertEquals(2l, entity.getNumberOfPersons().longValue());
        assertEquals(1L, entity.getRoom().getId().longValue());
        assertTrue(entity.getReservationDate().isAfter(Instant.EPOCH));

    }

    @Test
    public void testCreateReservationFailed(){
        thrown.expect(ValidationException.class);
        ReservationWrapper reservation = ReservationWrapper.builder()
                .numberOfPersons(2L)
                .confirmationId(1L)
                .roomId(122L)
                .build();
        controller.createReservation(reservation);
    }

}
