package com.mdw.api;

import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class RoomResourceTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private RestTemplate restTemplate;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void testGetRoom(){
       /* mockMvc.perform(
                get(Uris.VERSION + Uris.ROOM).contentType()
                );*/
    }
}
