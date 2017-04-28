package com.mdw.controllers;

import com.mdw.daos.PayTypeDao;
import com.mdw.entities.PayTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mdw.daos.ConfirmDao;
import com.mdw.entities.ConfirmEntity;
import com.mdw.wrappers.ConfirmWrapper;

@Controller
public class ConfirmController {

    private ConfirmDao confirmDao;

    private PayTypeDao payTypeDao;

    @Autowired
    public void setConfirmDao(ConfirmDao confirmDao) {
        this.confirmDao = confirmDao;
    }

    @Autowired
    public void setPayTypeDao(PayTypeDao payTypeDao) {
        this.payTypeDao = payTypeDao;
    }

    public ConfirmWrapper createConfirmation(ConfirmWrapper confirmWrapper){
        PayTypeEntity payTypeEntity = payTypeDao.findByPayType(confirmWrapper.getPayType());

        ConfirmEntity entity = ConfirmEntity.builder()
                .bank(confirmWrapper.getBank())
                .ConfirmationNumber(confirmWrapper.getConfirmationNumber())
                .payType(payTypeEntity)
                .build();
        confirmDao.save(entity);
        return new ConfirmWrapper(entity.getId(), entity.getPayType().getPayType(), entity.getConfirmationNumber(), entity.getBank());
    }

}
