# Perfiles de Entorno y Roles de Usuario para InventoryPlus
A continuación, detallaremos los perfiles de entorno (configuraciones) y roles de usuario para cada etapa del proyecto, mostrando cómo evolucionan con la creciente complejidad del sistema.
## Perfiles de Entorno por Etapa
### Paso 0-3: Configuración Básica
**Perfiles disponibles:**
1. **default** - Configuración base compartida por todos los perfiles
2. **dev** - Entorno de desarrollo local
3. **test** - Entorno para pruebas automatizadas
4. **prod** - Entorno de producción
**Diferencias principales:**
- **dev**:
- Base de datos H2 en memoria
- Logs detallados
- Datos de prueba precargados
- Seguridad simplificada
- **test**:
- Base de datos TestContainers
- Configuración optimizada para pruebas
- Sin envío de emails reales
- **prod**:
- Conexiones a bases de datos reales
- Logs de nivel INFO/WARN
- Seguridad completa
- Sin datos de prueba
### Paso 4-7: Configuración Intermedia
**Perfiles adicionales:**
1. **qa** - Entorno de control de calidad
2. **staging** - Preproducción, idéntico a producción
3. **demo** - Entorno para demostraciones a clientes
**Diferencias adicionales:**
- **qa**:
- Base de datos real pero separada
- Datos de prueba controlados
- Integración con servicios de QA
- **staging**:
- Configuración idéntica a producción
- Datos anonimizados de producción
- Para pruebas finales antes de despliegue
- **demo**:
- Datos de demostración prefabricados
- Funcionalidades limitadas
- Optimizado para presentaciones
### Paso 8-12: Configuración Avanzada
**Perfiles adicionales:**
1. **local-docker** - Desarrollo con Docker local
2. **integration** - Pruebas de integración
3. **performance** - Pruebas de rendimiento
4. **security** - Pruebas de seguridad
**Diferencias adicionales:**
- **local-docker**:
- Configurado para contenedores locales
- Servicios externos mockeados
- Hot-reload habilitado
- **integration**:
- Servicios externos reales pero en sandbox
- Monitoreo detallado de integraciones
- Retry configurado para pruebas
- **performance**:
- Métricas detalladas
- Caching optimizado
- Configuración para pruebas de carga
- **security**:
- Logging de seguridad exhaustivo
- CSP y headers restrictivos
- Monitoreo de vulnerabilidades
### Paso 13-20: Configuración para Microservicios
**Enfoque de perfiles:**
- Perfiles base por servicio + perfiles de entorno
- Configuración centralizada con Spring Cloud Config
**Perfiles adicionales globales:**
1. **dev-all** - Todos los servicios en modo desarrollo
2. **canary** - Despliegue parcial para testing A/B
3. **disaster-recovery** - Configuración de recuperación
4. **multi-region** - Configuración multi-región
**Perfiles por servicio:**
- **{service-name}-default**
- **{service-name}-dev**
- **{service-name}-prod**
- etc.
## Roles de Usuario por Etapa
### Paso 0-3: Roles Básicos
1. **ADMIN**
- Acceso completo al sistema
- Gestión de usuarios
- Configuración del sistema
2. **MANAGER**
- Gestión de inventario
- Reportes completos
- Gestión de precios
3. **SALES_STAFF**
- Registro de ventas
- Consulta de productos
- Manejo básico de clientes
4. **WAREHOUSE_STAFF**
- Actualización de stock
- Recepción de mercadería
- Reportes básicos de inventario
### Paso 4-7: Roles Intermedios
*Roles previos más:*
5. **FINANCE**
- Gestión de ingresos y gastos
- Reportes financieros
- Control de márgenes y rentabilidad
6. **CUSTOMER_SERVICE**
- Atención de reclamos
- Gestión de devoluciones
- Historial de clientes
7. **MARKETING**
- Gestión de promociones
- Campañas de marketing
- Análisis de ventas por campaña
8. **READ_ONLY**
- Acceso de solo lectura a información
- Para auditores o consultores externos
### Paso 8-12: Roles Avanzados y Permisos Granulares
*Sistema basado en roles + permisos específicos:*
**Roles adicionales:**
9. **BRANCH_MANAGER**
- Gestión limitada a una sucursal
- Reportes de la sucursal
- Personal de la sucursal
10. **SUPPLIER_PORTAL**
- Acceso limitado para proveedores
- Ver órdenes de compra
- Actualizar información de productos
11. **ANALYTICS**
- Acceso a dashboards y análisis avanzados
- Sin permisos de modificación
- Exportación de datos
**Permisos granulares (ejemplos):**
- PRODUCT_CREATE, PRODUCT_READ, PRODUCT_UPDATE, PRODUCT_DELETE
- SALES_CREATE, SALES_READ, SALES_CANCEL
- CUSTOMER_CREATE, CUSTOMER_READ, CUSTOMER_UPDATE
- REPORT_BASIC, REPORT_FINANCIAL, REPORT_ANALYTICS
- USER_MANAGE, SYSTEM_CONFIGURE
### Paso 13-20: Roles en Microservicios
*Enfoque de seguridad distribuida:*
**Roles por dominio:**
- **CATALOG_ADMIN**, **CATALOG_EDITOR**, **CATALOG_VIEWER**
- **SALES_ADMIN**, **SALES_OPERATOR**, **SALES_VIEWER**
- **CUSTOMER_ADMIN**, **CUSTOMER_SERVICE**, **CUSTOMER_VIEWER**
- **REPORTING_ADMIN**, **REPORTING_VIEWER**
- etc.
**Sistema de scopes para OAuth2:**
- `read:products`, `write:products`
- `read:sales`, `write:sales`
- `read:customers`, `write:customers`
- etc.
## Implementación de Perfiles y Roles
### Perfiles de Entorno
#### Paso 0-3: Implementación Simple
```properties
# application.properties (default)
spring.profiles.active=dev
# application-dev.properties
spring.datasource.url=jdbc:h2:mem:devdb
spring.jpa.hibernate.ddl-auto=create-drop
logging.level.root=DEBUG
# application-prod.properties
spring.datasource.url=jdbc:mysql://productiondb:3306/inventory
spring.jpa.hibernate.ddl-auto=validate
logging.level.root=INFO
```
#### Paso 4-12: Implementación con YAML y Propiedades Encriptadas
```yaml
# application.yml
spring:
profiles:
active: dev
# application-dev.yml
spring:
datasource:
url: jdbc:mysql://localhost:3306/inventory_dev
username: devuser
security:
require-ssl: false
cache:
type: simple
# application-prod.yml
spring:
datasource:
url: jdbc:mysql://productiondb:3306/inventory
username: ${DB_USER} # Variable de entorno
password: ${DB_PASSWORD}
security:
require-ssl: true
cache:
type: redis
```
#### Paso 13-20: Configuración Centralizada con Spring Cloud Config
```yaml
# bootstrap.yml
spring:
application:
name: product-service
cloud:
config:
uri: http://config-server:8888
fail-fast: true
```
### Roles de Usuario
#### Paso 0-3: Implementación Básica (WebSecurityConfigurerAdapter)
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(HttpSecurity http) throws Exception {
http
.authorizeRequests()
.antMatchers("/admin/**").hasRole("ADMIN")
.antMatchers("/reports/**").hasAnyRole("ADMIN", "MANAGER")
.antMatchers("/sales/**").hasAnyRole("ADMIN", "MANAGER", "SALES_STAFF")
.antMatchers("/warehouse/**").hasAnyRole("ADMIN", "MANAGER", "WAREHOUSE_STAFF")
.anyRequest().authenticated()
.and()
.formLogin();
}
}
```
#### Paso 4-7: Seguridad a Nivel de Método
```java
@Service
public class ProductService {
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
public void updateProductPrice(Long productId, BigDecimal newPrice) {
// Lógica para actualizar precio
}
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'SALES_STAFF', 'WAREHOUSE_STAFF')")
public Product getProductById(Long productId) {
// Lógica para obtener producto
}
}
```
#### Paso 8-12: Permisos Granulares
```java
@Service
public class ProductService {
@PreAuthorize("hasPermission('PRODUCT', 'UPDATE')")
public void updateProductPrice(Long productId, BigDecimal newPrice) {
// Lógica para actualizar precio
}
@PreAuthorize("hasPermission('PRODUCT', 'READ')")
public Product getProductById(Long productId) {
// Lógica para obtener producto
}
}
```
#### Paso 13-20: Seguridad Distribuida con OAuth2
```java
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
@Override
public void configure(HttpSecurity http) throws Exception {
http
.authorizeRequests()
.antMatchers(HttpMethod.GET, "/products/**").access("#oauth2.hasScope('read:products')")
.antMatchers(HttpMethod.POST, "/products/**").access("#oauth2.hasScope('write:products')")
.anyRequest().authenticated();
}
}
```
## Matriz de Perfiles y Entornos
| Fase | Desarrollo | Testing | Preproducción | Producción | Especiales |
|------|------------|---------|---------------|------------|------------|
| 0-3 | dev | test | - | prod | - |
| 4-7 | dev | test, qa | staging | prod | demo |
| 8-12 | dev, local-docker | test, qa, integration, performance, security | staging | prod | demo, canary |
| 13-20 | dev, dev-all, {service}-dev | test, integration, performance, security | staging, canary | prod, multi-region | disaster-recovery |
## Matriz de Evolución de Roles
| Nivel | Paso 0-3 | Paso 4-7 | Paso 8-12 | Paso 13-20 |
|-------|----------|----------|-----------|------------|
| Administración | ADMIN | ADMIN | ADMIN + permisos | Roles por dominio + permisos |
| Gerencia | MANAGER | MANAGER, FINANCE | BRANCH_MANAGER, etc. | Roles específicos por servicio |
| Operación | SALES_STAFF, WAREHOUSE_STAFF | + CUSTOMER_SERVICE, MARKETING | + permisos granulares | Roles operativos por dominio |
| Consulta | (implícito en otros roles) | READ_ONLY | ANALYTICS, READ_ONLY | Viewers por dominio |
| Externos | - | - | SUPPLIER_PORTAL | Roles específicos con OAuth scopes |
Este enfoque progresivo de perfiles y roles permite:
1. Comenzar con una estructura simple y comprensible
2. Agregar granularidad según crezcan las necesidades
3. Adaptar la seguridad a la arquitectura evolutiva
4. Mantener separaciones claras entre entornos
5. Facilitar pruebas adecuadas antes del despliegue a producción
---
La combinación de perfiles de entorno bien definidos y un sistema de roles cada vez más sofisticado proporciona la base para un sistema seguro, testeable y escalable que puede crecer con las necesidades del negocio.