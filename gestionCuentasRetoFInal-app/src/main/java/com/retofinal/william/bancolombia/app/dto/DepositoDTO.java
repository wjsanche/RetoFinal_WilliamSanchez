package com.retofinal.william.bancolombia.app.dto;

import java.math.BigDecimal;

public class DepositoDTO {

    private BigDecimal monto;
    private String tipoDeposito;

    // Getters y Setters


    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipoDeposito() {
        return tipoDeposito;
    }

    public void setTipoDeposito(String tipoDeposito) {
        this.tipoDeposito = tipoDeposito;
    }
}
