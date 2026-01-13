package com.hex.hex.infraestructure.adapter.out;

import com.hex.hex.application.port.out.NotificarPedidoConfirmadoPort;
import com.hex.hex.domain.model.Pedido;
import org.springframework.stereotype.Component;

/**
 * 🔔 Adaptador de salida: NotificarPedidoConfirmadoAdapter
 *
 * Implementa el puerto "NotificarPedidoConfirmadoPort".
 *
 * ▶️ Propósito:
 * - Simular la notificación de un evento cuando un pedido se confirma.
 * - En un entorno real, podría enviar:
 *   - un mensaje a Kafka o RabbitMQ
 *   - un email
 *   - una notificación push o HTTP
 */
@Component
public class NotificarPedidoConfirmadoAdapter implements NotificarPedidoConfirmadoPort {

    @Override
    public void enviarEventoConfirmado(Pedido pedido) {
        // 🧠 Aquí se integraría la mensajería o notificación real.
        // Por simplicidad, mostramos un log en consola.
        System.out.println("📢 Evento publicado: Pedido confirmado (ID = " + pedido.getId() + ")");
    }
}


