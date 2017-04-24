package com.mdw.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.util.FileUtil;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class ReservationResourceTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private RestTemplate restTemplate;

    @Value("classpath:data/reservationData.json")
    File reservationData;

    @Value("classpath:data/reservationInvalidData.json")
    File reservationInvalidData;


    protected MockMvc mockMvc;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testValidRequestCreateReservation() throws Exception {
        mockMvc.perform(
                post(Uris.VERSION + Uris.RESERVATION).contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(readFileAsString(reservationData)))
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    public void testInvalidRequestCreateReservation() throws Exception {
        mockMvc.perform(
                post(Uris.VERSION + Uris.RESERVATION).contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(readFileAsString(reservationInvalidData)))
                .andExpect(status().is(412))
                .andReturn();
    }

    private String readFileAsString(File content) throws IOException {
        return FileUtil.readAsString(content);
    }

    private JsonNode getValidResponse(File response) throws IOException {
        return mapper.readValue(FileUtil.readAsString(response), JsonNode.class);
    }
}
