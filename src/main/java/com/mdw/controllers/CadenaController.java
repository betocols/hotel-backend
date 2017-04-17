package com.mdw.controllers;

import com.mdw.daos.CadenaDao;
import com.mdw.entities.CadenaEntity;
import com.mdw.wrappers.CadenaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CadenaController {
    @Autowired
    private CadenaDao cadenaDao;

    public void saveCadena(CadenaWrapper cadenaWrapper) {
        CadenaEntity cadenaEntity = new CadenaEntity();
        cadenaEntity.setName(cadenaWrapper.getName());
        cadenaDao.save(cadenaEntity);
    }

    public List<CadenaEntity> getAllCadenas() {
        return cadenaDao.findAll();
    }
}
