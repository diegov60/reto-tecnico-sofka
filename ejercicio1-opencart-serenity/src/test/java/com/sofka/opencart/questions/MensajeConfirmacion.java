package com.sofka.opencart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.sofka.opencart.userinterfaces.ConfirmacionPage.TITULO;

public class MensajeConfirmacion implements Question<String> {

    public static MensajeConfirmacion deLaOrden() {
        return new MensajeConfirmacion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(TITULO).answeredBy(actor).trim();
    }
}
