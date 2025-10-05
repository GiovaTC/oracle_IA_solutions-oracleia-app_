# Oracle IA Solutions - oracleia-app

Aplicación Java (Maven) con interfaz Swing que conecta a Oracle 19c y permite manipular 6 tablas:
EMPRESA, EMPLEADO, PROYECTO, CLIENTE, FACTURA y TECNOLOGIA.

**Conexión configurada (por defecto)**:
- URL: `jdbc:oracle:thin:@localhost:1521:orcl`
- Usuario: `system`
- Password: `Tapiero123`

## Contenido del proyecto
- `src/main/java/com/oracleia/...` - código Java (modelos, DAOs, UI)
- `schema_oracleia.sql` - script para crear y poblar las tablas (20 registros cada una)
- `pom.xml` - Maven POM

## Ejecutar
1. Asegúrate de tener Oracle 19c corriendo en `localhost:1521:orcl`.
2. Ejecuta el script `schema_oracleia.sql` con SQL*Plus o SQL Developer para crear y poblar tablas.
3. Importa el proyecto en IntelliJ como proyecto Maven.
4. Si no tienes el driver Oracle en Maven Central, añade `ojdbc11.jar` a tu repositorio local o en la configuración de IntelliJ (Project > Libraries).
5. Ejecuta la clase `com.oracleia.App` (main). Se abrirá una interfaz Swing con pestañas por cada tabla.

---

## Nota sobre el driver Oracle
El driver JDBC de Oracle (ojdbc) puede necesitar instalación manual en tu repositorio Maven local, 
o agregar el jar en las dependencias del proyecto en IntelliJ. El `pom.xml` marca el driver como `provided`.

---

## Licencia
Proyecto educativo / demostrativo (Oracle IA Solutions) - 2025
