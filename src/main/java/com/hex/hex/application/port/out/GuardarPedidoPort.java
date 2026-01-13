package com.hex.hex.application.port.out;

import com.hex.hex.domain.model.Pedido;

/**
 * 🔌 Puerto de salida: GuardarPedidoPort
 *
 * Define la operación para persistir un pedido en la base de datos o cualquier sistema externo.
 *
 * En la arquitectura hexagonal:
 * - Este puerto se implementará en un "adaptador de salida" (por ejemplo, usando JPA).
 * - Así, el servicio de aplicación no conoce la tecnología usada para guardar.
 */
public interface GuardarPedidoPort {
    Pedido guardar(Pedido pedido);
}


