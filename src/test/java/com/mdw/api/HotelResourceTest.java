package com.mdw.api;

import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class HotelResourceTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testValidRequestSearchHotelsWithRoomsAllHotels() throws Exception {
        mockMvc.perform(
                get(Uris.VERSION + Uris.HOTEL))
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    public void testValidRequestSearchHotelsWithRoomsByCityAndZipCode() throws Exception {
        mockMvc.perform(
                get(Uris.VERSION + Uris.HOTEL).param("city", "Madrid").param("zip_code", "28007"))
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    public void testValidRequestSearchHotelsWithRoomsByCity() throws Exception {
        mockMvc.perform(
                get(Uris.VERSION + Uris.HOTEL).param("city", "Madrid"))
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    public void testValidRequestSearchHotelsWithRoomsByZipCode() throws Exception {
        mockMvc.perform(
                get(Uris.VERSION + Uris.HOTEL).param("zip_code", "28008"))
                .andExpect(status().is(200))
                .andReturn();
    }

}
