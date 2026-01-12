package com.hex.hex.application.port.in;

import com.hex.hex.domain.model.Pedido;

/**
 * 🚪 PUERTO DE ENTRADA (INBOUND PORT):
 *
 * Este puerto define un "caso de uso" del sistema.
 * Representa una acción que el mundo exterior (por ejemplo, un controlador REST o un CLI)
 * puede solicitar a la aplicación.
 *
 * El puerto es una interfaz → la implementación real estará en el servicio de aplicación.
 *
 * El uso de interfaces aquí es esencial para desacoplar:
 *  - El controlador REST no necesita saber cómo se crea un pedido.
 *  - Solo necesita llamar a "crearPedido()".
 */
public interface CrearPedidoUseCase {
    Pedido crearPedido(String cliente);
}

