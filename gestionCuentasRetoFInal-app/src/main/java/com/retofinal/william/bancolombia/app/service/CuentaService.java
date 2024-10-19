package com.retofinal.william.bancolombia.app.service;

import com.retofinal.william.bancolombia.app.exception.CuentaNoEncontradaException;
import com.retofinal.william.bancolombia.app.model.Cuenta;
import com.retofinal.william.bancolombia.app.model.Transaccion;
import com.retofinal.william.bancolombia.app.repository.CuentaRepository;
import com.retofinal.william.bancolombia.app.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    public Cuenta consultarSaldo(Long cuentaId) {
        return cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new CuentaNoEncontradaException("Cuenta no encontrada"));
    }

    public void depositar(Long cuentaId, BigDecimal monto, String tipoDeposito) {
        Cuenta cuenta = consultarSaldo(cuentaId);
        cuenta.realizarDeposito(monto, tipoDeposito);
        registrarTransaccion(cuenta, "DEPÓSITO", monto);
    }

    public void retirar(Long cuentaId, BigDecimal monto, String tipoRetiro) {
        Cuenta cuenta = consultarSaldo(cuentaId);
        cuenta.realizarRetiro(monto, tipoRetiro);
        registrarTransaccion(cuenta, "RETIRO", monto);
    }

    public List<Transaccion> consultarUltimasTransacciones(Long cuentaId) {
        Cuenta cuenta = consultarSaldo(cuentaId);
        return transaccionRepository.findTop5ByCuentaOrderByFechaDesc(cuenta);
    }

    private void registrarTransaccion(Cuenta cuenta, String tipo, BigDecimal monto) {
        Transaccion transaccion = new Transaccion();
        transaccion.setCuenta(cuenta);
        transaccion.setTipo(tipo);
        transaccion.setMonto(monto);
        transaccionRepository.save(transaccion);
    }
}
