package com.hex.hex.application.port.in;

/**
 * 🚪 Puerto de entrada: AñadirProductoUseCase
 *
 * Permite agregar un producto existente a un pedido ya creado.
 *
 * - Lo implementará un servicio de aplicación.
 * - Define un metodo simple, sin depender de frameworks.
 */
public interface AñadirProductoUseCase {
    void añadirProducto(Long pedidoId, Long productoId, int cantidad);
}


