package com.hex.hex.application.port.out;

import com.hex.hex.domain.model.Pedido;

/**
 * 🚪 PUERTO DE SALIDA (OUTBOUND PORT):
 *
 * Define qué necesita el caso de uso del "mundo exterior".
 * En este caso, el caso de uso necesita poder GUARDAR un pedido.
 *
 * El puerto de salida es una interfaz → define un contrato sin depender
 * de la tecnología de persistencia.
 *
 * Los adaptadores (como los que usan JPA o una API externa) implementan esta interfaz.
 */
public interface GuardarPedidoPort {
    Pedido guardar(Pedido pedido);
}

