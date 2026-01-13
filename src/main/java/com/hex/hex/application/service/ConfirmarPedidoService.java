package com.hex.hex.application.service;

import com.hex.hex.application.port.in.ConfirmarPedidoUseCase;
import com.hex.hex.application.port.out.CargarPedidoPort;
import com.hex.hex.application.port.out.GuardarPedidoPort;
import com.hex.hex.application.port.out.NotificarPedidoConfirmadoPort;
import com.hex.hex.domain.model.Pedido;
import org.springframework.stereotype.Service;

// application/service/ConfirmarPedidoService.java
@Service
public class ConfirmarPedidoService implements ConfirmarPedidoUseCase {

    private final CargarPedidoPort cargarPedidoPort;
    private final GuardarPedidoPort guardarPedidoPort;
    private final NotificarPedidoConfirmadoPort notificarPedidoPort;

    public ConfirmarPedidoService(
            CargarPedidoPort cargarPedidoPort,
            GuardarPedidoPort guardarPedidoPort,
            NotificarPedidoConfirmadoPort notificarPedidoPort) {
        this.cargarPedidoPort = cargarPedidoPort;
        this.guardarPedidoPort = guardarPedidoPort;
        this.notificarPedidoPort = notificarPedidoPort;
    }

    @Override
    public void confirmarPedido(Long pedidoId) {
        Pedido pedido = cargarPedidoPort.obtenerPorId(pedidoId);
        pedido.confirmar();
        guardarPedidoPort.guardar(pedido);
        notificarPedidoPort.enviarEventoConfirmado(pedido);
    }
}
