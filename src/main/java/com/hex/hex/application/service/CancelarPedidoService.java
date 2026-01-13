package com.hex.hex.application.service;

import com.hex.hex.application.port.in.CancelarPedidoUseCase;
import com.hex.hex.application.port.out.CargarPedidoPort;
import com.hex.hex.application.port.out.GuardarPedidoPort;
import com.hex.hex.domain.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class CancelarPedidoService implements CancelarPedidoUseCase {

    private final CargarPedidoPort cargarPedidoPort;
    private final GuardarPedidoPort guardarPedidoPort;

    public CancelarPedidoService(CargarPedidoPort cargarPedidoPort,
                                 GuardarPedidoPort guardarPedidoPort) {
        this.cargarPedidoPort = cargarPedidoPort;
        this.guardarPedidoPort = guardarPedidoPort;
    }

    @Override
    public void cancelarPedido(Long pedidoId) {
        Pedido pedido = cargarPedidoPort.obtenerPorId(pedidoId);
        pedido.cancelar();
        guardarPedidoPort.guardar(pedido);
    }
}

