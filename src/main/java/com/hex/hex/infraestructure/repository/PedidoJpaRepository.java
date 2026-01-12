package com.hex.hex.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 🧭 REPOSITORIO SPRING DATA:
 *
 * Interfaz estándar de Spring Data JPA.
 *
 * Este es un detalle técnico del adaptador de salida.
 * No se expone fuera del paquete "infrastructure".
 */
public interface PedidoJpaRepository extends JpaRepository<PedidoJpaEntity, Long> {
}


