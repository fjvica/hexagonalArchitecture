package com.hex.hex.domain.model;

import java.math.BigDecimal;

/**
 * 📦 Clase de dominio: LineaPedido
 *
 * Representa una línea dentro de un pedido (un producto + cantidad).
 *
 * ▶️ En la arquitectura hexagonal:
 * - Es parte del modelo de dominio.
 * - No sabe nada de cómo se guarda ni se envía.
 * - Solo conoce la lógica del negocio (cuánto cuesta una línea).
 */
public class LineaPedido {

    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal de esta línea (precio * cantidad).
     */
    public BigDecimal calcularSubtotal() {
        return producto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
    }

    // Getters
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
}

