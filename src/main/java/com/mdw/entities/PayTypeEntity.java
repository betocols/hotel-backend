package com.mdw.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payType")
public class PayTypeEntity {
    @Id
    @Column(unique = true)
    private String payType;

    public PayTypeEntity() {

    }

    public PayTypeEntity(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((payType == null) ? 0 : payType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PayTypeEntity other = (PayTypeEntity) obj;
        if (payType == null) {
            if (other.payType != null)
                return false;
        } else if (!payType.equals(other.payType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PayType [payType=" + payType + "]";
    }

}
