package com.mdw.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdw.controllers.AccountController;
import com.mdw.wrappers.AccountWrapper;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(Uris.VERSION + Uris.ACCOUNT)
public class AccountResource {

    private AccountController accountController;

    @Autowired
    public void setAccountController(AccountController accountController){
        this.accountController=accountController;
    }

    @RequestMapping(method = RequestMethod.GET)
    public AccountWrapper getAccount() {
        return accountController.getAccount();
    }
}
