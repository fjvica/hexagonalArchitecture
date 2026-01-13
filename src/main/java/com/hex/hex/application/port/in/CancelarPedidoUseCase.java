package com.hex.hex.application.port.in;

/**
 * 🚪 Puerto de entrada: CancelarPedidoUseCase
 *
 * Caso de uso que permite cancelar un pedido si todavía no está confirmado.
 */
public interface CancelarPedidoUseCase {
    void cancelarPedido(Long pedidoId);
}


