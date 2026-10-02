EJERCICIO 2 - PRUEBAS API REST PETSTORE CON KARATE
===================================================

API bajo prueba: https://petstore.swagger.io/v2 (recurso /user)
Herramienta: Karate 1.5.2 + JUnit 5 + Maven + Java 17

CASOS AUTOMATIZADOS (feature user-lifecycle.feature)
1. Crear un usuario              -> POST   /user
2. Buscar el usuario creado      -> GET    /user/{username}
3. Actualizar nombre y correo    -> PUT    /user/{username}
4. Buscar el usuario actualizado -> GET    /user/{username}
5. Eliminar el usuario           -> DELETE /user/{username}
Extra: verificación de que el usuario eliminado ya no existe (404) y
escenario negativo de consulta de usuario inexistente.

REQUISITOS
- Java JDK 17 o superior (java -version)
- Maven 3.9 o superior (mvn -version)
- Variable de entorno JAVA_HOME apuntando al JDK 17
- Conexión a internet

CONFIGURAR JAVA_HOME (solo si Maven indica que no está definido)
Windows PowerShell (aplica para la sesión actual):
   $env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
   $env:Path = "$env:JAVA_HOME\bin;$env:Path"
Linux / macOS:
   export JAVA_HOME=/ruta/al/jdk-17
   export PATH=$JAVA_HOME/bin:$PATH

PASO A PASO DE EJECUCIÓN
1. Clonar el repositorio:
   git clone <URL_DEL_REPOSITORIO>
2. Entrar a la carpeta del ejercicio:
   cd ejercicio2-petstore-karate
3. Ejecutar todas las pruebas:
   mvn clean test
4. Ejecutar solo un tag (opcional):
   mvn clean test -Dkarate.options="--tags @E2E"
5. Revisar el reporte HTML:
   target/karate-reports/karate-summary.html
6. Log detallado de requests/responses:
   target/karate.log

También se puede ejecutar desde el IDE (IntelliJ): abrir la carpeta
ejercicio2-petstore-karate como proyecto Maven y ejecutar la clase
PetStoreRunnerTest.

ENTRADAS, SALIDAS Y VARIABLES
- Entradas: data/user-create.json (plantilla con expresiones embebidas #(variable)).
- Variables dinámicas: username, userId y email se generan con timestamp para
  que cada ejecución sea independiente y no choque con datos de otros usuarios.
- Salidas: cada respuesta se imprime con "print" y queda registrada en el reporte.
- Validaciones: código HTTP, esquema de respuesta (data/user-schema.json),
  valores de los campos y mensajes del API.
- Reintentos: configurados en karate-config.js (10 intentos cada 1,5 s) para
  manejar la consistencia eventual del API demo.

ESTRUCTURA
src/test/java/petstore/PetStoreRunnerTest.java  -> Runner JUnit 5
src/test/resources/karate-config.js             -> URL base, timeouts, retry
src/test/resources/logback-test.xml             -> Configuración de logs
src/test/resources/features/user/               -> Escenarios Karate
src/test/resources/data/                        -> Payloads y esquemas JSON

EVIDENCIAS
La carpeta "evidencias/" contiene el reporte de Karate de una ejecución exitosa.