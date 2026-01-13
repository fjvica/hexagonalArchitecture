package com.hex.hex.application.service;

import com.hex.hex.application.port.in.AñadirProductoUseCase;
import com.hex.hex.application.port.out.CargarPedidoPort;
import com.hex.hex.application.port.out.CargarProductoPort;
import com.hex.hex.application.port.out.GuardarPedidoPort;
import com.hex.hex.domain.model.Pedido;
import com.hex.hex.domain.model.Producto;
import org.springframework.stereotype.Service;


/**
 * 🧩 Servicio de aplicación: AñadirProductoService
 *
 * Implementa el caso de uso de agregar un producto a un pedido.
 *
 * ▶️ Flujo:
 * 1. Cargar el pedido desde el puerto de salida (base de datos).
 * 2. Cargar el producto desde otro puerto (por ejemplo, servicio de catálogo).
 * 3. Invocar la lógica de dominio para añadir el producto.
 * 4. Guardar el pedido actualizado.
 *
 * ▶️ Importante:
 * - La lógica de negocio (validaciones, cálculos) está dentro del dominio (Pedido).
 * - Este servicio solo orquesta el flujo entre puertos.
 */
@Service
public class AñadirProductoService implements AñadirProductoUseCase {

    private final CargarPedidoPort cargarPedidoPort;
    private final CargarProductoPort cargarProductoPort;
    private final GuardarPedidoPort guardarPedidoPort;

    public AñadirProductoService(CargarPedidoPort cargarPedidoPort,
                                 CargarProductoPort cargarProductoPort,
                                 GuardarPedidoPort guardarPedidoPort) {
        this.cargarPedidoPort = cargarPedidoPort;
        this.cargarProductoPort = cargarProductoPort;
        this.guardarPedidoPort = guardarPedidoPort;
    }

    @Override
    public void añadirProducto(Long pedidoId, Long productoId, int cantidad) {
        // 1️⃣ Cargar pedido desde la base de datos
        Pedido pedido = cargarPedidoPort.obtenerPorId(pedidoId);

        // 2️⃣ Cargar producto desde el sistema de productos
        Producto producto = cargarProductoPort.obtenerPorId(productoId);

        // 3️⃣ Añadir producto al pedido (regla del dominio)
        pedido.añadirProducto(producto, cantidad);

        // 4️⃣ Persistir cambios
        guardarPedidoPort.guardar(pedido);
    }
}


