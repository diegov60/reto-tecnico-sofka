package com.sofka.opencart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class CheckoutPage {

    // Paso 1: opciones de checkout
    public static final Target OPCION_INVITADO = Target.the("opción Guest Checkout")
            .locatedBy("//input[@name='account' and @value='guest']");
    public static final Target BOTON_CONTINUAR_CUENTA = Target.the("continuar opciones de cuenta")
            .locatedBy("#button-account");

    // Paso 2: datos de facturación del invitado
    public static final Target NOMBRE = Target.the("nombre").locatedBy("#input-payment-firstname");
    public static final Target APELLIDO = Target.the("apellido").locatedBy("#input-payment-lastname");
    public static final Target CORREO = Target.the("correo").locatedBy("#input-payment-email");
    public static final Target TELEFONO = Target.the("teléfono").locatedBy("#input-payment-telephone");
    public static final Target DIRECCION = Target.the("dirección").locatedBy("#input-payment-address-1");
    public static final Target CIUDAD = Target.the("ciudad").locatedBy("#input-payment-city");
    public static final Target CODIGO_POSTAL = Target.the("código postal").locatedBy("#input-payment-postcode");
    public static final Target PAIS = Target.the("país").locatedBy("#input-payment-country");
    public static final Target DEPARTAMENTO = Target.the("departamento").locatedBy("#input-payment-zone");
    public static final Target OPCION_DEPARTAMENTO = Target.the("opción de departamento {0}")
            .locatedBy("//select[@id='input-payment-zone']/option[normalize-space()='{0}']");
    public static final Target BOTON_CONTINUAR_INVITADO = Target.the("continuar datos de invitado")
            .locatedBy("#button-guest");

    // Paso 4: método de envío
    public static final Target BOTON_CONTINUAR_ENVIO = Target.the("continuar método de envío")
            .locatedBy("#button-shipping-method");

    // Paso 5: método de pago
    public static final Target ACEPTAR_TERMINOS = Target.the("aceptar términos y condiciones")
            .locatedBy("//input[@name='agree']");
    public static final Target BOTON_CONTINUAR_PAGO = Target.the("continuar método de pago")
            .locatedBy("#button-payment-method");

    // Paso 6: confirmación
    public static final Target BOTON_CONFIRMAR_ORDEN = Target.the("confirmar orden")
            .locatedBy("#button-confirm");

    private CheckoutPage() {
    }
}
