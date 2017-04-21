package com.mdw.wrappers;

public class CuentaWrapper {
    private long numeroCuenta;

    private String nombreCuenta;

    private String concepto;

    public CuentaWrapper() {

    }

    public CuentaWrapper(long numeroCuenta, String nombreCuenta, String concepto) {
        super();
        this.numeroCuenta = numeroCuenta;
        this.nombreCuenta = nombreCuenta;
        this.concepto = concepto;
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
    public String toString() {
        return "CuentaWrapper [numeroCuenta=" + numeroCuenta + ", nombreCuenta=" + nombreCuenta + ", concepto=" + concepto + "]";
    }

}
