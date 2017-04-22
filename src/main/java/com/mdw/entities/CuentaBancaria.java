package com.mdw.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cuentaBancaria")
public class CuentaBancaria {
    @Id
    @Column(unique = true)
    private long numeroCuenta;

    private String nombreCuenta;

    private String concepto;

    public CuentaBancaria() {

    }

    public CuentaBancaria(long numeroCuenta, String nombreCuenta, String concepto) {
        super();
        this.numeroCuenta = numeroCuenta;
        this.nombreCuenta = nombreCuenta;
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [numeroCuenta=" + numeroCuenta + ", nombreCuenta=" + nombreCuenta + ", concepto=" + concepto + "]";
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((concepto == null) ? 0 : concepto.hashCode());
        result = prime * result + ((nombreCuenta == null) ? 0 : nombreCuenta.hashCode());
        result = prime * result + (int) (numeroCuenta ^ (numeroCuenta >>> 32));
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
        CuentaBancaria other = (CuentaBancaria) obj;
        if (concepto == null) {
            if (other.concepto != null)
                return false;
        } else if (!concepto.equals(other.concepto))
            return false;
        if (nombreCuenta == null) {
            if (other.nombreCuenta != null)
                return false;
        } else if (!nombreCuenta.equals(other.nombreCuenta))
            return false;
        if (numeroCuenta != other.numeroCuenta)
            return false;
        return true;
    }

}