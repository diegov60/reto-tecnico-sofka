EJERCICIO 1 - PRUEBA E2E FLUJO DE COMPRA OPENCART
==================================================

Sitio bajo prueba: http://opencart.abstracta.us/
Framework: Serenity BDD 4 + Screenplay + Cucumber (Gherkin en español) + Java 17

FLUJO AUTOMATIZADO
1. Agregar dos productos al carrito (MacBook e iPhone) desde la página principal.
2. Visualizar el carrito y validar que contiene ambos productos.
3. Checkout como invitado (Guest Checkout) diligenciando los datos de facturación.
4. Seleccionar envío, aceptar términos, elegir pago y confirmar la orden.
5. Validar el mensaje "Your order has been placed!".

REQUISITOS
- Java JDK 17 o superior (java -version)
- Maven 3.9 o superior (mvn -version)
- Google Chrome actualizado (el driver se descarga automáticamente con Selenium Manager)
- Conexión a internet

PASO A PASO DE EJECUCIÓN
1. Clonar el repositorio:
   git clone <URL_DEL_REPOSITORIO>
2. Entrar a la carpeta del ejercicio:
   cd ejercicio1-opencart-serenity
3. Ejecutar las pruebas y generar el reporte:
   mvn clean verify
4. Ejecutar sin interfaz gráfica (opcional):
   mvn clean verify -Dheadless.mode=true
5. Abrir el reporte de Serenity:
   target/site/serenity/index.html
   (Reporte resumido: target/site/serenity/serenity-summary.html)

ESTRUCTURA DEL PROYECTO (PATRÓN SCREENPLAY)
src/test/java/com/sofka/opencart
  runners/          -> CompraE2ETestSuite: runner JUnit 5 + Cucumber
  stepdefinitions/  -> Pasos Gherkin, solo orquestan al actor
  tasks/            -> Acciones de negocio (AgregarProducto, VisualizarCarrito,
                       RealizarCheckoutInvitado, ConfirmarOrden, AbrirTienda)
  interactions/     -> ClickCuandoEsteListo (espera explícita + clic)
  questions/        -> ProductosEnCarrito, MensajeConfirmacion
  userinterfaces/   -> Targets/localizadores por página
  models/           -> DatosInvitado (datos del formulario)
src/test/resources
  features/         -> compra_invitado.feature
  serenity.conf     -> Configuración del navegador y URL base

DATOS DE PRUEBA
Los productos y datos del invitado están parametrizados en la tabla del feature.
Para cambiarlos no se toca código Java.

EVIDENCIAS
La carpeta "evidencias/" contiene el reporte de Serenity de una ejecución exitosa.
