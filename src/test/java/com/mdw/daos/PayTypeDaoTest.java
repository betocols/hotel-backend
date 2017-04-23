package com.mdw.daos;

import static org.junit.Assert.assertEquals;

import java.util.List;

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

import com.mdw.entities.PayTypeEntity;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = FlywayTestExecutionListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@FlywayTest
public class PayTypeDaoTest {

    @Autowired
    private PayTypeDao payTypeDao;
    
    @Test
    public void testFindAll(){
        List<PayTypeEntity> payTypes=payTypeDao.findAll(); 
        assertEquals(3,payTypes.size());
    }
}
