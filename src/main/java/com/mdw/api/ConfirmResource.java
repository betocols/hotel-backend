package com.mdw.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdw.controllers.ConfirmController;
import com.mdw.wrappers.ConfirmWrapper;


@RestController
@RequestMapping(Uris.VERSION + Uris.CONFIRM)
public class ConfirmResource {

    private ConfirmController confirmController;

    @Autowired
    public void setConfirmController(ConfirmController confirmController) {
        this.confirmController = confirmController;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void confirmPay(@RequestBody ConfirmWrapper confirmWrapper){
        confirmController.createConfirmation(confirmWrapper);
    }
}
