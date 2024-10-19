package com.retofinal.william.bancolombia.app.dto;

import java.math.BigDecimal;

public class RetiroDTO {

    private BigDecimal monto;
    private String tipoRetiro;

    // Getters y Setters

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipoRetiro() {
        return tipoRetiro;
    }

    public void setTipoRetiro(String tipoRetiro) {
        this.tipoRetiro = tipoRetiro;
    }
}
