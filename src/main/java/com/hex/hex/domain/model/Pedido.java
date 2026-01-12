package com.hex.hex.domain.model;

import java.time.LocalDate;

/**
 * 🧱 DOMINIO:
 * Esta clase representa el núcleo del dominio (la lógica de negocio pura).
 *
 * No depende de Spring, JPA ni ningún framework.
 *
 * En la arquitectura hexagonal, el "dominio" es el corazón:
 *  - Define los objetos y reglas fundamentales del negocio.
 *  - No sabe nada de cómo se guarda un pedido ni cómo se expone vía HTTP.
 *
 * Es totalmente independiente del exterior (lo que permite testear y reutilizar fácilmente).
 */
public class Pedido {

    private final Long id;
    private final String cliente;
    private final LocalDate fecha;

    // Constructor inmutable: el dominio tiende a favorecer objetos inmutables.
    public Pedido(Long id, String cliente, LocalDate fecha) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public LocalDate getFecha() { return fecha; }
}


