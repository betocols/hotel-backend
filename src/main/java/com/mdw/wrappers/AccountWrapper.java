package com.mdw.wrappers;

public class AccountWrapper {
    private long accountNumber;

    private String accountName;

    private String concept;

    public AccountWrapper() {

    }

    public AccountWrapper(long accountNumber, String accountName, String concept) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.concept = concept;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    @Override
    public String toString() {
        return "CuentaWrapper [accountNumber=" + accountNumber + ", accountName=" + accountName + ", concept=" + concept + "]";
    }



    

}
