package com.hex.hex.infraestructure.adapter.out;

import com.hex.hex.application.port.out.CargarPedidoPort;
import com.hex.hex.application.port.out.GuardarPedidoPort;
import com.hex.hex.domain.model.Cliente;
import com.hex.hex.domain.model.Pedido;
import com.hex.hex.infraestructure.repository.PedidoJpaEntity;
import com.hex.hex.infraestructure.repository.PedidoJpaRepository;
import org.springframework.stereotype.Component;


/**
 * 🔌 Adaptador de salida: PedidoJpaRepositoryAdapter
 *
 * Implementa los puertos de salida "GuardarPedidoPort" y "CargarPedidoPort".
 *
 * ▶️ Función:
 * - Actúa como puente entre el dominio y la base de datos.
 * - Convierte entre objetos del dominio (Pedido) y entidades JPA (PedidoJpaEntity).
 *
 * ▶️ Importante:
 * - Esta clase depende de JPA y Spring (infraestructura).
 * - El dominio y la aplicación no dependen de ella.
 */
@Component
public class PedidoJpaRepositoryAdapter implements GuardarPedidoPort, CargarPedidoPort {

    private final PedidoJpaRepository repository;

    public PedidoJpaRepositoryAdapter(PedidoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        // 🔁 Convertimos el modelo de dominio en entidad JPA
        PedidoJpaEntity entity = new PedidoJpaEntity(
                pedido.getId(),
                pedido.getCliente().getId(),
                pedido.getFecha(),
                pedido.getEstado().name()
        );

        // 💾 Persistimos en la BD
        PedidoJpaEntity saved = repository.save(entity);

        // 🔄 Convertimos la entidad JPA de nuevo a modelo de dominio
        return new Pedido(
                saved.getId(),
                new Cliente(saved.getClienteId(), "Cliente " + saved.getClienteId(), 0),
                saved.getFecha()
        );
    }

    @Override
    public Pedido obtenerPorId(Long id) {
        PedidoJpaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        // 🔄 Transformación inversa: entidad JPA → modelo de dominio
        return new Pedido(
                entity.getId(),
                new Cliente(entity.getClienteId(), "Cliente " + entity.getClienteId(), 0),
                entity.getFecha()
        );
    }
}




