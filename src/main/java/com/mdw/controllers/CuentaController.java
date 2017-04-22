package com.mdw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mdw.daos.CuentaDao;
import com.mdw.entities.CuentaBancaria;
import com.mdw.wrappers.CuentaWrapper;

@Controller
public class CuentaController {
    private CuentaDao cuentaDao;

    @Autowired
    public void setCuentaDao(CuentaDao cuentaDao){
        this.cuentaDao=cuentaDao;
    }
    
    public CuentaWrapper getCuenta(){
        CuentaBancaria cuenta=cuentaDao.findAll().get(0);
        CuentaWrapper cuentaWrapper=new CuentaWrapper(cuenta.getNumeroCuenta(), cuenta.getNombreCuenta(), cuenta.getConcepto());
        return cuentaWrapper;
    }
}
