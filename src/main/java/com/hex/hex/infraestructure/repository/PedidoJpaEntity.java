package com.hex.hex.infraestructure.repository;

import jakarta.persistence.*;
import java.time.LocalDate;


/**
 * 🧱 Entidad JPA: PedidoJpaEntity
 *
 * Representa cómo se almacena un pedido en la base de datos.
 *
 * ▶️ Importante:
 * - Esta clase pertenece exclusivamente a la capa de infraestructura.
 * - No se usa en el dominio ni en la capa de aplicación.
 * - Es un detalle técnico, dependiente de JPA.
 */
@Entity
@Table(name = "pedidos")
public class PedidoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Referencia al cliente (solo guardamos su ID)
    private Long clienteId;

    private LocalDate fecha;

    // Estado del pedido (guardado como texto)
    private String estado;

    // Constructor vacío necesario para JPA
    protected PedidoJpaEntity() {}

    public PedidoJpaEntity(Long id, Long clienteId, LocalDate fecha, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public Long getClienteId() { return clienteId; }
    public LocalDate getFecha() { return fecha; }
    public String getEstado() { return estado; }

    public void setId(Long id) { this.id = id; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setEstado(String estado) { this.estado = estado; }
}


