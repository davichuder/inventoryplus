# Patrones de Diseño y Arquitecturas por Etapa
Aca detallamos los patrones de diseño y las arquitecturas que se utilizarán en cada etapa del proyecto InventoryPlus.

#### Paso 0-3: Arquitectura Monolítica en Capas

*   **Patrón Arquitectónico:** **Arquitectura en capas tradicional**. Esta arquitectura organiza el sistema en capas (Presentación, Negocio, Datos), donde cada capa tiene una responsabilidad específica.
*   **Patrones Creacionales:**
    *   **Builder:** Introducido en el Paso 3 para la creación de objetos complejos.
*   **Patrones Estructurales:**
    *   **Layered Architecture (Arquitectura en Capas):** La organización fundamental del sistema en presentación, negocio y datos.
*   **Patrones de Comportamiento:** Ninguno específicamente mencionado en esta etapa.
*   **Patrones de UI/UX:**
    *   **CRUD básico:** Interfaz para crear, leer, actualizar y eliminar entidades.
*   **Principios de Diseño:** **DRY**, **KISS**, **YAGNI**, y los principios **SOLID** (**S** y **O**).
*   **Uso de Mappers:** **Mappers manuales simples** para la conversión entre DTOs y entidades.

#### Paso 4-9: Arquitectura Monolítica Modular

*   **Patrón Arquitectónico:** **Monolito modular**. El monolito se divide en módulos funcionales con límites explícitos.
*   **Patrones Creacionales:**
    *   **Builder:** Se sigue utilizando.
    *   **Factory Method:** Introducido en los Pasos 4-5 para la creación de objetos relacionados.
*   **Patrones Estructurales:**
    *   **Module:** El monolito se divide en módulos funcionales con límites explícitos.
*   **Patrones de Comportamiento:**
    *   **Specification Pattern:** Introducido en los Pasos 3-4 para consultas complejas y reutilizables.
    *   **Strategy Pattern:** Se menciona como introducido en los Pasos 7-8 para algoritmos intercambiables.
*   **Patrones de UI/UX:**
    *   **Búsqueda:** Se añade un buscador de productos rápido.
    *   **Notificaciones básicas:** Se introduce un contador de alertas.
*   **Principios de Diseño:** Se aplican las letras **L** e **I** de los principios **SOLID**.
*   **Uso de Mappers:** Introducción de **MapStruct** para el mapping automático.

#### Paso 10-15: Arquitectura de Transición a Microservicios

*   **Patrón Arquitectónico:** **Strangler Pattern** (para la migración gradual a microservicios).
*   **Patrones Creacionales:** Los patrones creacionales previos siguen siendo relevantes según las necesidades de los componentes.
*   **Patrones Estructurales:**
    *   **Backend for Frontend (BFF):** Se menciona para distintos tipos de clientes.
*   **Patrones de Comportamiento:**
    *   **Observer Pattern:** Introducido en el Paso 10 para notificaciones y eventos (implementado con RabbitMQ/eventos).
*   **Patrones de UI/UX:**
    *   **Notificaciones en tiempo real:** Implementadas con WebSockets.
    *   **Búsqueda avanzada:** Se añade autocompletado con Elasticsearch.
    *   **Dashboards en tiempo real:** Se introduce acceso a dashboards.
*   **Principios de Diseño:** Se aplica la letra **D** de los principios **SOLID**.

#### Paso 16-20: Arquitectura de Microservicios Completa

*   **Patrón Arquitectónico:** **Microservicios** con **Arquitectura Hexagonal**.
*   **Patrones Creacionales:** Los patrones creacionales previos siguen siendo relevantes dentro de cada microservicio.
*   **Patrones Estructurales:**
    *   **Microservices:** La aplicación se divide en servicios independientes.
    *   **Hexagonal Architecture (Ports and Adapters):** Cada microservicio adopta esta arquitectura para separar el dominio de la infraestructura.
    *   **API Gateway:** Punto único de entrada para los clientes.
    *   **Service Discovery:** Para la localización de servicios.
    *   **Circuit Breaker:** Para la gestión de fallos entre servicios.
*   **Patrones de Comportamiento:** Los patrones de comportamiento pueden utilizarse dentro de cada microservicio según su lógica de negocio (e.g., Strategy dentro de un servicio de precios).
*   **Patrones de UI/UX:**
    *   **Menú contextual:** El navbar evoluciona con un menú contextual según el microservicio actual.
    *   **Selección de tema:** Se añade la opción de tema claro/oscuro.
    *   **Panel de ayuda contextual:** Se introduce un panel de ayuda.
*   **Principios de Diseño:** **Clean Architecture**, **Domain-Driven Design (DDD)**, y el **Principio de Mínimo Conocimiento (Ley de Demeter)**.
*   **Uso de Mappers:** Los mappers forman parte de los adaptadores en la arquitectura hexagonal.