package com.mdw.controllers;

import com.mdw.daos.HotelDao;
import com.mdw.function.HotelConverter;
import com.mdw.wrappers.HotelCompleteWrapper;
import org.flywaydb.test.annotation.FlywayTest;
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

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class HotelControllerTest {
    private static String CITY_MAD = "Madrid";
    private static String ZIP_CODE_MAD = "25008";
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private HotelController controller;

    @Autowired
    private HotelDao dao;

    @Test
    public void testFindAllHotelsComplete() {
        List<HotelCompleteWrapper> hotelCompleteWrappers = controller.findAllHotelsComplete();

        List<HotelCompleteWrapper> expectedHotelCompleteWrappers =
                dao.findAll().stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        compareHotelsCompleteList(hotelCompleteWrappers, expectedHotelCompleteWrappers);
    }

    @Test
    public void testFindHotelsCompleteByCityAndZipCode() {
        List<HotelCompleteWrapper> hotelCompleteWrappers = controller.findHotelsCompleteByCityAndZipCode(CITY_MAD, ZIP_CODE_MAD);

        List<HotelCompleteWrapper> expectedHotelCompleteWrappers =
                dao.findByCityAndZipCode(CITY_MAD, ZIP_CODE_MAD).stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        compareHotelsCompleteList(hotelCompleteWrappers, expectedHotelCompleteWrappers);
    }

    @Test
    public void testFindHotelsCompleteByCity() {
        List<HotelCompleteWrapper> hotelCompleteWrappers = controller.findHotelsCompleteByCity(CITY_MAD);

        List<HotelCompleteWrapper> expectedHotelCompleteWrappers =
                dao.findByCity(CITY_MAD).stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        compareHotelsCompleteList(hotelCompleteWrappers, expectedHotelCompleteWrappers);
    }

    @Test
    public void testFindHotelsCompleteByZipCode() {
        List<HotelCompleteWrapper> hotelCompleteWrappers = controller.findHotelsCompleteByZipCode(ZIP_CODE_MAD);

        List<HotelCompleteWrapper> expectedHotelCompleteWrappers =
                dao.findByZipCode(ZIP_CODE_MAD).stream()
                        .map(hotelEntity -> HotelConverter.entityToWrapper(hotelEntity))
                        .filter(hotelCompleteWrapper -> hotelCompleteWrapper.getRooms().size() != 0)
                        .collect(Collectors.toList());

        compareHotelsCompleteList(hotelCompleteWrappers, expectedHotelCompleteWrappers);
    }

    private void compareHotelsCompleteList(List<HotelCompleteWrapper> returnedHotelWrappers,
                                           List<HotelCompleteWrapper> expectedHotelWrappers) {
        assertEquals(returnedHotelWrappers.size(), expectedHotelWrappers.size());
        returnedHotelWrappers.stream().forEach(returnedHotelWrapper ->
                assertTrue(expectedHotelWrappers.contains(returnedHotelWrapper))
        );
    }
}
