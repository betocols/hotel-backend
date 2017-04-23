package com.mdw.controllers;

import static org.junit.Assert.assertEquals;

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

import com.mdw.wrappers.RoomWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class RoomControllerTest {

    private RoomController roomController;
    
    @Autowired
    public void setRoomController(RoomController roomController){
        this.roomController=roomController;
    }
    
    @Test
    public void TestGetRoom(){
        Long id=1L;
        RoomWrapper room=roomController.getRoom(id);
        assertEquals(1L,room.getId().longValue());
    }
}
