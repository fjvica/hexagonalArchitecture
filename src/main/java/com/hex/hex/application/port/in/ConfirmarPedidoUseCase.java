package com.hex.hex.application.port.in;

/**
 * 🚪 Puerto de entrada: ConfirmarPedidoUseCase
 *
 * Define la operación para confirmar un pedido (cambiar su estado a CONFIRMADO).
 *
 * Este puerto lo invocará el controlador o cualquier adaptador de entrada.
 */
public interface ConfirmarPedidoUseCase {
    void confirmarPedido(Long pedidoId);
}


