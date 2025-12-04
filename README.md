# 📄 Documentación de Features de la API

## 📝 Descripción General
Este proyecto contiene pruebas automatizadas para validar la funcionalidad de la API **serverest**.  
Las pruebas están desarrolladas utilizando los frameworks **Cucumber** y **Serenity BDD**, y cubren diversos endpoints relacionados con la gestión de usuarios.

---

## 📦 Dependencias Principales

- **Java**: Versión 11 o superior.
- **Maven**: Herramienta de construcción para gestionar dependencias y ejecutar las pruebas.
- **Cucumber**: Framework para escribir pruebas basadas en BDD.
- **Serenity BDD**: Framework para generar reportes detallados y estructurar pruebas automatizadas.


---

## 🚀 Features

### 1️⃣ `api_Registrar_usuario-POST-usuarios.feature`
**Descripción:** Valida el endpoint para registrar nuevos usuarios.  
**Escenarios:**
- ✅ Registro exitoso con parámetros válidos.
- ❌ Registro con parámetros inválidos o faltantes.
- ⚠️ Registro con error por email duplicado.

---

### 2️⃣ `api_Buscar_usuario_por_ID-GET-usuarios-id.feature`
**Descripción:** Valida el endpoint para buscar usuarios por ID.  
**Escenarios:**
- ✅ Búsqueda exitosa con ID válido.
- ❌ Búsqueda con parámetros inválidos.
- ⚠️ Búsqueda con ID inexistente.

---

### 3️⃣ `api_Listar_usuarios-GET-usuarios.feature`
**Descripción:** Valida el endpoint para listar usuarios.  
**Escenarios:**
- ✅ Listado con parámetros válidos.
- ❌ Listado con parámetros inválidos.
- ⚠️ Listado vacío con parámetros de búsqueda inexistentes.

---

### 4️⃣ `api_Actualizar_usuario-PUT-usuarios-id.feature`
**Descripción:** Valida el endpoint para actualizar datos de un usuario.  
**Escenarios:**
- ✅ Actualización exitosa con parámetros válidos.
- ✅ Creación de un nuevo usuario desde el servicio de actualización.
- ❌ Actualización con parámetros inválidos (campos obligatorios faltantes).
- ⚠️ Actualización con error por email duplicado.

---

### 5️⃣ `api_Eliminar_usuario-DELETE-usuarios-id.feature`
**Descripción:** Valida el endpoint para eliminar usuarios.  
**Escenarios:**
- ✅ Eliminación exitosa con parámetros válidos.
- ⚠️ Eliminación de un usuario inexistente.
- ❌ Eliminación de un usuario con carrito asociado.

---
---

## 🛠️ Cómo Ejecutar las Pruebas

1. Asegúrate de tener **Java** y **Maven** instalados.
2. Navega al directorio del proyecto.
3. Ejecuta las pruebas con los siguientes comandos:

    - **Ejecutar pruebas con una etiqueta específica**:
      ```bash
      mvn clean verify -Dcucumber.filter.tags="@etiqueta"
      ```
      *(Reemplaza `@etiqueta` con la etiqueta deseada, por ejemplo, `@registrar_usuarios`.)*

    - **Ejecutar todas las pruebas**:
      ```bash
      mvn clean verify
      ```

4. Los reportes se generarán en el directorio:


---

## 📌 Notas

- Se utiliza **generación de datos aleatorios** para casos dinámicos.
- La **validación de esquemas JSON** asegura la integridad de las respuestas.
