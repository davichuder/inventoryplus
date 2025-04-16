# Proyecto InventoryPlus - Cliente Inicial
En esta primera etapa, nos adentramos en el núcleo de InventoryPlus, simulando los desafíos y necesidades de un cliente que busca optimizar la gestión de su negocio. Exploraremos los requisitos iniciales y funcionalidades esenciales que sentarán las bases para el desarrollo del sistema, desde la perspectiva de un usuario que enfrenta problemas cotidianos de inventario y ventas.
## Presentación del Cliente
Hola, soy Carlos Martínez, dueño de "Electrónica del Sur", una tienda de electrónica con dos sucursales en Buenos Aires y una online. Vendemos desde celulares y accesorios hasta computadoras y pequeños electrodomésticos.
## Necesidad Inicial
Actualmente llevamos el control de inventario y ventas con Excel y un sistema antiguo que ya no nos sirve. Necesitamos urgente un sistema que nos permita:
- Registrar productos con sus características, precios y stock
- Manejar las ventas diarias tanto presenciales como online
- Llevar un registro de clientes frecuentes
- Generar reportes básicos de ventas y stock
- Tener un acceso seguro para distintos empleados
El problema más grande que tenemos es que nunca sabemos exactamente qué tenemos en stock. A veces vendemos productos por la web que no están disponibles, o no podemos encontrarlos en tienda aunque el sistema dice que deberían estar. También perdemos mucho tiempo haciendo reportes manuales para conocer qué productos se están vendiendo mejor.
---
# Evolución de Requerimientos del Cliente
## Paso 1: Testing con JUnit y Mockito
**Solicitud del cliente:** "Tuvimos varios errores en el cálculo de precios con descuentos y en la actualización del stock. Un cliente compró un televisor que mostraba un precio con 25% de descuento, pero al finalizar la compra se le cobró el precio completo. Necesitamos estar seguros de que el sistema funciona correctamente antes de seguir."
## Paso 2: Logging y Monitoreo
**Solicitud del cliente:** "La semana pasada desapareció un stock de 5 iPhones y no sabemos si fue un error del sistema o si alguien los sacó sin registrar la venta. Necesitamos saber quién hace cada cambio en el sistema y tener un registro de todas las operaciones críticas. También queremos poder detectar rápidamente cuando algo falla."
## Paso 3: Programación Funcional en Java
**Solicitud del cliente:** "Los clientes nos piden filtrar productos por muchas combinaciones diferentes: por marca, precio, características, disponibilidad, etc. También necesitamos reportes más flexibles de ventas por diferentes criterios. El sistema actual es muy lento cuando intentamos hacer estas operaciones."
## Paso 4: Técnicas Avanzadas de Base de Datos
**Solicitud del cliente:** "El sistema se está volviendo lento, especialmente cuando hacemos búsquedas o generamos reportes de fin de mes. Los fines de semana, cuando tenemos más ventas, a veces se cuelga completamente. También necesitamos reportes más complejos para analizar tendencias de ventas."
## Paso 5: Docker y Containerización
**Solicitud del cliente:** "Estamos por abrir una tercera sucursal y queremos implementar el sistema allí también. Además, nuestro servidor actual está teniendo problemas y el técnico dice que necesitamos migrar a un servidor nuevo. Necesitamos poder instalar el sistema fácilmente en diferentes lugares y que sea fácil de mantener."
## Paso 6: CI/CD Básico
**Solicitud del cliente:** "Cada vez que les pedimos un cambio o una mejora, tardan días en implementarlo y probarlo. A veces cuando suben cambios, algo deja de funcionar. Necesitamos que las actualizaciones sean más rápidas y seguras."
## Paso 7: Caching
**Solicitud del cliente:** "Durante eventos de venta como el Hot Sale o Black Friday, nuestro sitio se vuelve extremadamente lento. Muchos clientes abandonan sus compras por esto. El catálogo tiene miles de productos y las páginas tardan demasiado en cargar, especialmente las más visitadas como ofertas del día."
## Paso 8: Seguridad y Autenticación Avanzada
**Solicitud del cliente:** "Descubrimos que algunos exempleados seguían accediendo al sistema. También nos preocupa la seguridad de los datos de tarjetas de crédito de los clientes. Queremos un sistema más seguro, con diferentes niveles de acceso según el rol del empleado, y poder usar nuestras cuentas corporativas de Google para acceder."
## Paso 9: Programación Multi-hilo y Concurrencia
**Solicitud del cliente:** "Los reportes de inventario para los proveedores tardan demasiado en generarse, bloqueando el sistema para otras operaciones. También tenemos problemas cuando varios vendedores intentan vender el mismo producto con stock limitado al mismo tiempo."
## Paso 10: Colas de Mensajería con RabbitMQ
**Solicitud del cliente:** "Necesitamos que nuestras sucursales estén sincronizadas. Si un producto se agota en una sucursal, queremos poder verificar inmediatamente si está disponible en otra y transferirlo. También necesitamos notificar automáticamente a los proveedores cuando el stock de ciertos productos baja de un umbral."
## Paso 11: WebSockets para Comunicación en Tiempo Real
**Solicitud del cliente:** "Los gerentes quieren ver en tiempo real cómo van las ventas del día. También queremos implementar un sistema de chat para que los clientes online puedan hacer consultas directamente a nuestros vendedores y recibir notificaciones cuando un producto que les interesa vuelve a estar en stock."
## Paso 12: Bases de Datos NoSQL: MongoDB
**Solicitud del cliente:** "Estamos ampliando a nuevas categorías de productos como línea blanca y audio profesional. Estos productos tienen características muy diferentes entre sí, y el sistema actual no nos permite registrar todas sus especificaciones. También queremos que los clientes puedan dejar reseñas y valoraciones."
## Paso 13: Redis para Caché y Estructuras Distribuidas
**Solicitud del cliente:** "Tenemos problemas cuando varios clientes intentan comprar las últimas unidades de un producto en oferta, a veces vendemos más de lo que tenemos. También necesitamos mostrar en tiempo real cuáles son los productos más vendidos o vistos en nuestra web."
## Paso 14: Telemetría y Monitoreo con Prometheus/Grafana
**Solicitud del cliente:** "No entendemos por qué algunos días vendemos tanto y otros tan poco. Queremos poder ver patrones en las ventas, horas pico, y detectar inmediatamente si hay problemas con el sistema en momentos críticos. Los técnicos también dicen que necesitan saber cómo se comporta el sistema para mejorarlo."
## Paso 15: Elasticsearch para Búsqueda Avanzada
**Solicitud del cliente:** "Los clientes se quejan de que no pueden encontrar fácilmente lo que buscan en nuestra web. Si escriben 'Samsung Galaxy', no aparecen resultados si el producto está listado como 'Galaxy S23 de Samsung'. Necesitamos un buscador inteligente que entienda lo que el cliente quiere encontrar y sugiera productos mientras escribe."
## Paso 16: gRPC para Comunicación entre Servicios
**Solicitud del cliente:** "El sistema se ha vuelto muy complejo y nos han recomendado dividirlo en partes más pequeñas para facilitar su mantenimiento. También queremos poder añadir nuevas funcionalidades sin tener que modificar todo el sistema, y que cada parte pueda escalar independientemente según la necesidad."
## Paso 17: Domain-Driven Design (DDD)
**Solicitud del cliente:** "Estamos pensando en expandirnos a la venta mayorista con un modelo de negocio diferente. Necesitamos que el sistema refleje mejor nuestras reglas de negocio específicas para cada tipo de venta, promociones, y políticas de precios diferentes para minoristas y mayoristas."
## Paso 18: Arquitectura Hexagonal
**Solicitud del cliente:** "Estamos considerando integrar el sistema con plataformas como MercadoLibre y Amazon para ampliar nuestras ventas. También queremos cambiar algunas partes del sistema sin tener que reescribirlo todo, como posiblemente migrar a otra base de datos o añadir una aplicación móvil."
## Paso 19: Kubernetes Básico
**Solicitud del cliente:** "Con la expansión a cinco sucursales y el aumento del tráfico web, necesitamos que el sistema pueda manejar automáticamente más carga durante fechas especiales como Navidad o Hot Sale, y reducir recursos cuando hay menos actividad para ahorrar costos."
## Paso 20: Spring Cloud para Microservicios
**Solicitud del cliente:** "Ya tenemos un ecosistema completo de aplicaciones: el sistema de inventario, el e-commerce, la aplicación para vendedores, y pronto lanzaremos una app para clientes. Necesitamos que todos estos sistemas trabajen juntos de forma confiable, con un inicio de sesión único y que si una parte falla, el resto siga funcionando."
---
Como pueden ver, cada solicitud del cliente está directamente relacionada con la tecnología o concepto que se implementará en ese paso, pero expresada en términos de necesidades de negocio reales, sin jerga técnica. Esto hace que el desarrollo sea dirigido por necesidades reales y no por la tecnología en sí misma.