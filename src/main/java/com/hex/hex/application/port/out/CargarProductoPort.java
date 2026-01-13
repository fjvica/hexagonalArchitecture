package com.hex.hex.application.port.out;

import com.hex.hex.domain.model.Producto;

/**
 * 🔌 Puerto de salida: CargarProductoPort
 *
 * Define cómo se obtiene un producto (por ejemplo, de un microservicio de catálogo).
 *
 * Gracias a esta interfaz, el dominio no depende de cómo se consiguen los productos.
 */
public interface CargarProductoPort {
    Producto obtenerPorId(Long id);
}


