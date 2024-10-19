package com.retofinal.william.bancolombia.app.repository;

import com.retofinal.william.bancolombia.app.model.Cuenta;
import com.retofinal.william.bancolombia.app.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
        List<Transaccion> findTop5ByCuentaOrderByFechaDesc(Cuenta cuenta);
}
