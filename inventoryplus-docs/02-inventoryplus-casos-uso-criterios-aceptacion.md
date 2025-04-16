# Casos de Uso, Priorización y Criterios de Aceptación por Etapa
Esta presentacion es un plan completo para cada etapa del proyecto InventoryPlus, incluyendo casos de uso detallados, estrategia de priorización, criterios de aceptación y enfoque de usabilidad.
## Paso 0: MVP Inicial
### Casos de Uso Detallados
**CU-01: Gestión de Productos**
- **Actor principal**: Gerente, Personal de almacén
- **Descripción**: El usuario puede crear, ver, actualizar y eliminar productos en el inventario
- **Flujo básico**:
1. Usuario navega a la sección "Productos"
2. Visualiza la lista de productos existentes
3. Puede filtrar por nombre o categoría
4. Puede crear un nuevo producto completando el formulario
5. Puede editar o eliminar productos existentes
**CU-02: Registro de Ventas**
- **Actor principal**: Vendedor
- **Descripción**: El usuario puede registrar una nueva venta
- **Flujo básico**:
1. Usuario navega a "Nueva Venta"
2. Selecciona cliente existente o crea uno nuevo
3. Agrega productos a la venta (búsqueda y cantidad)
4. Sistema calcula el total
5. Usuario completa la venta y genera comprobante
**CU-03: Consulta de Inventario**
- **Actor principal**: Vendedor, Gerente, Personal de almacén
- **Descripción**: El usuario puede consultar stock actual de productos
- **Flujo básico**:
1. Usuario navega a "Inventario"
2. Visualiza productos y cantidades
3. Puede filtrar por categoría o nombre
4. Puede ver detalle de cada producto
**CU-04: Gestión de Usuarios**
- **Actor principal**: Administrador
- **Descripción**: El administrador gestiona usuarios del sistema
- **Flujo básico**:
1. Administrador accede a "Usuarios"
2. Visualiza lista de usuarios
3. Puede crear nuevos usuarios con roles asignados
4. Puede editar o desactivar usuarios existentes
### Priorización
- Método: MoSCoW (Must, Should, Could, Won't)
- Must: CU-01, CU-02, CU-03 (funcionalidades críticas para operación)
- Should: CU-04 (importante pero no impide operación inicial)
### Criterios de Aceptación
1. **Funcionales**:
- Todos los flujos básicos de los casos de uso funcionan sin errores
- La actualización del inventario es inmediata tras una venta
- Las búsquedas de productos devuelven resultados correctos
2. **No funcionales**:
- Tiempo de respuesta < 2 segundos para operaciones básicas
- UI funcional en Chrome, Firefox y Edge
- Formularios con validación adecuada
### Pruebas de Usabilidad
- **Tipo**: Evaluación heurística básica
- **Participantes**: 2-3 empleados de la tienda
- **Enfoque**: Simplicidad de uso en tareas cotidianas
## Paso 1-3: Mejoras en Testing, Logging y Programación Funcional
### Casos de Uso Adicionales
**CU-05: Reportes Básicos**
- **Actor principal**: Gerente
- **Descripción**: Generación de reportes predefinidos
- **Flujo básico**:
1. Usuario navega a "Reportes"
2. Selecciona tipo de reporte (ventas diarias, stock bajo, etc.)
3. Configura parámetros (periodo, categorías, etc.)
4. Visualiza resultados en formato tabular y gráfico
5. Puede exportar a Excel/PDF
**CU-06: Búsqueda Avanzada de Productos**
- **Actor principal**: Vendedor, Gerente
- **Descripción**: Búsqueda con filtros combinados
- **Flujo básico**:
1. Usuario navega a "Productos"
2. Utiliza múltiples filtros (rango de precio, stock, marca, etc.)
3. Sistema muestra resultados en tiempo real
4. Usuario puede ordenar por distintos criterios
**CU-07: Seguimiento de Actividad**
- **Actor principal**: Administrador, Gerente
- **Descripción**: Visualización de logs de acciones importantes
- **Flujo básico**:
1. Usuario accede a "Registro de Actividad"
2. Visualiza acciones recientes (creación/modificación de productos, ventas, etc.)
3. Puede filtrar por tipo de acción, usuario o fecha
4. Puede ver detalles de cada acción
### Priorización
- Método: Valor vs. Esfuerzo + Dependencias técnicas
- Alta prioridad: CU-06 (alto valor, aprovecha programación funcional)
- Media prioridad: CU-05 (alto valor, esfuerzo medio)
- Baja prioridad: CU-07 (valor medio, depende de implementación de logging)
### Criterios de Aceptación
1. **Funcionales**:
- Los reportes muestran datos precisos y consistentes
- La búsqueda avanzada maneja correctamente múltiples criterios
- El log de actividad captura todas las acciones importantes
2. **No funcionales**:
- Cobertura de pruebas >80% para código nuevo
- Logs estructurados y niveles apropiados
- Implementación de patrones funcionales en operaciones con colecciones
### Pruebas de Usabilidad
- **Tipo**: Test de tareas específicas
- **Participantes**: 4-5 usuarios representando distintos roles
- **Enfoque**: Eficiencia en búsquedas y generación de reportes
## Paso 4-7: Técnicas Avanzadas de BD, Docker, CI/CD y Caché
### Casos de Uso Adicionales
**CU-08: Dashboard en Tiempo Real**
- **Actor principal**: Gerente
- **Descripción**: Panel con KPIs actualizados
- **Flujo básico**:
1. Usuario accede al dashboard principal
2. Visualiza indicadores clave (ventas del día, productos más vendidos, etc.)
3. Puede cambiar la vista (diaria, semanal, mensual)
4. Dashboard se actualiza periódicamente
**CU-09: Sincronización entre Sucursales**
- **Actor principal**: Gerente, Personal de almacén
- **Descripción**: Visualizar y transferir stock entre sucursales
- **Flujo básico**:
1. Usuario navega a "Gestión Multi-sucursal"
2. Selecciona producto y visualiza stock en cada sucursal
3. Puede crear orden de transferencia entre sucursales
4. Sistema actualiza inventarios en ambas sucursales
**CU-10: Gestión de Ofertas y Promociones**
- **Actor principal**: Gerente, Marketing
- **Descripción**: Creación y gestión de ofertas por tiempo limitado
- **Flujo básico**:
1. Usuario navega a "Promociones"
2. Crea nueva promoción (descuento porcentual, 2x1, etc.)
3. Asigna productos y periodo de validez
4. El sistema aplica automáticamente las promociones en ventas
### Priorización
- Método: Impacto en negocio + Factibilidad técnica
- Primera iteración: CU-08 (aprovecha cachés y mejoras de BD)
- Segunda iteración: CU-10 (valor comercial alto)
- Tercera iteración: CU-09 (requiere infraestructura multisucursal completa)
### Criterios de Aceptación
1. **Funcionales**:
- Dashboard muestra datos en tiempo real (< 1 min de retraso)
- Sincronización entre sucursales mantiene consistencia
- Las promociones se aplican correctamente en todos los escenarios
2. **No funcionales**:
- Despliegue automatizado funciona correctamente
- Sistema funciona correctamente en contenedores
- Índices de BD mejoran tiempos de respuesta (>50% mejora)
- Hit ratio de caché >80% para páginas frecuentes
### Pruebas de Usabilidad
- **Tipo**: Testing A/B para dashboard
- **Participantes**: Gerentes de todas las sucursales
- **Enfoque**: Comprensión visual de datos y toma de decisiones
## Paso 8-12: Seguridad Avanzada, Concurrencia, RabbitMQ, WebSockets y MongoDB
### Casos de Uso Adicionales
**CU-11: Notificaciones en Tiempo Real**
- **Actor principal**: Todos los usuarios
- **Descripción**: Recibir alertas de eventos importantes
- **Flujo básico**:
1. Sistema detecta evento importante (stock bajo, gran venta, etc.)
2. Envía notificación en tiempo real a usuarios relevantes
3. Usuario ve notificación y puede acceder al detalle
4. Puede marcar como leída o tomar acción
**CU-12: Chat de Soporte Interno**
- **Actor principal**: Todos los usuarios
- **Descripción**: Comunicación interna entre personal
- **Flujo básico**:
1. Usuario abre panel de chat desde cualquier pantalla
2. Selecciona destinatario o grupo
3. Envía mensajes de texto e imágenes
4. Recibe respuestas en tiempo real
**CU-13: Catálogo Enriquecido con Especificaciones Técnicas**
- **Actor principal**: Vendedor, Cliente (futura integración web)
- **Descripción**: Vista detallada de productos con especificaciones variables
- **Flujo básico**:
1. Usuario accede al detalle de un producto
2. Visualiza especificaciones técnicas detalladas según categoría
3. Puede ver imágenes múltiples y documentos asociados
4. Puede comparar especificaciones entre productos similares
**CU-14: Sistema de Valoraciones y Comentarios**
- **Actor principal**: Vendedor, Gerente
- **Descripción**: Registro de feedback de clientes
- **Flujo básico**:
1. Usuario registra feedback del cliente para un producto
2. Asigna valoración (1-5 estrellas) y comentarios
3. Sistema almacena la valoración asociada al producto
4. Gerentes pueden ver reportes de satisfacción
### Priorización
- Método: Valor estratégico + Dependencias tecnológicas
- Primera fase: CU-11 (aprovecha WebSockets y RabbitMQ)
- Segunda fase: CU-13 (aprovecha MongoDB para datos variables)
- Tercera fase: CU-14 (complementa catálogo enriquecido)
- Cuarta fase: CU-12 (aprovecha infraestructura de tiempo real ya implementada)
### Criterios de Aceptación
1. **Funcionales**:
- Notificaciones llegan en < 3 segundos tras el evento
- Chat mantiene historial y funciona entre sucursales
- Especificaciones técnicas se muestran correctamente para todas las categorías
- Sistema de valoraciones calcula promedios precisos
2. **No funcionales**:
- Autenticación JWT funciona correctamente en todos los endpoints
- Procesamiento concurrente sin condiciones de carrera
- WebSockets mantienen conexión estable incluso con interrupciones breves
- MongoDB escala correctamente con crecimiento de catálogo
### Pruebas de Usabilidad
- **Tipo**: Test de usuario con eye-tracking
- **Participantes**: Vendedores y representantes de clientes
- **Enfoque**: Experiencia con catálogo enriquecido y notificaciones
## Paso 13-15: Redis, Telemetría y Elasticsearch
### Casos de Uso Adicionales
**CU-15: Reserva de Productos en Tiempo Real**
- **Actor principal**: Vendedor
- **Descripción**: Bloqueo temporal de productos para cliente interesado
- **Flujo básico**:
1. Vendedor identifica cliente interesado en producto con stock limitado
2. Activa "reserva temporal" por 30 minutos
3. Sistema bloquea el stock para otros vendedores
4. Finaliza al completar venta o expirar tiempo
**CU-16: Búsqueda Inteligente con Autocompletado**
- **Actor principal**: Todos los usuarios
- **Descripción**: Búsqueda predictiva con corrección de errores
- **Flujo básico**:
1. Usuario comienza a escribir en barra de búsqueda
2. Sistema muestra sugerencias en tiempo real
3. Tolera errores ortográficos y muestra resultados relevantes
4. Prioriza resultados por popularidad y relevancia
**CU-17: Monitoreo de Salud del Sistema**
- **Actor principal**: Administrador, Soporte Técnico
- **Descripción**: Dashboard de estado del sistema
- **Flujo básico**:
1. Usuario accede a panel de monitoreo
2. Visualiza métricas clave (CPU, memoria, tiempos de respuesta)
3. Puede ver alertas activas y su histórico
4. Puede profundizar en métricas específicas
### Priorización
- Método: ROI estimado + Beneficio operativo
- Alta prioridad: CU-16 (mejora experiencia de todos los usuarios, usa Elasticsearch)
- Media prioridad: CU-15 (soluciona problema de concurrencia, usa Redis)
- Soporte: CU-17 (fundamental para mantenimiento, usa telemetría)
### Criterios de Aceptación
1. **Funcionales**:
- La reserva temporal bloquea efectivamente el stock
- La búsqueda encuentra productos relevantes incluso con errores tipográficos
- Dashboard de monitoreo muestra datos actualizados < 1 min
2. **No funcionales**:
- Redis mantiene consistencia en bloqueos distribuidos
- Elasticsearch responde en < 200ms incluso con catálogo grande
- Telemetría captura > 95% de eventos relevantes
- Alertas detectan problemas antes que afecten a usuarios
### Pruebas de Usabilidad
- **Tipo**: Test de campo con usuarios reales
- **Participantes**: Vendedores en entorno real + clientes seleccionados
- **Enfoque**: Eficiencia de búsqueda y proceso de venta con reserva
## Paso 16-20: Microservicios con gRPC, DDD, Arquitectura Hexagonal y Kubernetes
### Casos de Uso Adicionales
**CU-18: Gestión de Ventas Mayoristas**
- **Actor principal**: Vendedor Mayorista, Gerente
- **Descripción**: Flujo específico para ventas corporativas
- **Flujo básico**:
1. Usuario selecciona "Venta Mayorista"
2. Sistema aplica reglas de negocio específicas (descuentos por volumen, crédito)
3. Genera documentación específica (orden de compra, contrato)
4. Gestiona proceso de aprobación si es necesario
**CU-19: Aplicación Móvil para Vendedores**
- **Actor principal**: Vendedor
- **Descripción**: Acceso a funciones clave desde dispositivo móvil
- **Flujo básico**:
1. Vendedor accede desde app móvil
2. Puede consultar stock y precios
3. Puede iniciar ventas y reservas
4. Recibe notificaciones en tiempo real
**CU-20: Integración con Marketplace Externo**
- **Actor principal**: Sistema, Gerente
- **Descripción**: Sincronización con plataformas como MercadoLibre
- **Flujo básico**:
1. Sistema sincroniza catálogo con marketplace
2. Recibe órdenes automáticamente
3. Actualiza stock en ambas plataformas
4. Genera reportes unificados
**CU-21: Panel de Análisis Predictivo**
- **Actor principal**: Gerente, Analista
- **Descripción**: Análisis avanzado con predicciones
- **Flujo básico**:
1. Usuario accede a "Análisis Predictivo"
2. Selecciona modelos (predicción de ventas, recomendación de stock)
3. Visualiza proyecciones y recomendaciones
4. Puede ajustar parámetros y ver escenarios alternativos
### Priorización
- Método: Alineación estratégica + Arquitectura evolutiva
- Primera fase: CU-18 (aprovecha DDD para reglas de negocio complejas)
- Segunda fase: CU-19 (aprovecha arquitectura de microservicios y API Gateway)
- Tercera fase: CU-20 (aprovecha integración con sistemas externos)
- Fase final: CU-21 (aprovecha datos recopilados y toda la infraestructura)
### Criterios de Aceptación
1. **Funcionales**:
- Ventas mayoristas aplican correctamente reglas de negocio específicas
- App móvil funciona offline con sincronización posterior
- Integración con marketplace mantiene consistencia bidireccional
- Predicciones tienen precisión > 85% en ventanas de 30 días
2. **No funcionales**:
- Arquitectura soporta fallos parciales sin afectar todo el sistema
- Microservicios escalan independientemente según necesidad
- Tiempo de respuesta en app móvil < 1s con conexión 4G
- Sistema completo puede desplegarse en nueva región en < 1 día
### Pruebas de Usabilidad
- **Tipo**: Estudio longitudinal + Métricas de uso
- **Participantes**: Toda la organización + Clientes mayoristas
- **Enfoque**: Adopción de nuevas funcionalidades y productividad
## Estrategia General de Priorización
La priorización de funcionalidades a lo largo del proyecto se basa en una combinación de los siguientes factores:
1. **Valor para el Negocio**
- Impacto directo en ventas o eficiencia operativa
- Solución a problemas existentes reportados por usuarios
- Ventaja competitiva en el mercado
2. **Dependencias Técnicas**
- Aprovechamiento de tecnologías implementadas en cada fase
- Construcción progresiva de funcionalidades complejas
- Minimización de refactorización posterior
3. **Esfuerzo vs. Impacto**
- Priorización de "victorias rápidas" en etapas iniciales
- Balance entre inversión técnica y beneficio inmediato
- Distribución equilibrada de complejidad entre fases
4. **Feedback de Usuarios**
- Ajuste de prioridades basado en uso real del sistema
- Evolución según necesidades emergentes
- Corrección temprana de problemas identificados
## Criterios de Aceptación Transversales
Además de los criterios específicos para cada fase, estos criterios se aplican a lo largo de todo el proyecto:
### Criterios Funcionales Transversales
1. Toda funcionalidad debe funcionar en todas las sucursales
2. Cambios de estado críticos (ventas, stock) deben ser atómicos
3. Generación de comprobantes debe cumplir requisitos legales
4. Debe existir trazabilidad completa de operaciones críticas
### Criterios No Funcionales Transversales
1. **Rendimiento**: Operaciones comunes < 2 segundos en condiciones normales
2. **Disponibilidad**: Tiempo de actividad > 99.5% en horario comercial
3. **Seguridad**: Sin vulnerabilidades de severidad alta en escaneos
4. **Accesibilidad**: Interfaces cumplen WCAG 2.1 nivel AA
5. **Mantenibilidad**: Cobertura de código > 75%
## Estrategia de Pruebas de Usabilidad
Las pruebas de usabilidad evolucionan a lo largo del proyecto, siguiendo esta progresión:
### Fase Inicial (Pasos 0-3)
- **Enfoque**: Descubrimiento de problemas básicos
- **Métodos**: Evaluación heurística, observación directa
- **Métricas**: Tasa de completitud de tareas, errores críticos
- **Impacto**: Correcciones inmediatas de problemas evidentes
### Fase Intermedia (Pasos 4-12)
- **Enfoque**: Optimización de flujos principales
- **Métodos**: Testing A/B, eye-tracking, entrevistas contextuales
- **Métricas**: Tiempo de completitud, satisfacción del usuario
- **Impacto**: Refinamiento de patrones de UI y flujos complejos
### Fase Avanzada (Pasos 13-20)
- **Enfoque**: Experiencia unificada multicanal
- **Métodos**: Análisis de telemetría, estudios longitudinales
- **Métricas**: Tasas de adopción, retención, productividad
- **Impacto**: Optimización continua basada en patrones de uso real
---
Esta estrategia integral de casos de uso, priorización, criterios de aceptación y usabilidad garantiza que el sistema evolucione de manera coherente, atendiendo tanto las necesidades del negocio como la experiencia de los usuarios finales, mientras aprovecha eficientemente las tecnologías implementadas en cada fase.