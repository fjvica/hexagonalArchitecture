package com.hex.hex.domain.model;

/**
 * 👤 Clase de dominio: Cliente
 *
 * Representa un cliente dentro del sistema.
 *
 * ▶️ En el dominio:
 * - Solo contiene datos y reglas simples (por ejemplo, su nivel de fidelidad).
 * - No contiene referencias a frameworks ni persistencia.
 */
public class Cliente {

    private final Long id;
    private final String nombre;
    private final int nivelFidelidad; // 0 a 5, sirve para aplicar descuentos, por ejemplo

    public Cliente(Long id, String nombre, int nivelFidelidad) {
        this.id = id;
        this.nombre = nombre;
        this.nivelFidelidad = nivelFidelidad;
    }

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNivelFidelidad() { return nivelFidelidad; }
}


