package com.hex.hex.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 🧩 Clase de dominio: Pedido
 *
 * Esta clase representa el "núcleo" del modelo de negocio.
 * Contiene la información y reglas asociadas a un pedido dentro del sistema.
 *
 * ▶️ En la arquitectura hexagonal:
 * - Esta clase está en la capa más interna: el dominio.
 * - No depende de frameworks (Spring, JPA, etc).
 * - Solo conoce conceptos del negocio (Pedido, Cliente, Producto...).
 * - Contiene la lógica de negocio pura: validaciones, cálculos y estados.
 *
 * 🧠 Responsabilidades:
 * - Mantener la lista de productos (líneas del pedido).
 * - Controlar el estado del pedido (creado, confirmado, cancelado).
 * - Calcular el total del pedido (por ejemplo, con IVA).
 */
public class Pedido {

    // Identificador único del pedido
    private final Long id;

    // Cliente que realizó el pedido (objeto de dominio)
    private final Cliente cliente;

    // Líneas de pedido (productos + cantidad)
    private final List<LineaPedido> lineas = new ArrayList<>();

    // Estado del pedido (CREADO, CONFIRMADO, CANCELADO)
    private EstadoPedido estado = EstadoPedido.CREADO;

    // Fecha en que se creó el pedido
    private final LocalDate fecha;

    /**
     * Constructor principal del pedido.
     * Se suele crear con estado "CREADO" y sin líneas inicialmente.
     */
    public Pedido(Long id, Cliente cliente, LocalDate fecha) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    /**
     * Añade un producto al pedido.
     * Solo se permite si el pedido está en estado "CREADO".
     *
     * @param producto Producto que se añade.
     * @param cantidad Unidades de ese producto.
     */
    public void añadirProducto(Producto producto, int cantidad) {
        if (estado != EstadoPedido.CREADO) {
            throw new IllegalStateException("No se puede modificar un pedido ya confirmado o cancelado");
        }
        lineas.add(new LineaPedido(producto, cantidad));
    }

    /**
     * Confirma el pedido, cambiando su estado a CONFIRMADO.
     * No puede confirmarse si está vacío.
     */
    public void confirmar() {
        if (lineas.isEmpty()) {
            throw new IllegalStateException("No se puede confirmar un pedido vacío");
        }
        this.estado = EstadoPedido.CONFIRMADO;
    }

    /**
     * Cancela el pedido si aún no está confirmado.
     */
    public void cancelar() {
        if (estado == EstadoPedido.CONFIRMADO) {
            throw new IllegalStateException("No se puede cancelar un pedido confirmado");
        }
        this.estado = EstadoPedido.CANCELADO;
    }

    /**
     * Calcula el total del pedido incluyendo el IVA (21% en este ejemplo).
     */
    public BigDecimal calcularTotalConIVA() {
        BigDecimal subtotal = lineas.stream()
                .map(LineaPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return subtotal.multiply(BigDecimal.valueOf(1.21)); // IVA 21%
    }

    // Getters (el dominio tiende a ser inmutable o con mutaciones controladas)
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<LineaPedido> getLineas() { return lineas; }
    public EstadoPedido getEstado() { return estado; }
    public LocalDate getFecha() { return fecha; }
}




