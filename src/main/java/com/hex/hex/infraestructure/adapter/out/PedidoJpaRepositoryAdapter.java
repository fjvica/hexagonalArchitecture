package com.hex.hex.infraestructure.adapter.out;

import com.hex.hex.application.port.out.GuardarPedidoPort;
import com.hex.hex.domain.model.Pedido;
import com.hex.hex.infraestructure.repository.PedidoJpaEntity;
import com.hex.hex.infraestructure.repository.PedidoJpaRepository;
import org.springframework.stereotype.Component;

/**
 * 🔌 ADAPTADOR DE SALIDA (OUTBOUND ADAPTER):
 *
 * Implementa el puerto de salida (GuardarPedidoPort) usando una tecnología concreta.
 *
 * En este caso, usa Spring Data JPA para acceder a la base de datos.
 *
 * Su función es traducir entre el mundo del dominio (Pedido) y
 * el mundo de infraestructura (PedidoJpaEntity).
 *
 * Este adaptador depende de Spring, pero el dominio NO depende de él.
 */
@Component
public class PedidoJpaRepositoryAdapter implements GuardarPedidoPort {

    private final PedidoJpaRepository repository;

    public PedidoJpaRepositoryAdapter(PedidoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        // 🔁 Convertir el objeto del dominio a entidad JPA
        PedidoJpaEntity entity = new PedidoJpaEntity(null, pedido.getCliente(), pedido.getFecha());

        // 💾 Guardar usando JPA
        PedidoJpaEntity saved = repository.save(entity);

        // 🔄 Volver a convertir a modelo de dominio para devolverlo a la aplicación
        return new Pedido(saved.getId(), saved.getCliente(), saved.getFecha());
    }
}


