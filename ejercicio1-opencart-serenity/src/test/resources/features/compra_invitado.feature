# language: es
@CompraE2E
Característica: Flujo de compra como invitado en OpenCart
  Como cliente de la tienda
  Quiero comprar productos sin registrarme
  Para finalizar mi pedido de forma rápida

  Escenario: Compra exitosa de dos productos con Guest Checkout
    Dado que "Diego" está en la tienda OpenCart
    Cuando agrega al carrito los productos
      | MacBook |
      | iPhone  |
    Y visualiza el carrito de compras
    Entonces debería ver en el carrito los productos
      | MacBook |
      | iPhone  |
    Cuando realiza el checkout como invitado con los datos
      | nombre | apellido | correo                | telefono   | direccion        | ciudad   | codigoPostal | pais     | departamento |
      | Diego  | Prueba   | diego.prueba@test.com | 3001234567 | Calle 10 # 20-30 | Sabaneta | 055450       | Colombia | Antioquia    |
    Entonces debería ver el mensaje de confirmación "Your order has been placed!"
