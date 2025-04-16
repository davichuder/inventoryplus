# InventoryPlus - Sistema de Gestión de Inventario y Ventas

## Descripción General

InventoryPlus es un sistema de gestión de inventario y ventas diseñado para pequeñas empresas. Este proyecto tiene como objetivo evolucionar desde una aplicación monolítica básica hasta una arquitectura de microservicios avanzada. A lo largo de su desarrollo, se irán mejorando funcionalidades clave como la seguridad, el rendimiento y la escalabilidad. La versión inicial permitirá gestionar inventario, ventas, clientes y generar reportes básicos.

## Evolución del Proyecto

InventoryPlus se desarrollará de manera progresiva, aplicando nuevas tecnologías y conceptos arquitectónicos en cada etapa. A continuación, se destacan las mejoras planificadas en cada paso:

* **Paso 0 (Versión Inicial):** Gestión CRUD básica de productos, categorías, clientes y ventas. Interfaz con Thymeleaf. Autenticación básica con Spring Security. Base de datos MySQL.
* **Paso 1:** Testing con JUnit y Mockito: Implementación de pruebas unitarias, de integración y de controladores. Configuración de cobertura de código. Beneficio: Detección temprana de errores y refactorización segura.
* **Paso 2:** Logging y Monitoreo: Implementación de SLF4J con Logback para un sistema de logging estructurado, incluyendo logs de auditoría. Beneficio: Mejor diagnóstico de problemas y auditoría de actividades.
* **Paso 3:** Programación Funcional en Java: Refactorización usando Stream API, expresiones lambda y Optional para un código más conciso y legible. Beneficio: Código más legible y menos propenso a errores.
* **Paso 4:** Técnicas Avanzadas de Base de Datos: Optimización de consultas con índices, implementación de stored procedures y vistas materializadas para mejorar el rendimiento. Beneficio: Mejor rendimiento de la base de datos.
* **Paso 5:** Docker y Containerización: Contenerización de la aplicación con Docker y Docker Compose para un entorno de desarrollo consistente. Beneficio: Entorno de desarrollo consistente y preparación para despliegue simplificado.
* **Paso 6:** CI/CD Básico: Configuración de GitHub Actions para integración y despliegue continuos, incluyendo análisis estático de código. Beneficio: Detección temprana de problemas y despliegue automatizado.
* **Paso 7:** Caching: Implementación de caché con Caffeine y Redis para optimizar el rendimiento de operaciones frecuentes. Beneficio: Reducción significativa en tiempos de respuesta.
* **Paso 8:** Seguridad y Autenticación Avanzada: Mejora de la seguridad con JWT, roles y permisos granulares, autenticación de dos factores y OAuth2. Beneficio: Mayor seguridad y flexibilidad de autenticación.
* **Paso 9:** Programación Multi-hilo y Concurrencia: Implementación de procesamiento asíncrono para operaciones pesadas, mejorando la experiencia del usuario. Beneficio: Mejor rendimiento en operaciones pesadas.
* **Paso 10:** Colas de Mensajería con RabbitMQ: Integración de mensajería para un sistema de notificaciones basado en eventos y sincronización entre sucursales. Beneficio: Arquitectura más resiliente y capacidad para manejar picos de carga.
* **Paso 11:** WebSockets para Comunicación en Tiempo Real: Implementación de funcionalidades en tiempo real como dashboards y chat de soporte. Beneficio: Experiencia de usuario interactiva y datos actualizados.
* **Paso 12:** Bases de Datos NoSQL: MongoDB: Almacenamiento de datos no estructurados como el catálogo de productos con atributos variables y comentarios de usuarios. Beneficio: Mayor flexibilidad en el modelo de datos y mejor rendimiento para ciertos tipos de consultas.
* **Paso 13:** Redis para Caché y Estructuras Distribuidas: Uso de Redis para bloqueo distribuido, contadores en tiempo real y clasificación de productos. Beneficio: Mejor rendimiento en entorno distribuido y nuevas capacidades de análisis.
* **Paso 14:** Telemetría y Monitoreo con Prometheus/Grafana: Implementación de observabilidad del sistema con métricas y alertas. Beneficio: Visibilidad del comportamiento del sistema y detección temprana de problemas.
* **Paso 15:** Elasticsearch para Búsqueda Avanzada: Implementación de búsqueda potente en el catálogo con autocompletado y filtros. Beneficio: Experiencia de búsqueda superior para usuarios.
* **Paso 16:** gRPC para Comunicación entre Servicios: División de la aplicación en microservicios con comunicación eficiente usando gRPC. Beneficio: Comunicación más eficiente y tipada entre servicios.
* **Paso 17:** Domain-Driven Design (DDD): Refactorización arquitectónica basada en dominios de negocio para un código más mantenible. Beneficio: Mejor alineación con el negocio y código más mantenible.
* **Paso 18:** Arquitectura Hexagonal: Desacoplamiento de capas para mayor testabilidad y facilidad para cambiar componentes. Beneficio: Mayor facilidad para cambiar componentes y mejor testabilidad.
* **Paso 19:** Kubernetes Básico: Orquestación de contenedores para un despliegue escalable y resiliente. Beneficio: Despliegue escalable y resiliente.
* **Paso 20:** Spring Cloud para Microservicios: Implementación de un ecosistema completo de microservicios con patrones probados en la industria. Beneficio: Arquitectura completa de microservicios con patrones probados.

