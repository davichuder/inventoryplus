# InventoryPlus MVP: Especificaciones Iniciales

Para el MVP (Paso 0, Etapa 0, o Fase 0) del proyecto InventoryPlus, hay varias consideraciones importantes extraídas de las fuentes proporcionadas:

## Descripción General y Requerimientos Iniciales:

* El MVP consistirá en un sistema básico de gestión de inventario y ventas para pequeñas empresas.
* Deberá manejar las ventas diarias tanto presenciales como online.
* Tendrá un registro de clientes frecuentes.
* Generará reportes básicos de ventas y stock.
* Contará con un acceso seguro para distintos empleados.
* Los problemas principales a resolver inicialmente son la inexactitud del stock y la pérdida de tiempo en reportes manuales.

## Entregables del Paso 0:

* Una aplicación web Spring Boot con Thymeleaf para el frontend.
* CRUD básico (Crear, Leer, Actualizar, Eliminar) de productos, categorías, clientes y ventas.
* Autenticación básica con Spring Security utilizando usuario y contraseña.
* Una base de datos MySQL con las tablas principales.
* Controladores REST básicos.
* Implementación de Lombok para reducir el código boilerplate.
* Conexión básica con Flyway para migraciones de la base de datos SQL.
* Documentación básica de instalación y uso.
* Validación básica de formularios.

## Tecnologías a Utilizar:

* Java.
* Spring Boot.
* MySQL.
* Thymeleaf.
* Lombok.
* Spring Security básico.
* Flyway.
* Posiblemente Maven o Gradle para la gestión de dependencias.

## Estructura de la Aplicación (Carpetas):

* Una estructura básica que incluya carpetas para controller, service, repository, entity, common, y module dentro de `src/main/java`.
- **src**
    - **main**
        - **java**  
            - **com.example.inventoryplus**
                - **config**
                - **controller**
                - **dto**
                    - **request**
                    - **response**
                - **persistence**
                    - **entity**
                    - **enums**
                    - **repository**
                - **service**
                    - **impl**
                    - **interfaces**
                - **util**
                    - **mapper**
        - **resources**
    - **test/java/com.example.inventoryplus**

## Modelo de Datos (Tablas SQL Iniciales):

* `users` (id, username, password, role, active).
* `products` (id, name, description, price, stock, category_id, created_at).
* `categories` (id, name, description).
* `customers` (id, name, email, phone, address).
* `sales` (id, customer_id, total, date, user_id, status).
* `sale_items` (id, sale_id, product_id, quantity, price).

## Vistas Iniciales (Thymeleaf):

* **Login**: Formulario simple para iniciar sesión (usuario, contraseña).
* **Dashboard (Home)**: Resumen básico (total de productos, clientes, ventas del día), enlaces a secciones principales.
* **Productos**: Lista de productos con paginación básica, formulario CRUD, filtro simple por categoría.
* **Categorías**: Lista de categorías, formulario CRUD.
* **Clientes**: Lista de clientes, formulario CRUD.
* **Ventas**: Lista de ventas, formulario para nueva venta, detalle de venta.
* **Navbar/Header (básico)**: Logo, menú de navegación (Inicio, Productos, Categorías, Clientes, Ventas), usuario actual y botón de cierre de sesión.
* **Footer (básico)**: Información básica de contacto, enlaces a políticas y términos, copyright y versión del sistema.

## Documentación Inicial:

* Documento de Requisitos (Word/Markdown): Descripción del sistema inicial.
* Manual de Usuario Básico (PDF): Instrucciones para usuarios finales.
* README.md: Instrucciones de instalación y configuración.

## Diagramas Iniciales:

* Diagrama Entidad-Relación: Estructura de la base de datos inicial.
* Diagrama de Clases Simplificado: Modelo del dominio básico.
* Wireframes Básicos: Bocetos de interfaces principales.

## Seguridad Inicial:

* Contraseñas almacenadas utilizando BCrypt.
* Información de contacto de clientes protegida por control de acceso básico.
* Implementación básica de CSRF con tokens de Spring Security.
* Escape automático de contenido en Thymeleaf para protección básica contra XSS.
* Uso de JPA/Hibernate con parámetros preparados para prevenir SQL Injection.
* Validación básica de entradas.
* Autenticación basada en formulario con roles básicos (ROLE_ADMIN, ROLE_USER, ROLE_MANAGER).
* Permisos a nivel de método utilizando anotaciones básicas de Spring Security como `@PreAuthorize`.
* Logs básicos de la aplicación y del sistema de seguridad.

## Testing Inicial (Preparación):

* Aunque los entregables específicos de testing se definen para el Paso 1, es importante tener en cuenta que la calidad del código es fundamental desde el inicio.
* Se recomienda familiarizarse con JUnit 5 y Mockito desde esta etapa.
* La configuración de un entorno de desarrollo adecuado con TestContainers también es una consideración temprana.
* Se sugiere aplicar TDD por Componente, comenzando por las entidades y repositorios.
* Se deben realizar pruebas unitarias para la lógica de negocio en los servicios, las operaciones de acceso a datos en los repositorios y cualquier código utilitario.
* También se deben realizar pruebas de integración para verificar la interacción de los repositorios con la base de datos real utilizando TestContainers.
* Se podrían realizar pruebas básicas de los controladores para asegurar que las rutas y el manejo de las peticiones son correctos.

## Principios de Diseño Iniciales:

* Aplicar los principios DRY (Don't Repeat Yourself), KISS (Keep It Simple, Stupid), y YAGNI (You Aren't Gonna Need It).
* Comenzar a aplicar los principios SOLID, específicamente Single Responsibility y Open/Closed.

## Entornos Iniciales:

* Configuración de perfiles para default, dev, test, y prod. El entorno dev utilizará una base de datos en memoria (H2), logs detallados y seguridad simplificada. El entorno test se optimizará para pruebas automatizadas con TestContainers. El entorno prod se conectará a la base de datos real con logs de nivel INFO/WARN y seguridad completa.

## Escalabilidad y Tolerancia a Fallos Inicial:

* La estrategia de escalabilidad inicial será vertical, utilizando un único servidor con recursos escalables (CPU/RAM) y una base de datos MySQL en un servidor dedicado.
* Se implementarán backups regulares (diarios completos e incrementales cada 6 horas con retención de 30 días).
* Se establecerá un manejo de excepciones estructurado con logging detallado de errores y rollback automático para operaciones críticas.

## Métricas y Logging Inicial:

* Se definirán métricas técnicas básicas (tiempo de respuesta, tasas de error, uso de recursos) y métricas de negocio básicas (ventas diarias, productos más vendidos, tiempo de procesamiento de ventas).
* Inicialmente, los logs se analizarán manualmente para obtener estas métricas y se generarán reportes programados para las métricas de negocio.
* Se implementará un logging básico estructurado en formato JSON utilizando SLF4J con Logback, incluyendo campos como timestamp, level, logger, thread, message, userId, action, resourceId, y statusCode. Se configurarán niveles de log básicos (DEBUG, INFO, WARN, ERROR) y se establecerá una retención de logs (15 días para logs de aplicación y 1 año para logs de auditoría).

Tener en cuenta todas estas consideraciones proporcionará una base sólida para el desarrollo del MVP del proyecto InventoryPlus.