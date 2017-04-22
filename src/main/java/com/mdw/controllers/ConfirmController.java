package com.mdw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mdw.daos.ConfirmDao;
import com.mdw.entities.ConfirmEntity;
import com.mdw.wrappers.ConfirmWrapper;

@Controller
public class ConfirmController {
    private ConfirmDao confirmDao;

    @Autowired
    public void setConfirmDao(ConfirmDao confirmDao) {
        this.confirmDao = confirmDao;
    }
    
    public void createConfirmation(ConfirmWrapper confirmWrapper){
        ConfirmEntity entity=new ConfirmEntity();
        entity.setBank(confirmWrapper.getBank());
        entity.setConfirmationNumber(confirmWrapper.getConfirmationNumber());
        entity.setPayType(confirmWrapper.getPayType());
        confirmDao.save(entity);
    }

}
