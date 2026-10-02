package com.sofka.opencart.tasks;

import com.sofka.opencart.userinterfaces.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirTienda implements Task {

    public static AbrirTienda enLaPaginaPrincipal() {
        return instrumented(AbrirTienda.class);
    }

    @Override
    @Step("{0} abre la tienda OpenCart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(HomePage.class));
    }
}
