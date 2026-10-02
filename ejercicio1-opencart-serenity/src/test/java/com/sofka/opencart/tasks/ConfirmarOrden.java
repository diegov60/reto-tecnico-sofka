package com.sofka.opencart.tasks;

import com.sofka.opencart.interactions.ClickCuandoEsteListo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofka.opencart.userinterfaces.CheckoutPage.BOTON_CONFIRMAR_ORDEN;
import static com.sofka.opencart.userinterfaces.ConfirmacionPage.TITULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmarOrden implements Task {

    public static ConfirmarOrden deCompra() {
        return instrumented(ConfirmarOrden.class);
    }

    @Override
    @Step("{0} confirma la orden")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickCuandoEsteListo.en(BOTON_CONFIRMAR_ORDEN),
                WaitUntil.the(TITULO, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}
