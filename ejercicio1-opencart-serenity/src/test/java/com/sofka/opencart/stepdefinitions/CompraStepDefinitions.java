package com.sofka.opencart.stepdefinitions;

import com.sofka.opencart.models.DatosInvitado;
import com.sofka.opencart.questions.MensajeConfirmacion;
import com.sofka.opencart.questions.ProductosEnCarrito;
import com.sofka.opencart.tasks.AbrirTienda;
import com.sofka.opencart.tasks.AgregarProducto;
import com.sofka.opencart.tasks.ConfirmarOrden;
import com.sofka.opencart.tasks.RealizarCheckoutInvitado;
import com.sofka.opencart.tasks.VisualizarCarrito;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class CompraStepDefinitions {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @DataTableType
    public DatosInvitado datosInvitado(Map<String, String> fila) {
        return new DatosInvitado(
                fila.get("nombre"),
                fila.get("apellido"),
                fila.get("correo"),
                fila.get("telefono"),
                fila.get("direccion"),
                fila.get("ciudad"),
                fila.get("codigoPostal"),
                fila.get("pais"),
                fila.get("departamento"));
    }

    @Dado("que {string} está en la tienda OpenCart")
    public void queEstaEnLaTienda(String nombreActor) {
        theActorCalled(nombreActor).wasAbleTo(AbrirTienda.enLaPaginaPrincipal());
    }

    @Cuando("agrega al carrito los productos")
    public void agregaAlCarritoLosProductos(List<String> productos) {
        productos.forEach(producto ->
                theActorInTheSpotlight().attemptsTo(AgregarProducto.alCarrito(producto)));
    }

    @Cuando("visualiza el carrito de compras")
    public void visualizaElCarrito() {
        theActorInTheSpotlight().attemptsTo(VisualizarCarrito.deCompras());
    }

    @Entonces("debería ver en el carrito los productos")
    public void deberiaVerEnElCarrito(List<String> productos) {
        theActorInTheSpotlight().should(
                seeThat("los productos del carrito", ProductosEnCarrito.visibles(),
                        containsInAnyOrder(productos.toArray(new String[0]))));
    }

    @Cuando("realiza el checkout como invitado con los datos")
    public void realizaElCheckoutComoInvitado(List<DatosInvitado> datos) {
        theActorInTheSpotlight().attemptsTo(
                RealizarCheckoutInvitado.con(datos.get(0)),
                ConfirmarOrden.deCompra());
    }

    @Entonces("debería ver el mensaje de confirmación {string}")
    public void deberiaVerElMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de confirmación", MensajeConfirmacion.deLaOrden(), equalTo(mensajeEsperado)));
    }
}
