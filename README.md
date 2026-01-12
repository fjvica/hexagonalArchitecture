# 🧩 Arquitectura Hexagonal con Spring Boot — Ejemplo completo

## 📘 Introducción

Este proyecto demuestra cómo aplicar la **arquitectura hexagonal (Ports & Adapters)** usando **Spring Boot** y **Spring Data JPA**.

El objetivo es desacoplar completamente la **lógica de negocio (núcleo)** de los **detalles técnicos** (controladores, frameworks, base de datos, etc.), logrando un sistema:

- Más **mantenible**
- Más **testeable**
- Más **fácil de extender** o modificar

---

## 🧠 Conceptos principales

| Concepto | Descripción |
|-----------|-------------|
| **Dominio** | Representa las reglas del negocio. No depende de frameworks ni librerías externas. |
| **Puerto de entrada (Inbound Port)** | Define las acciones que el mundo exterior puede solicitar (p. ej., crear un pedido). |
| **Puerto de salida (Outbound Port)** | Define las dependencias que el dominio necesita (p. ej., guardar un pedido). |
| **Adaptador de entrada (Inbound Adapter)** | Implementa la comunicación hacia el dominio (REST, CLI, mensajería, etc.). |
| **Adaptador de salida (Outbound Adapter)** | Implementa la comunicación desde el dominio hacia el exterior (base de datos, API externa, etc.). |

---

## ⚙️ Estructura del proyecto

```text
src/main/java/com/miempresa/tienda/
│
├── application/
│   ├── service/
│   │   └── CrearPedidoService.java
│   └── port/
│       ├── in/
│       │   └── CrearPedidoUseCase.java
│       └── out/
│           └── GuardarPedidoPort.java
│
├── domain/
│   └── model/
│       └── Pedido.java
│
├── infrastructure/
│   ├── adapter/
│   │   ├── in/
│   │   │   └── PedidoRestController.java
│   │   └── out/
│   │       └── PedidoJpaRepositoryAdapter.java
│   └── repository/
│       ├── PedidoJpaEntity.java
│       └── PedidoJpaRepository.java
│
└── TiendaApplication.java
