package com.mdw.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @Column(unique = true)
    private long accountNumber;

    private String accountName;

    private String concept;

    public AccountEntity() {

    }

    public AccountEntity(long acoountNumber, String accountName, String concept) {
        super();
        this.accountNumber = acoountNumber;
        this.accountName = accountName;
        this.concept = concept;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [numeroCuenta=" + accountNumber + ", nombreCuenta=" + accountName + ", concepto=" + concept + "]";
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((concept == null) ? 0 : concept.hashCode());
        result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
        result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
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
        AccountEntity other = (AccountEntity) obj;
        if (concept == null) {
            if (other.concept != null)
                return false;
        } else if (!concept.equals(other.concept))
            return false;
        if (accountName == null) {
            if (other.accountName != null)
                return false;
        } else if (!accountName.equals(other.accountName))
            return false;
        if (accountNumber != other.accountNumber)
            return false;
        return true;
    }

}