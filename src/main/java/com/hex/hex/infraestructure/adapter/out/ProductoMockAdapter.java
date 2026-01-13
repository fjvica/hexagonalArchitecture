package com.hex.hex.infraestructure.adapter.out;

import com.hex.hex.application.port.out.CargarProductoPort;
import com.hex.hex.domain.model.Producto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * 🧩 Adaptador de salida: ProductoMockAdapter
 *
 * Implementa el puerto de salida "CargarProductoPort".
 *
 * ▶️ Propósito:
 * - Simula la llamada a un microservicio externo que gestiona los productos.
 * - En un proyecto real, aquí habría una llamada HTTP o REST a otro servicio.
 *
 * ▶️ Ejemplo:
 * - Cargar producto por ID → retorna un objeto Producto de dominio.
 */
@Component
public class ProductoMockAdapter implements CargarProductoPort {

    @Override
    public Producto obtenerPorId(Long id) {
        // 🧠 En un sistema real: llamada HTTP, REST o base de datos
        // Aquí devolvemos un producto simulado
        return new Producto(id, "Producto " + id, BigDecimal.valueOf(10 + id));
    }
}


