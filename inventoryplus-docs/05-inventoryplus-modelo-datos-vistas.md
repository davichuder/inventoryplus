# Estructura de Vistas y Modelo de Datos para InventoryPlus
Ahroa exploraremos la evolución de la interfaz de usuario y el modelo de datos de InventoryPlus a lo largo de sus distintas etapas de desarrollo. Detallaremos cómo las vistas y tablas se adaptan a las nuevas funcionalidades, desde la simplicidad inicial hasta la complejidad de una arquitectura de microservicios, incluyendo la transformación de componentes clave como el navbar.
## Componentes Comunes (su evolución)
### Navbar/Header
**Paso 0-2 (Versión Básica)**
- Logo de Electrónica del Sur
- Menú de navegación: Inicio, Productos, Categorías, Clientes, Ventas
- Usuario actual y botón de cierre de sesión
- Implementado con Thymeleaf y Bootstrap
**Paso 3-7**
- Se añade buscador de productos rápido
- Notificaciones básicas (contador de alertas)
- Selector de sucursal
- Se mejora con estilos personalizados y animaciones
**Paso 8-11**
- Implementación de notificaciones en tiempo real (WebSockets)
- Avatar del usuario con menú desplegable
- Panel de acceso rápido a funciones frecuentes
- Indicadores de estado (online/offline)
**Paso 12-15**
- Búsqueda avanzada con autocompletado (Elasticsearch)
- Notificaciones personalizadas según rol
- Acceso a dashboards en tiempo real
- Indicador de sincronización entre sucursales
**Paso 16-20**
- Menú contextual según microservicio actual
- Selección de tema (claro/oscuro)
- Panel de ayuda contextual
- Acceso a métricas del sistema para administradores
### Footer
**Paso 0-7**
- Información básica de contacto
- Enlaces a políticas y términos
- Copyright y versión del sistema
**Paso 8-20**
- Enlaces a documentación
- Selector de idioma
- Estado del sistema
- Acceso a soporte técnico
- Últimas actualizaciones
---
## Vistas y Tablas por Fase
### Paso 0: MVP Inicial
**Vistas:**
1. **Login**
- Formulario de inicio de sesión simple
- Campos: usuario y contraseña
2. **Dashboard (Home)**
- Resumen básico: total de productos, clientes, ventas del día
- Enlaces a secciones principales
3. **Productos**
- Lista de productos con paginación básica
- Formulario CRUD de productos
- Filtro simple por categoría
4. **Categorías**
- Lista de categorías
- Formulario CRUD de categorías
5. **Clientes**
- Lista de clientes
- Formulario CRUD de clientes
6. **Ventas**
- Lista de ventas
- Formulario de nueva venta
- Detalle de venta
**Tablas SQL:**
1. `users` (id, username, password, role, active)
2. `products` (id, name, description, price, stock, category_id, created_at)
3. `categories` (id, name, description)
4. `customers` (id, name, email, phone, address)
5. `sales` (id, customer_id, total, date, user_id, status)
6. `sale_items` (id, sale_id, product_id, quantity, price)
### Paso 1: Testing con JUnit y Mockito
Sin cambios significativos en vistas o tablas, fase centrada en testing.
### Paso 2: Logging y Monitoreo Básico
**Vistas Nuevas:**
1. **Logs Viewer** (solo admin)
- Visualización de logs recientes
- Filtros por nivel y tipo de evento
**Tablas SQL Nuevas:**
1. `audit_logs` (id, user_id, action, entity_name, entity_id, old_value, new_value, timestamp, ip_address)
### Paso 3: Programación Funcional en Java
**Vistas Mejoradas:**
1. **Productos**
- Filtros avanzados múltiples (precio, marca, stock, etc.)
- Ordenamiento personalizable
2. **Ventas**
- Búsqueda y filtrado avanzado
3. **Reportes Básicos**
- Ventas por período
- Productos más vendidos
- Inventario bajo
### Paso 4: Técnicas Avanzadas de Base de Datos
**Tablas SQL Mejoradas:**
1. Índices en `products` (name, category_id)
2. Índices en `sales` (date, customer_id)
3. Índices en `sale_items` (product_id, sale_id)
**Nuevas Vistas de BD:**
1. `vw_product_sales` (vista para reportes de ventas por producto)
2. `vw_daily_sales` (vista para ventas diarias)
3. `vw_low_stock` (vista para productos con stock bajo)
**Stored Procedures:**
1. `sp_update_inventory` (actualiza stock basado en ventas)
2. `sp_sales_by_period` (genera reporte de ventas por período)
3. `sp_customer_purchases` (historial de compras por cliente)
### Paso 5: Docker y Containerización
Sin cambios en vistas o tablas, fase centrada en infraestructura.
### Paso 6: CI/CD Básico
Sin cambios en vistas o tablas, fase centrada en automatización.
### Paso 7: Caching
**Elementos Cacheados:**
1. Catálogo de productos (Caffeine)
2. Categorías (Caffeine)
3. Dashboard stats (TTL: 5 minutos)
4. Búsquedas frecuentes (TTL: 1 hora)
### Paso 8: Seguridad y Autenticación Avanzada
**Vistas Nuevas:**
1. **Login Mejorado**
- Opciones para OAuth (Google)
- Verificación 2FA
- "Recordarme"
2. **Gestión de Permisos** (admin)
- Asignación de roles y permisos
- Auditoría de accesos
**Tablas SQL Nuevas:**
1. `roles` (id, name, description)
2. `permissions` (id, name, description)
3. `role_permissions` (role_id, permission_id)
4. `user_roles` (user_id, role_id)
5. `access_log` (id, user_id, datetime, ip, user_agent, success)
### Paso 9: Programación Multi-hilo y Concurrencia
**Vistas Nuevas:**
1. **Centro de Tareas**
- Lista de tareas en ejecución
- Progreso de reportes
- Historial de tareas completadas
**Tablas SQL Nuevas:**
1. `async_tasks` (id, type, status, created_at, started_at, completed_at, result_path, created_by)
2. `product_version` (product_id, version) - para manejo de concurrencia optimista
### Paso 10: Colas de Mensajería con RabbitMQ
**Vistas Nuevas:**
1. **Estado de Sincronización**
- Estado de sincronización entre sucursales
- Eventos pendientes
2. **Alertas y Notificaciones**
- Centro de notificaciones
- Configuración de alertas
**Tablas SQL Nuevas:**
1. `branches` (id, name, address, contact, active)
2. `notification_preferences` (user_id, notification_type, enabled)
3. `message_log` (id, queue_name, message_id, status, sent_at, processed_at)
### Paso 11: WebSockets para Comunicación en Tiempo Real
**Vistas Nuevas:**
1. **Dashboard en Tiempo Real**
- Gráficos actualizados en tiempo real
- Contador de ventas del día
2. **Chat de Soporte**
- Interfaz de chat
- Estado de conexión
- Historial de conversaciones
**Tablas SQL Nuevas:**
1. `chat_messages` (id, sender_id, receiver_id, content, sent_at, read_at)
2. `online_status` (user_id, status, last_active)
### Paso 12: Bases de Datos NoSQL: MongoDB
**Colecciones MongoDB:**
1. `product_details` (relacionada con products SQL mediante product_id)
- Especificaciones técnicas variables según categoría
- Imágenes múltiples
- Información de garantía
- Documentos relacionados
2. `reviews`
- Valoraciones de productos
- Comentarios
- Imágenes de usuarios
3. `user_activity`
- Historial de navegación
- Productos vistos
- Búsquedas realizadas
**Vistas Nuevas:**
1. **Ficha de Producto Detallada**
- Especificaciones técnicas
- Reseñas y valoraciones
- Productos relacionados
2. **Perfil de Cliente Mejorado**
- Historial de actividad
- Preferencias y productos favoritos
### Paso 13: Redis para Caché y Estructuras Distribuidas
**Estructuras Redis:**
1. **Claves/Valores:**
- Sesiones de usuario (`session:{id}`)
- Bloqueos de inventario (`lock:product:{id}`)
- Contadores (`counter:views:product:{id}`)
2. **Listas:**
- Últimos productos vistos (`recent:user:{id}`)
3. **Sets Ordenados:**
- Productos más vendidos (`top:products`)
- Productos más buscados (`top:searches`)
4. **Hashes:**
- Carrito de compra (`cart:user:{id}`)
- Estado de usuario (`user:status:{id}`)
### Paso 14: Telemetría y Monitoreo con Prometheus/Grafana
**Vistas Nuevas:**
1. **Panel de Estado**
- Métricas de rendimiento
- Alertas activas
- Estado de servicios
2. **Dashboards Administrativos**
- Uso del sistema
- Patrones de venta
- Análisis de tendencias
### Paso 15: Elasticsearch para Búsqueda Avanzada
**Índices Elasticsearch:**
1. `products` (duplica y expande datos de productos para búsqueda)
2. `categories` (para facetas y navegación)
3. `search_logs` (para mejorar resultados basados en comportamiento)
**Vistas Mejoradas:**
1. **Búsqueda Avanzada**
- Autocompletado
- Filtros dinámicos (facetas)
- Resultados por relevancia
- Corrección de errores
### Paso 16: gRPC para Comunicación entre Servicios
**División en Microservicios:**
1. **Servicio de Inventario**
- Gestión de productos
- Gestión de categorías
- Control de stock
2. **Servicio de Ventas**
- Procesamiento de ventas
- Facturación
- Reportes de ventas
3. **Servicio de Usuarios y Clientes**
- Autenticación y autorización
- Gestión de clientes
- Preferencias y perfiles
4. **Servicio de Notificaciones**
- Gestión de alertas
- Envío de emails
- Mensajería push
### Paso 17: Domain-Driven Design (DDD)
**Reorganización del Modelo:**
1. **Contexto de Catálogo**
- Entidades: Producto, Categoría, Proveedor
- Agregado: Producto (raíz)
- Eventos: ProductoCreado, ProductoActualizado, StockModificado
2. **Contexto de Ventas**
- Entidades: Venta, LineaVenta, Cliente
- Agregado: Venta (raíz)
- Eventos: VentaIniciada, VentaCompletada, VentaCancelada
3. **Contexto de Usuarios**
- Entidades: Usuario, Rol, Permiso
- Agregado: Usuario (raíz)
- Eventos: UsuarioCreado, PermisosCambiados
4. **Contexto de Reporting**
- Entidades: Reporte, Parámetro
- Value Objects: PeriodoReporte, FormatoReporte
### Paso 18: Arquitectura Hexagonal
**Reorganización Arquitectónica:**
1. **Capa de Dominio** (independiente de infraestructura)
- Entidades de dominio
- Reglas de negocio
- Interfaces de repositorio (puertos)
2. **Capa de Aplicación**
- Casos de uso
- Servicios de aplicación
- DTOs
3. **Capa de Infraestructura**
- Adaptadores para persistencia (SQL, MongoDB, Redis)
- Adaptadores para UI (Web, API)
- Adaptadores para servicios externos
4. **Capa de Presentación**
- Controladores
- Vistas
- API REST/GraphQL
### Paso 19: Kubernetes Básico
Sin cambios significativos en vistas o tablas, enfocado en infraestructura.
### Paso 20: Spring Cloud para Microservicios
**Componentes Adicionales:**
1. **API Gateway**
- Enrutamiento unificado
- Autenticación centralizada
- Rate limiting
2. **Service Discovery**
- Registro automático de servicios
- Balanceo de carga
3. **Config Server**
- Configuración centralizada
- Perfiles por entorno
4. **Circuit Breaker Dashboard**
- Estado de los circuit breakers
- Historial de fallos
---
## Resumen de Evolución de Datos
### MySQL (Relacional)
- Datos estructurados con relaciones claras
- Transacciones críticas (ventas, inventario)
- Información de usuarios y seguridad
- Auditoría y logs persistentes
### MongoDB (NoSQL)
- Datos variables por tipo de producto (especificaciones)
- Contenido generado por usuarios (reseñas, comentarios)
- Documentos (facturas, garantías)
- Historial de actividad detallado
### Redis (Caché/Estructuras Distribuidas)
- Datos de sesión
- Clasificaciones y contadores en tiempo real
- Bloqueos distribuidos para concurrencia
- Información temporal y de alta frecuencia de acceso
### Elasticsearch (Búsqueda)
- Índices para búsqueda full-text
- Datos enriquecidos para búsqueda
- Logs de búsqueda y comportamiento
- Análisis de texto y sugerencias
---
Esta estructura evoluciona gradualmente, manteniendo la compatibilidad con versiones anteriores mientras se añaden nuevas capacidades. Las tablas y vistas reflejan las necesidades del negocio en cada etapa, y los componentes comunes como el navbar se enriquecen con nuevas funcionalidades a medida que el sistema crece en complejidad y capacidades.