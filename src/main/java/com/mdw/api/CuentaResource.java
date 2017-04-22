package com.mdw.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdw.controllers.CuentaController;
import com.mdw.wrappers.CuentaWrapper;


@RestController
@RequestMapping(Uris.VERSION)
public class CuentaResource {

    private CuentaController cuentaController;
    
    @Autowired
    public void setCuentaController(CuentaController cuentaController){
        this.cuentaController=cuentaController;
    }
    
    @RequestMapping(value = Uris.CUENTA, method = RequestMethod.GET)
    public CuentaWrapper getRoom() {
        return cuentaController.getCuenta();
    }
}
