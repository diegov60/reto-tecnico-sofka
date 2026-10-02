package com.sofka.opencart.tasks;

import com.sofka.opencart.interactions.ClickCuandoEsteListo;
import com.sofka.opencart.models.DatosInvitado;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofka.opencart.userinterfaces.CarritoPage.BOTON_CHECKOUT;
import static com.sofka.opencart.userinterfaces.CheckoutPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarCheckoutInvitado implements Task {

    private final DatosInvitado datos;

    public RealizarCheckoutInvitado(DatosInvitado datos) {
        this.datos = datos;
    }

    public static RealizarCheckoutInvitado con(DatosInvitado datos) {
        return instrumented(RealizarCheckoutInvitado.class, datos);
    }

    @Override
    @Step("{0} realiza el checkout como invitado")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Paso 1: elegir Guest Checkout
                ClickCuandoEsteListo.en(BOTON_CHECKOUT),
                ClickCuandoEsteListo.en(OPCION_INVITADO),
                ClickCuandoEsteListo.en(BOTON_CONTINUAR_CUENTA),

                // Paso 2: datos de facturación
                WaitUntil.the(NOMBRE, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(datos.nombre()).into(NOMBRE),
                Enter.theValue(datos.apellido()).into(APELLIDO),
                Enter.theValue(datos.correo()).into(CORREO),
                Enter.theValue(datos.telefono()).into(TELEFONO),
                Enter.theValue(datos.direccion()).into(DIRECCION),
                Enter.theValue(datos.ciudad()).into(CIUDAD),
                Enter.theValue(datos.codigoPostal()).into(CODIGO_POSTAL),
                SelectFromOptions.byVisibleText(datos.pais()).from(PAIS),
                // El departamento se carga por AJAX al cambiar el país
                WaitUntil.the(OPCION_DEPARTAMENTO.of(datos.departamento()), isPresent()).forNoMoreThan(20).seconds(),
                SelectFromOptions.byVisibleText(datos.departamento()).from(DEPARTAMENTO),
                ClickCuandoEsteListo.en(BOTON_CONTINUAR_INVITADO),

                // Paso 4: método de envío (dirección de envío = facturación por defecto)
                ClickCuandoEsteListo.en(BOTON_CONTINUAR_ENVIO),

                // Paso 5: método de pago y términos
                ClickCuandoEsteListo.en(ACEPTAR_TERMINOS),
                ClickCuandoEsteListo.en(BOTON_CONTINUAR_PAGO)
        );
    }
}
