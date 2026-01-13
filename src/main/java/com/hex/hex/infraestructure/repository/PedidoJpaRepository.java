package com.hex.hex.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 🧩 Repositorio Spring Data JPA
 *
 * Permite realizar operaciones CRUD sobre la entidad PedidoJpaEntity.
 *
 * ▶️ Notas:
 * - Este es un detalle técnico gestionado por Spring.
 * - La capa de aplicación nunca debe usarlo directamente.
 * - Se usa únicamente dentro del adaptador JPA.
 */
public interface PedidoJpaRepository extends JpaRepository<PedidoJpaEntity, Long> {
}



