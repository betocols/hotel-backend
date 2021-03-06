package com.mdw.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdw.controllers.PayTypeController;
import com.mdw.wrappers.PayTypeWrapper;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(Uris.VERSION + Uris.PAY_TYPE)
public class PayTypeResource {

    private PayTypeController paTypeController;

    @Autowired
    public void setPaTypeController(PayTypeController paTypeController) {
        this.paTypeController = paTypeController;
    }

    @RequestMapping(value = Uris.PAY_TYPE, method = RequestMethod.GET)
    public List<PayTypeWrapper> getPayType() {
        return paTypeController.getPayTypes();
    }

}
