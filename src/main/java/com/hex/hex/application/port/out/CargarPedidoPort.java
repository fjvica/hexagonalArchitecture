package com.hex.hex.application.port.out;

import com.hex.hex.domain.model.Pedido;

/**
 * 🔌 Puerto de salida: CargarPedidoPort
 *
 * Permite obtener un pedido desde una fuente externa (BD, API...).
 *
 * El servicio de aplicación lo usará para recuperar los datos antes de aplicar lógica de negocio.
 */
public interface CargarPedidoPort {
    Pedido obtenerPorId(Long id);
}


