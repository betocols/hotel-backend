package com.mdw.daos;

import com.mdw.entities.RoomEntity;
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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class RoomDaoIt {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void testFindById() {
        Long id = 1L;
        RoomEntity roomEntity = roomDao.findById(id);
        assertEquals("ID should match", 1L, roomEntity.getId().longValue());
    }
}
