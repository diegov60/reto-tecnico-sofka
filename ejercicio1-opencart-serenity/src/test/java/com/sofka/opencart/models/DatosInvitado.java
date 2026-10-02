package com.sofka.opencart.models;

public record DatosInvitado(
        String nombre,
        String apellido,
        String correo,
        String telefono,
        String direccion,
        String ciudad,
        String codigoPostal,
        String pais,
        String departamento) {
}
