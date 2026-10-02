package com.sofka.opencart.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.sofka.opencart.userinterfaces.CarritoPage.NOMBRES_PRODUCTOS;

public class ProductosEnCarrito implements Question<List<String>> {

    public static ProductosEnCarrito visibles() {
        return new ProductosEnCarrito();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return NOMBRES_PRODUCTOS.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .map(String::trim)
                .toList();
    }
}
