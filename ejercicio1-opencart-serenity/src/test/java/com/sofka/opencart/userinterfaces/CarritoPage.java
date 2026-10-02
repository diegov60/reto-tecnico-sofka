package com.sofka.opencart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class CarritoPage {

    public static final Target TABLA_PRODUCTOS = Target.the("tabla de productos del carrito")
            .locatedBy("//div[@id='content']//form//table");

    public static final Target NOMBRES_PRODUCTOS = Target.the("nombres de productos en el carrito")
            .locatedBy("//div[@id='content']//form//table/tbody/tr/td[@class='text-left']/a");

    public static final Target BOTON_CHECKOUT = Target.the("botón Checkout")
            .locatedBy("//div[@id='content']//a[contains(@href,'checkout/checkout') and contains(@class,'btn-primary')]");

    private CarritoPage() {
    }
}
