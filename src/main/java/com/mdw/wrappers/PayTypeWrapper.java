package com.mdw.wrappers;

public class PayTypeWrapper {
    private String payType;

    public PayTypeWrapper() {

    }

    public PayTypeWrapper(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "PayTypeWrapper [payType=" + payType + "]";
    }

}
