package com.mdw.daos;

import com.mdw.entities.HotelEntity;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class HotelDaoTest {
    private static String CITY_MAD = "Madrid";
    private static String ZIP_CODE_MAD = "28008";

    @Autowired
    private HotelDao hotelDao;

    @Test
    public void testFindAllHotelsComplete() {
        List<Long> ids = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
        List<HotelEntity> hotelEntityList = hotelDao.findAll();
        assertEquals(5, hotelEntityList.size());
        hotelEntityList.stream().forEach(hotelEntity -> assertTrue(ids.contains(hotelEntity.getId())));
    }

    @Test
    public void testFindHotelsCompleteByCityAndZipCode() {
        List<Long> ids = new ArrayList<>(Arrays.asList(1L,2L));
        List<HotelEntity> hotelEntityList = hotelDao.findByCityAndZipCode(CITY_MAD, ZIP_CODE_MAD);
        assertEquals(2, hotelEntityList.size());
        hotelEntityList.stream().forEach(hotelEntity -> assertTrue(ids.contains(hotelEntity.getId())));
    }

    @Test
    public void testFindHotelsCompleteByCity() {
        List<Long> ids = new ArrayList<>(Arrays.asList(1L,2L,3L,4L));
        List<HotelEntity> hotelEntityList = hotelDao.findByCity(CITY_MAD);
        assertEquals(4, hotelEntityList.size());
        hotelEntityList.stream().forEach(hotelEntity -> assertTrue(ids.contains(hotelEntity.getId())));
    }

    @Test
    public void testFindHotelsCompleteByZipCode() {
        List<Long> ids = new ArrayList<>(Arrays.asList(1L,2L));
        List<HotelEntity> hotelEntityList = hotelDao.findByZipCode(ZIP_CODE_MAD);
        assertEquals(2, hotelEntityList.size());
        hotelEntityList.stream().forEach(hotelEntity -> assertTrue(ids.contains(hotelEntity.getId())));
    }

}
