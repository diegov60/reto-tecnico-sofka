package com.sofka.opencart.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {

    public static final Target BOTON_AGREGAR_PRODUCTO = Target.the("botón agregar al carrito de {0}")
            .locatedBy("//div[contains(@class,'product-thumb')][.//h4/a[normalize-space()='{0}']]"
                    + "//button[contains(@onclick,'cart.add')]");

    public static final Target ALERTA_PRODUCTO_AGREGADO = Target.the("alerta de {0} agregado al carrito")
            .locatedBy("//div[contains(@class,'alert-success')][.//a[normalize-space()='{0}']]");

    public static final Target LINK_CARRITO = Target.the("enlace Shopping Cart")
            .locatedBy("//a[@title='Shopping Cart']");
}
