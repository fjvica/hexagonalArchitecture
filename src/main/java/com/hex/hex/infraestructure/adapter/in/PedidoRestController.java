package com.hex.hex.infraestructure.adapter.in;

import com.hex.hex.application.port.in.AñadirProductoUseCase;
import com.hex.hex.application.port.in.CancelarPedidoUseCase;
import com.hex.hex.application.port.in.ConfirmarPedidoUseCase;
import com.hex.hex.application.port.in.CrearPedidoUseCase;
import com.hex.hex.domain.model.Pedido;
import org.springframework.web.bind.annotation.*;


/**
 * 🌐 Adaptador de entrada: PedidoRestController
 *
 * Expone los casos de uso del sistema a través de una API REST.
 *
 * ▶️ Función:
 * - Recibe solicitudes HTTP.
 * - Convierte los parámetros en tipos adecuados.
 * - Invoca los puertos de entrada (casos de uso).
 * - Devuelve respuestas al cliente.
 *
 * ▶️ Importante:
 * - No contiene lógica de negocio (eso vive en el dominio).
 * - No conoce la infraestructura de persistencia ni frameworks de bajo nivel.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {

    private final CrearPedidoUseCase crearPedidoUseCase;
    private final AñadirProductoUseCase añadirProductoUseCase;
    private final ConfirmarPedidoUseCase confirmarPedidoUseCase;
    private final CancelarPedidoUseCase cancelarPedidoUseCase;

    public PedidoRestController(CrearPedidoUseCase crearPedidoUseCase,
                                AñadirProductoUseCase añadirProductoUseCase,
                                ConfirmarPedidoUseCase confirmarPedidoUseCase,
                                CancelarPedidoUseCase cancelarPedidoUseCase) {
        this.crearPedidoUseCase = crearPedidoUseCase;
        this.añadirProductoUseCase = añadirProductoUseCase;
        this.confirmarPedidoUseCase = confirmarPedidoUseCase;
        this.cancelarPedidoUseCase = cancelarPedidoUseCase;
    }

    // 🧾 Crear un nuevo pedido
    @PostMapping
    public Pedido crearPedido(@RequestParam Long clienteId) {
        return crearPedidoUseCase.crearPedido(clienteId);
    }

    // ➕ Añadir un producto al pedido
    @PostMapping("/{pedidoId}/productos")
    public void añadirProducto(@PathVariable Long pedidoId,
                               @RequestParam Long productoId,
                               @RequestParam int cantidad) {
        añadirProductoUseCase.añadirProducto(pedidoId, productoId, cantidad);
    }

    // ✅ Confirmar un pedido
    @PostMapping("/{pedidoId}/confirmar")
    public void confirmarPedido(@PathVariable Long pedidoId) {
        confirmarPedidoUseCase.confirmarPedido(pedidoId);
    }

    // ❌ Cancelar un pedido
    @PostMapping("/{pedidoId}/cancelar")
    public void cancelarPedido(@PathVariable Long pedidoId) {
        cancelarPedidoUseCase.cancelarPedido(pedidoId);
    }
}



