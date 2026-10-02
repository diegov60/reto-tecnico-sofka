package com.sofka.opencart.tasks;

import com.sofka.opencart.interactions.ClickCuandoEsteListo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofka.opencart.userinterfaces.HomePage.ALERTA_PRODUCTO_AGREGADO;
import static com.sofka.opencart.userinterfaces.HomePage.BOTON_AGREGAR_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProducto implements Task {

    private final String producto;

    public AgregarProducto(String producto) {
        this.producto = producto;
    }

    public static AgregarProducto alCarrito(String producto) {
        return instrumented(AgregarProducto.class, producto);
    }

    @Override
    @Step("{0} agrega el producto #producto al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickCuandoEsteListo.en(BOTON_AGREGAR_PRODUCTO.of(producto)),
                WaitUntil.the(ALERTA_PRODUCTO_AGREGADO.of(producto), isVisible()).forNoMoreThan(20).seconds()
        );
    }
}
