package com.hex.hex.infraestructure.repository;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * 🧱 ENTIDAD JPA (detalle de infraestructura):
 *
 * Representa cómo se almacena un Pedido en la base de datos.
 *
 * Esta clase pertenece al "lado derecho" del hexágono (infraestructura).
 *
 * No debe usarse directamente en la lógica de negocio.
 */
@Entity
@Table(name = "pedidos")
public class PedidoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private LocalDate fecha;

    // Constructor protegido requerido por JPA
    protected PedidoJpaEntity() {}

    public PedidoJpaEntity(Long id, String cliente, LocalDate fecha) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public LocalDate getFecha() { return fecha; }
}

