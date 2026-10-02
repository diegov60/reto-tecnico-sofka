package com.sofka.opencart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class ConfirmacionPage {

    // Solo existe en la página de éxito (route=checkout/success)
    public static final Target TITULO = Target.the("título de confirmación de la orden")
            .locatedBy("//div[@id='common-success']//h1");

    private ConfirmacionPage() {
    }
}