package com.retofinal.william.bancolombia.app.controller;


import com.retofinal.william.bancolombia.app.dto.DepositoDTO;
import com.retofinal.william.bancolombia.app.dto.RetiroDTO;
import com.retofinal.william.bancolombia.app.model.Cuenta;
import com.retofinal.william.bancolombia.app.model.Transaccion;
import com.retofinal.william.bancolombia.app.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/{cuentaId}/saldo")
    public ResponseEntity<Cuenta> consultarSaldo(@PathVariable Long cuentaId) {
        Cuenta cuenta = cuentaService.consultarSaldo(cuentaId);
        return ResponseEntity.ok(cuenta);
    }

    @PostMapping("/{cuentaId}/depositar")
    public ResponseEntity<String> depositar(@PathVariable Long cuentaId, @RequestBody DepositoDTO depositoDTO) {
        cuentaService.depositar(cuentaId, depositoDTO.getMonto(), depositoDTO.getTipoDeposito());
        return ResponseEntity.ok("Depósito realizado con éxito");
    }

    @PostMapping("/{cuentaId}/retirar")
    public ResponseEntity<String> retirar(@PathVariable Long cuentaId, @RequestBody RetiroDTO retiroDTO) {
        cuentaService.retirar(cuentaId, retiroDTO.getMonto(), retiroDTO.getTipoRetiro());
        return ResponseEntity.ok("Retiro realizado con éxito");
    }

    @GetMapping("/{cuentaId}/transacciones")
    public ResponseEntity<List<Transaccion>> consultarUltimasTransacciones(@PathVariable Long cuentaId) {
        List<Transaccion> transacciones = cuentaService.consultarUltimasTransacciones(cuentaId);
        return ResponseEntity.ok(transacciones);
    }
}