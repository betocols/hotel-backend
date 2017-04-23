package com.mdw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mdw.daos.PayTypeDao;
import com.mdw.entities.PayTypeEntity;
import com.mdw.wrappers.PayTypeWrapper;

@Controller
public class PayTypeController {
    private PayTypeDao payTypeDao;

    @Autowired
    public void setPayTypeDao(PayTypeDao payTypeDao) {
        this.payTypeDao = payTypeDao;
    }

    public List<PayTypeWrapper> getPayTypes() {
        List<PayTypeEntity> payTypes = payTypeDao.findAll();
        List<PayTypeWrapper> wrapper = new ArrayList<PayTypeWrapper>();
        for (int i = 0; i < payTypes.size(); i++) {
            PayTypeWrapper payTypeWrapper = new PayTypeWrapper(payTypes.get(i).getPayType());
            wrapper.add(payTypeWrapper);
        }
        return wrapper;
    }
}
