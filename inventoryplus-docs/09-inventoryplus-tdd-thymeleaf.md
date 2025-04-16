# Aplicando TDD al Proyecto InventoryPlus con Thymeleaf
Aplicar Test-Driven Development (TDD) a un proyecto Spring Boot con Thymeleaf es una excelente decisión.
Esta guia es sobre cómo implementarlo efectivamente, manteniendo Thymeleaf como frontend sin necesidad de migrar a frameworks como React o Angular.
## Enfoque TDD para el Proyecto
### Ciclo TDD Básico
1. **Red**: Escribe un test que falle para la funcionalidad que deseas implementar
2. **Green**: Implementa el código mínimo para que el test pase
3. **Refactor**: Optimiza el código manteniendo los tests en verde
### Niveles de Testing en el Proyecto
#### 1. Tests Unitarios
- **Servicios**: Lógica de negocio pura
- **Repositorios**: Operaciones de datos
- **Utilidades**: Helpers, validadores, etc.
#### 2. Tests de Integración
- **Repositorios con BD real**: Utilizando TestContainers
- **Servicios con dependencias reales**: Integración entre componentes
#### 3. Tests de Controladores
- **API REST**: Para endpoints que sirven datos
- **Controllers de Thymeleaf**: Para páginas renderizadas
#### 4. Tests End-to-End
- **Selenium/WebDriver**: Para flujos completos incluyendo UI
## Aplicando TDD por Componente
### 1. Repositories
```java
@Test
void shouldFindProductsByCategory() {
// Given
Category electronica = new Category("Electrónica");
categoryRepository.save(electronica);
Product product = new Product("Smartphone", "Descripción", new BigDecimal("499.99"), 10, electronica);
productRepository.save(product);
// When
List found = productRepository.findByCategory(electronica);
// Then
assertFalse(found.isEmpty());
assertEquals("Smartphone", found.get(0).getName());
}
```
### 2. Services
```java
@Test
void shouldCalculateCorrectTotalForSale() {
// Given
SaleItemDto item1 = new SaleItemDto(1L, 2); // ProductId=1, Quantity=2
SaleItemDto item2 = new SaleItemDto(2L, 1); // ProductId=2, Quantity=1
Product product1 = new Product();
product1.setId(1L);
product1.setPrice(new BigDecimal("100.00"));
Product product2 = new Product();
product2.setId(2L);
product2.setPrice(new BigDecimal("50.00"));
when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
when(productRepository.findById(2L)).thenReturn(Optional.of(product2));
SaleDto saleDto = new SaleDto();
saleDto.setItems(Arrays.asList(item1, item2));
// When
BigDecimal total = saleService.calculateTotal(saleDto);
// Then
assertEquals(new BigDecimal("250.00"), total);
}
```
### 3. REST Controllers
```java
@Test
void shouldReturnProductsForCategory() throws Exception {
// Given
List products = Arrays.asList(
new Product("Producto 1", "Desc 1", new BigDecimal("10.00"), 5, null),
new Product("Producto 2", "Desc 2", new BigDecimal("20.00"), 10, null)
);
when(productService.findByCategory(anyLong())).thenReturn(products);
// When & Then
mockMvc.perform(get("/api/products/category/1"))
.andExpect(status().isOk())
.andExpect(jsonPath("$", hasSize(2)))
.andExpect(jsonPath("$[0].name", is("Producto 1")))
.andExpect(jsonPath("$[1].name", is("Producto 2")));
}
```
### 4. Thymeleaf Controllers (MVC)
```java
@Test
void shouldRenderProductListPage() throws Exception {
// Given
List products = Arrays.asList(
new Product("Producto 1", "Desc 1", new BigDecimal("10.00"), 5, null),
new Product("Producto 2", "Desc 2", new BigDecimal("20.00"), 10, null)
);
when(productService.findAll()).thenReturn(products);
// When & Then
mockMvc.perform(get("/products"))
.andExpect(status().isOk())
.andExpect(view().name("products/list"))
.andExpect(model().attribute("products", hasSize(2)))
.andExpect(model().attribute("products", hasItem(
hasProperty("name", is("Producto 1"))
)));
}
```
### 5. Tests End-to-End (con Selenium)
```java
@Test
void shouldCreateNewProduct() {
// Given
webDriver.get("http://localhost:" + port + "/products/new");
// When
webDriver.findElement(By.id("name")).sendKeys("Nuevo Producto");
webDriver.findElement(By.id("description")).sendKeys("Descripción");
webDriver.findElement(By.id("price")).sendKeys("299.99");
webDriver.findElement(By.id("stock")).sendKeys("10");
new Select(webDriver.findElement(By.id("category"))).selectByVisibleText("Electrónica");
webDriver.findElement(By.id("submit-button")).click();
// Then
assertTrue(webDriver.getPageSource().contains("Producto creado correctamente"));
assertTrue(webDriver.getPageSource().contains("Nuevo Producto"));
}
```
## Estructura para TDD con Thymeleaf
### Paquetes
```
com.electronicadelsur.inventoryplus/
├── config/ # Configuración de la aplicación
├── controller/ # Controladores Web y REST
│ ├── api/ # Controladores REST
│ └── view/ # Controladores Thymeleaf
├── model/ # Entidades y modelos
├── repository/ # Acceso a datos
├── service/ # Lógica de negocio
│ ├── impl/ # Implementaciones
│ └── interfaces/ # Interfaces de servicio
├── dto/ # Objetos de transferencia
└── util/ # Utilidades
```
### Estructura de Tests
```
src/test/java/com/electronicadelsur/inventoryplus/
├── controller/
│ ├── api/ # Tests para REST controllers
│ └── view/ # Tests para Thymeleaf controllers
├── repository/ # Tests para repositorios
├── service/ # Tests para servicios
└── e2e/ # Tests end-to-end con Selenium
```
## Consejos Adicionales para TDD con Thymeleaf
1. **Separa claramente las responsabilidades**:
- Controladores: Solo mapeo de rutas y manejo de requests/responses
- Servicios: Toda la lógica de negocio
- Repositorios: Solo acceso a datos
2. **Usa DTOs para transferencia de datos**:
- Evita pasar entidades directamente a las vistas
- Define DTOs específicos para cada vista/operación
3. **Aprovecha fragmentos de Thymeleaf**:
- Crea componentes reutilizables para formularios, tablas, etc.
- Facilita el testing al tener componentes más modulares
4. **Implementa validación en capas**:
- Backend: Bean Validation en DTOs
- Frontend: Validación básica en formularios HTML
5. **Utiliza AJAX para operaciones parciales**:
- Puedes usar fetch/axios desde Thymeleaf para llamadas AJAX a tus endpoints
- Actualiza partes específicas de la página sin necesidad de frameworks SPA
6. **Crea helpers para testing Thymeleaf**:
- Utilidades para validar fragmentos específicos
- Extractores para contenido HTML
## Ejemplo de Implementación Progresiva con TDD
### Paso 1: Entidad y Repositorio
1. Escribe test para el repositorio
2. Implementa la entidad y repositorio
3. Verifica que el test pase
### Paso 2: Servicio
1. Escribe test para el servicio (mockea el repositorio)
2. Implementa el servicio
3. Verifica que el test pase
### Paso 3: REST Controller (para datos)
1. Escribe test para el controller REST
2. Implementa el controller
3. Verifica que el test pase
### Paso 4: View Controller (para Thymeleaf)
1. Escribe test para el controller de vista
2. Implementa el controller
3. Verifica que el test pase
### Paso 5: Template Thymeleaf
1. Implementa el template
2. Realiza test end-to-end básico
## Recomendaciones Específicas para Thymeleaf + Backend
1. **Implementa la arquitectura por capas estrictamente**:
- Esto facilita el testing y el mantenimiento futuro
2. **Usa @ControllerAdvice para manejo global de errores**:
- Centraliza el manejo de excepciones
- Proporciona vistas consistentes de error
3. **Implementa servicios de i18n desde el inicio**:
- Facilita la traducción futura
- Mejora la consistencia de mensajes
4. **Considera usar WebJars para recursos frontend**:
- Gestiona dependencias CSS/JS con Maven/Gradle
- Mantén todo en un solo sistema de build
5. **Implementa seguridad a nivel de servicio**:
- No solo en los controladores
- Facilita el testing aislado
6. **Crea DTOs específicos para cada vista**:
- Evita exponer datos innecesarios
- Mejora el rendimiento
7. **Usa CSRF para los formularios desde el inicio**:
- Spring Security lo facilita con Thymeleaf
- Establece buenas prácticas de seguridad
## Conclusión
Aplicar TDD con Thymeleaf es completamente viable y te ayudará a construir un sistema más robusto. Al enfocarte en backend con vistas server-side, evitas la complejidad adicional de mantener un SPA separado, lo cual es una decisión perfectamente válida para muchos proyectos empresariales.
Este enfoque te permitirá evolucionar gradualmente tu aplicación, implementando nuevas tecnologías conforme sean necesarias, sin comprometerla con una arquitectura innecesariamente compleja desde el principio.