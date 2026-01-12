package com.hex.hex.infraestructure.adapter.in;

import com.hex.hex.application.port.in.CrearPedidoUseCase;
import com.hex.hex.domain.model.Pedido;
import org.springframework.web.bind.annotation.*;

/**
 * 🌐 ADAPTADOR DE ENTRADA (INBOUND ADAPTER):
 *
 * Expone la aplicación al mundo exterior (en este caso, vía HTTP REST).
 *
 * Recibe peticiones, las traduce al modelo de aplicación, y delega el trabajo al caso de uso
 * a través del puerto de entrada (CrearPedidoUseCase).
 *
 * El controlador no contiene lógica de negocio. Su función es conectar el exterior con el núcleo.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {

    private final CrearPedidoUseCase crearPedidoUseCase;

    // Se inyecta el puerto de entrada (interfaz del caso de uso),
    // no la implementación concreta → mantiene el desacoplamiento.
    public PedidoRestController(CrearPedidoUseCase crearPedidoUseCase) {
        this.crearPedidoUseCase = crearPedidoUseCase;
    }

    // Ejemplo de endpoint para crear un pedido
    @PostMapping
    public Pedido crearPedido(@RequestParam String cliente) {
        return crearPedidoUseCase.crearPedido(cliente);
    }
}