## Tecnologías Utilizadas (Evolución)

* **Paso 0-3:** Java, Spring Boot, MySQL, Thymeleaf, Lombok, Spring Security básico, Flyway.
* **Paso 1:** JUnit 5, Mockito, TestContainers, JaCoCo.
* **Paso 2:** SLF4J, Logback, MDC.
* **Paso 3:** Java Stream API, Lambdas, Optional, Collectors.
* **Paso 4:** Índices SQL, Stored Procedures, Vistas Materializadas.
* **Paso 5:** Docker, Docker Compose.
* **Paso 6:** GitHub Actions, SonarQube.
* **Paso 7:** Caffeine, Spring Cache, Hibernate L2 Cache.
* **Paso 8:** JWT, Spring Security avanzado, OAuth2.
* **Paso 9:** CompletableFuture, ThreadPoolTaskExecutor, `@Async`, JPA versioning.
* **Paso 10:** RabbitMQ, Spring AMQP.
* **Paso 11:** WebSockets, STOMP, SockJS.
* **Paso 12:** MongoDB, Spring Data MongoDB.
* **Paso 13:** Redis, Spring Data Redis, Redisson.
* **Paso 14:** Micrometer, Prometheus, Grafana.
* **Paso 15:** Elasticsearch, Spring Data Elasticsearch.
* **Paso 16:** gRPC, Protocol Buffers.
* **Paso 19:** Kubernetes, kubectl, Helm.
* **Paso 20:** Spring Cloud, Eureka, Spring Cloud Gateway, Resilience4J, Spring Cloud Config.

## Cómo Empezar

Para ejecutar la versión inicial del proyecto (Paso 0):

1.  Asegúrate de tener instalado Java y Maven.
2.  Configura una instancia de MySQL.
3.  Clona el repositorio del proyecto.
4.  Configura la conexión a la base de datos en el archivo de propiedades de Spring Boot (`application.properties` o `application.yml`).
5.  Ejecuta la aplicación Spring Boot utilizando Maven: `mvn spring-boot:run`.
6.  Accede a la aplicación a través de tu navegador.

**Nota:** Las instrucciones detalladas para cada fase y la configuración de las nuevas tecnologías se irán proporcionando a medida que el proyecto evoluciona.

## Estructura del Proyecto (Evolución)

La estructura del proyecto evolucionará desde una arquitectura monolítica en capas hasta una arquitectura monolítica modular, una fase de transición y finalmente una arquitectura completa de microservicios con arquitectura hexagonal. La organización de las carpetas y los módulos se adaptará en cada etapa para reflejar estos cambios.

## Contribuciones

Las contribuciones son bienvenidas.
Por favor, revisa las guías de contribución para más detalles sobre cómo puedes ayudar en el desarrollo de InventoryPlus.

## Licencia
Este proyecto está bajo la licencia MIT. Para más detalles, consulta el archivo [LICENSE](LICENSE).

## Contacto

- [David Rolón](https://github.com/davichuder)
- [Alexandro Moroz](https://github.com/AlexandroMoroz)