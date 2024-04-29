# Documentación de API y Acceso a Base de Datos

## Descripción General


## Acceso a Swagger UI

Puedes visualizar y probar la API de la aplicación accediendo a la interfaz de usuario de Swagger. Esta interfaz permite una fácil interacción con todos los endpoints de la API desde el navegador.

```
http://localhost:8080/albin-crud/swagger-ui/index.html#/
```
La aplicación utiliza la base de datos llamada `crud`, y a continuación se muestra cómo puedes realizar consultas directamente para obtener datos.

### Ejemplo de Consulta SQL

Si necesitas obtener todos los registros de la tabla `product`, puedes usar la siguiente consulta SQL:

```sql
SELECT * FROM product;


