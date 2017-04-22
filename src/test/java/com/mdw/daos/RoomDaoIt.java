package com.mdw.daos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomDaoIt {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void testFindById() {
        Long id = 123L;
        System.out.println(roomDao.findById(id).getType());
    }
}
