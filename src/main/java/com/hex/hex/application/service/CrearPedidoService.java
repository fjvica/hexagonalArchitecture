package com.hex.hex.application.service;

import com.hex.hex.application.port.in.CrearPedidoUseCase;
import com.hex.hex.application.port.out.GuardarPedidoPort;
import com.hex.hex.domain.model.Cliente;
import com.hex.hex.domain.model.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * 🧩 Servicio de aplicación: CrearPedidoService
 *
 * Implementa el caso de uso "crear un pedido".
 *
 * ▶️ Función:
 * - Crea un nuevo pedido en estado CREADO.
 * - Invoca el puerto de salida GuardarPedidoPort para persistirlo.
 *
 * ▶️ Dependencias:
 * - Conoce al dominio (usa Cliente y Pedido).
 * - Conoce los puertos de salida (GuardarPedidoPort).
 * - No conoce la infraestructura ni frameworks de persistencia.
 */
@Service
public class CrearPedidoService implements CrearPedidoUseCase {

    private final GuardarPedidoPort guardarPedidoPort;

    public CrearPedidoService(GuardarPedidoPort guardarPedidoPort) {
        this.guardarPedidoPort = guardarPedidoPort;
    }

    @Override
    public Pedido crearPedido(Long clienteId) {
        // 🧠 Crea un cliente ficticio (en un sistema real se cargaría desde otro microservicio)
        Cliente cliente = new Cliente(clienteId, "Cliente " + clienteId, 0);

        // 🧠 Crea el objeto de dominio Pedido
        Pedido pedido = new Pedido(null, cliente, LocalDate.now());

        // 💾 Guarda el pedido a través del puerto (sin saber cómo se implementa)
        return guardarPedidoPort.guardar(pedido);
    }
}



