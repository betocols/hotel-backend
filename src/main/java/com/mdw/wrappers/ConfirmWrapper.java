package com.mdw.wrappers;

public class ConfirmWrapper {
    private long id;

    private String payType;

    private String bank;

    public ConfirmWrapper() {
    }

    public ConfirmWrapper(long id, String payType, String bank) {
        this.id = id;
        this.payType = payType;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "ConfirmWrapper [id=" + id + ", payType=" + payType + ", bank=" + bank + "]";
    }

}
