package com.hex.hex.application.port.out;

import com.hex.hex.domain.model.Pedido;

/**
 * 🔌 Puerto de salida: NotificarPedidoConfirmadoPort
 *
 * Permite notificar a sistemas externos cuando un pedido ha sido confirmado.
 *
 * Ejemplo de implementación:
 * - Publicar un mensaje en Kafka.
 * - Enviar un correo.
 * - Llamar a una API.
 */
public interface NotificarPedidoConfirmadoPort {
    void enviarEventoConfirmado(Pedido pedido);
}


