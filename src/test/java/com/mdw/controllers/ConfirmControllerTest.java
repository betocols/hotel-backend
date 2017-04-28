package com.mdw.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mdw.wrappers.ConfirmWrapper;

public class ConfirmControllerTest {

    @Autowired
    private ConfirmController confirmController;
    
    @Test
    public void testCreateConfirmation(){
        new ConfirmWrapper();
        ConfirmWrapper confirmWrapper=new ConfirmWrapper();
        confirmWrapper.setBank("BBVA");
        confirmWrapper.setConfirmationNumber("12w");
        confirmWrapper.setPayType("Transfer");
        confirmController.createConfirmation(confirmWrapper);
        assertEquals(confirmWrapper.getBank(),confirmWrapper.getBank());
        
    }
}
