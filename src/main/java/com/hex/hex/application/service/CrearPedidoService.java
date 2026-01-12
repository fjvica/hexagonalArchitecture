package com.hex.hex.application.service;

import com.hex.hex.application.port.in.CrearPedidoUseCase;
import com.hex.hex.application.port.out.GuardarPedidoPort;
import com.hex.hex.domain.model.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * ⚙️ SERVICIO DE APLICACIÓN:
 *
 * Implementa un "caso de uso" definido por el puerto de entrada.
 *
 * Aquí se orquesta la lógica del flujo, pero NO se accede directamente a frameworks
 * (por ejemplo, no hay anotaciones de @Entity ni llamadas a repositorios de Spring Data directamente).
 *
 * Si necesita guardar datos, lo hace a través de un PUERTO DE SALIDA.
 *
 * Así:
 *   [Controlador REST] → (puerto de entrada) → [Servicio de aplicación]
 *       → (puerto de salida) → [Adaptador JPA]
 */
@Service
public class CrearPedidoService implements CrearPedidoUseCase {

    private final GuardarPedidoPort guardarPedidoPort;

    // Se inyecta el puerto de salida, no la implementación concreta.
    // Esto permite sustituir la capa de persistencia fácilmente.
    public CrearPedidoService(GuardarPedidoPort guardarPedidoPort) {
        this.guardarPedidoPort = guardarPedidoPort;
    }

    @Override
    public Pedido crearPedido(String cliente) {
        // 1️⃣ Crear objeto de dominio (independiente de la base de datos)
        Pedido pedido = new Pedido(null, cliente, LocalDate.now());

        // 2️⃣ Persistirlo a través del puerto de salida
        //    (la implementación real será un adaptador JPA o de otro tipo)
        return guardarPedidoPort.guardar(pedido);
    }
}

