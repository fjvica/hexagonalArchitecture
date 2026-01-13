package com.hex.hex.domain.model;

import java.math.BigDecimal;

/**
 * 🛒 Clase de dominio: Producto
 *
 * Representa un producto dentro del catálogo del negocio.
 *
 * ▶️ En el dominio:
 * - No sabe nada de cómo se guarda (BD, API externa...).
 * - Se usa para cálculos dentro del pedido o reglas de negocio.
 */
public class Producto {

    private final Long id;
    private final String nombre;
    private final BigDecimal precio;

    public Producto(Long id, String nombre, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public BigDecimal getPrecio() { return precio; }
}


