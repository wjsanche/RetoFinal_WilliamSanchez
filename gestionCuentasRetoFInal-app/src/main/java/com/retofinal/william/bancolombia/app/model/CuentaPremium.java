package com.retofinal.william.bancolombia.app.model;

import com.retofinal.william.bancolombia.app.exception.SaldoInsuficienteException;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("PREMIUM")
public class CuentaPremium extends Cuenta {

    @Override
    public void realizarDeposito(BigDecimal monto, String tipo) {
        // Sin comisiones adicionales
        setSaldo(getSaldo().add(monto));
    }

    @Override
    public void realizarRetiro(BigDecimal monto, String tipo) {
        // Sin comisiones adicionales para retiros
        if (getSaldo().compareTo(monto) >= 0) {
            setSaldo(getSaldo().subtract(monto));
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para la transacción");
        }
    }
}