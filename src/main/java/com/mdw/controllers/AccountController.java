package com.mdw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mdw.daos.AccountDao;
import com.mdw.entities.AccountEntity;
import com.mdw.wrappers.AccountWrapper;

@Controller
public class AccountController {
    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountWrapper getAccount() {
        AccountEntity account = accountDao.findAll().get(0);
        AccountWrapper cuentaWrapper = new AccountWrapper(account.getAccountNumber(), account.getAccountName(), account.getConcept());
        return cuentaWrapper;
    }
}
