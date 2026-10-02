package com.sofka.opencart.tasks;

import com.sofka.opencart.interactions.ClickCuandoEsteListo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofka.opencart.userinterfaces.CarritoPage.TABLA_PRODUCTOS;
import static com.sofka.opencart.userinterfaces.HomePage.LINK_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VisualizarCarrito implements Task {

    public static VisualizarCarrito deCompras() {
        return instrumented(VisualizarCarrito.class);
    }

    @Override
    @Step("{0} visualiza el carrito de compras")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickCuandoEsteListo.en(LINK_CARRITO),
                WaitUntil.the(TABLA_PRODUCTOS, isVisible()).forNoMoreThan(20).seconds()
        );
    }
}
