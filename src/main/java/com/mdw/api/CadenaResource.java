package com.mdw.api;

import com.mdw.controllers.CadenaController;
import com.mdw.entities.CadenaEntity;
import com.mdw.wrappers.CadenaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cadena")
public class CadenaResource {

    @Autowired
    private CadenaController cadenaController;

    @RequestMapping(method = RequestMethod.POST)
    public void saveCadena(@RequestBody CadenaWrapper cadenaWrapper) {
        cadenaController.saveCadena(cadenaWrapper);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CadenaEntity> getAllCadenas() {
        return cadenaController.getAllCadenas();
    }
}
