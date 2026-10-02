package com.sofka.opencart.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickCuandoEsteListo implements Interaction {

    private static final int TIEMPO_MAXIMO_SEGUNDOS = 20;
    private final Target objetivo;

    public ClickCuandoEsteListo(Target objetivo) {
        this.objetivo = objetivo;
    }

    public static ClickCuandoEsteListo en(Target objetivo) {
        return instrumented(ClickCuandoEsteListo.class, objetivo);
    }

    @Override
    @Step("{0} hace clic en #objetivo cuando está disponible")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(objetivo, isClickable()).forNoMoreThan(TIEMPO_MAXIMO_SEGUNDOS).seconds(),
                Click.on(objetivo)
        );
    }
}
