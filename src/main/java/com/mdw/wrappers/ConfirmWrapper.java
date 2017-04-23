package com.mdw.wrappers;

public class ConfirmWrapper {
    private long id;

    private String payType;

    private String ConfirmationNumber;

    private String bank;

    public ConfirmWrapper() {

    }

    public ConfirmWrapper(long id, String payType, String confirmationNumber, String bank) {
        this.id = id;
        this.payType = payType;
        ConfirmationNumber = confirmationNumber;
        this.bank = bank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getConfirmationNumber() {
        return ConfirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        ConfirmationNumber = confirmationNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "ConfirmWrapper [id=" + id + ", payType=" + payType + ", ConfirmationNumber=" + ConfirmationNumber + ", bank=" + bank + "]";
    }

}
