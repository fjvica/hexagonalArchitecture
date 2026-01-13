package com.hex.hex.application.port.in;

import com.hex.hex.domain.model.Pedido;

/**
 * 🚪 Puerto de entrada: CrearPedidoUseCase
 *
 * Define el "contrato" o interfaz de un caso de uso del sistema.
 *
 * En la arquitectura hexagonal:
 * - Representa algo que el mundo exterior (por ejemplo, un controlador REST)
 *   puede pedirle a la aplicación.
 * - No sabe cómo se implementa.
 *
 * Esta interfaz se implementará dentro de la capa de aplicación
 * (en un servicio con la lógica concreta).
 */
public interface CrearPedidoUseCase {
    Pedido crearPedido(Long clienteId);
}


