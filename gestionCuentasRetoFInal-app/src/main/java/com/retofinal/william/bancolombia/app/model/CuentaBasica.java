package com.retofinal.william.bancolombia.app.model;

import com.retofinal.william.bancolombia.app.exception.SaldoInsuficienteException;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("BASICA")
public class CuentaBasica extends Cuenta {

    @Override
    public void realizarDeposito(BigDecimal monto, String tipo) {
        if (tipo.equals("CAJERO_AUTOMATICO")) {
            monto = monto.subtract(BigDecimal.valueOf(2)); // Costo de cajero automático
        }
        setSaldo(getSaldo().add(monto));
    }

    @Override
    public void realizarRetiro(BigDecimal monto, String tipo) {
        monto = monto.add(BigDecimal.valueOf(1)); // Costo por retiro en cajero
        if (getSaldo().compareTo(monto) >= 0) {
            setSaldo(getSaldo().subtract(monto));
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para la transacción");
        }
    }
}
