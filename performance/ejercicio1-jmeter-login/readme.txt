EJERCICIO PERFORMANCE 1 - PRUEBA DE CARGA DEL SERVICIO DE LOGIN (JMETER)
========================================================================

Servicio bajo prueba: POST https://fakestoreapi.com/auth/login
Herramienta: Apache JMeter

VERSIONES DE LAS TECNOLOGÍAS
- Apache JMeter 5.6.3
- Java JDK 17 (JMeter 5.6.3 requiere Java 8 o superior)
- Sin plugins adicionales: solo componentes nativos de JMeter
- Sistema operativo: Windows 10/11 (también funciona en Linux/macOS)

INSTALACIÓN
1. Verificar Java:  java -version
2. Descargar JMeter 5.6.3 (Binaries, .zip) desde:
   https://jmeter.apache.org/download_jmeter.cgi
3. Descomprimir, por ejemplo en C:\apache-jmeter-5.6.3
4. Agregar C:\apache-jmeter-5.6.3\bin al PATH
5. Verificar:  jmeter -v

ESCENARIO DE LA PRUEBA (login-load-test.jmx)
- Thread Group: 40 usuarios, rampa de 30 s, duración total de 210 s (3,5 min).
- Constant Throughput Timer: 1.500 peticiones por minuto = 25 TPS,
  compartido entre todos los hilos. Se configura en 25 para garantizar
  al menos 20 TPS con margen.
- CSV Data Set Config: data/usuarios.csv, las variables se toman del
  encabezado (user, passwd), se recicla al terminar el archivo y se
  comparte entre todos los hilos.
- HTTP Request Defaults: https://fakestoreapi.com, timeout de 60 s
  (equivalente a --max-time 60 del cURL).
- HTTP Header Manager: Content-Type: application/json.
- HTTP Request: POST /auth/login con body
  { "username": "${user}", "password": "${passwd}" }

VALIDACIONES
- Response Assertion: status 200 o 201.
- JSON Assertion: la respuesta contiene el campo token.
- Duration Assertion: tiempo de respuesta máximo 1.500 ms.
  Cualquier petición que supere 1,5 s se marca como error.
- Tasa de error < 3 %: se verifica en la columna "Error %" del dashboard.
- TPS >= 20: se verifica en la columna "Throughput" del dashboard.
- Apdex configurado con umbral satisfecho de 1.500 ms.

PASO A PASO DE EJECUCIÓN
1. Clonar el repositorio:
   git clone <URL_DEL_REPOSITORIO>
2. Entrar a la carpeta:
   cd performance\ejercicio1-jmeter-login
3. Opción A - Doble clic en ejecutar.bat
   Opción B - Comando manual (modo no gráfico, recomendado para carga):
   jmeter -n -t login-load-test.jmx -l results\resultados.jtl -j results\jmeter.log -e -o reports\dashboard -Jjmeter.reportgenerator.apdex_satisfied_threshold=1500 -Jjmeter.reportgenerator.apdex_tolerated_threshold=3000
   Nota: la carpeta reports\dashboard debe estar vacía o no existir.
4. Abrir el reporte:
   reports\dashboard\index.html

PARÁMETROS OPCIONALES (sin editar el script)
- Cambiar TPS:       -Jtpm=1800        (1800/min = 30 TPS)
- Cambiar usuarios:  -Jusuarios=50
- Cambiar duración:  -Jduracion=300    (segundos)
- Cambiar rampa:     -Jrampa=60

ABRIR EN MODO GRÁFICO (solo para revisar o depurar)
   jmeter -t login-load-test.jmx
   No se recomienda ejecutar la carga en modo gráfico.

ESTRUCTURA
login-load-test.jmx  -> plan de prueba
data/usuarios.csv    -> datos parametrizados (user,passwd)
ejecutar.bat         -> ejecución rápida en Windows
results/             -> resultados crudos (.jtl) y log
reports/dashboard/   -> reporte HTML de JMeter (evidencia)
readme.txt           -> este archivo
conclusiones.txt     -> hallazgos y conclusiones
