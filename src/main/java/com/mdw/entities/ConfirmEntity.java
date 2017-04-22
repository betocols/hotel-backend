package com.mdw.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "confirm")
public class ConfirmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String payType;

    @Column(unique = true)
    private String ConfirmationNumber;

    private String bank;

    public ConfirmEntity() {

    }

    public ConfirmEntity(long id, String payType, String confirmationNumber, String bank) {
        super();
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ConfirmationNumber == null) ? 0 : ConfirmationNumber.hashCode());
        result = prime * result + ((bank == null) ? 0 : bank.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
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
        ConfirmEntity other = (ConfirmEntity) obj;
        if (ConfirmationNumber == null) {
            if (other.ConfirmationNumber != null)
                return false;
        } else if (!ConfirmationNumber.equals(other.ConfirmationNumber))
            return false;
        if (bank == null) {
            if (other.bank != null)
                return false;
        } else if (!bank.equals(other.bank))
            return false;
        if (id != other.id)
            return false;
        if (payType == null) {
            if (other.payType != null)
                return false;
        } else if (!payType.equals(other.payType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ConfirmEntity [id=" + id + ", payType=" + payType + ", ConfirmationNumber=" + ConfirmationNumber + ", bank=" + bank + "]";
    }

}
