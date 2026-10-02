@PetStoreUser
Feature: Ciclo de vida de un usuario en la API PetStore
  Como consumidor de la API PetStore
  Quiero crear, consultar, actualizar y eliminar usuarios
  Para validar la gestión completa del recurso /user

  Background:
    * url baseUrl
    * def timestamp = java.lang.System.currentTimeMillis()
    * def username = 'diegoqa_' + timestamp
    * def userId = ~~(timestamp % 100000000)
    * def email = username + '@test.com'
    * def userSchema = read('classpath:data/user-schema.json')
    * def apiResponseSchema = { code: '#number', type: '#string', message: '#string' }

  @E2E
  Scenario: Crear, buscar, actualizar, buscar y eliminar un usuario

    # ---------- 1. Crear usuario ----------
    * def createBody = read('classpath:data/user-create.json')
    * print 'Entrada - creación:', createBody
    Given path 'user'
    And request createBody
    When method post
    Then status 200
    And match response == apiResponseSchema
    And match response.code == 200
    And match response.message == '' + userId
    * print 'Salida - creación:', response

    # ---------- 2. Buscar usuario creado ----------
    Given path 'user', username
    And retry until responseStatus == 200
    When method get
    Then status 200
    And match response == userSchema
    And match response contains { id: '#(userId)', username: '#(username)', firstName: 'Diego', email: '#(email)' }
    * print 'Salida - consulta inicial:', response

    # ---------- 3. Actualizar nombre y correo ----------
    * copy updateBody = createBody
    * set updateBody.firstName = 'Alejandro'
    * set updateBody.email = 'actualizado_' + email
    * print 'Entrada - actualización:', updateBody
    Given path 'user', username
    And request updateBody
    When method put
    Then status 200
    And match response == apiResponseSchema
    And match response.message == '' + userId
    * print 'Salida - actualización:', response

    # ---------- 4. Buscar usuario actualizado ----------
    Given path 'user', username
    And retry until responseStatus == 200 && response.firstName == updateBody.firstName && response.email == updateBody.email
    When method get
    Then status 200
    And match response == userSchema
    And match response.firstName == 'Alejandro'
    And match response.email == updateBody.email
    And match response.username == username
    * print 'Salida - consulta actualizada:', response

    # ---------- 5. Eliminar usuario ----------
    Given path 'user', username
    And retry until responseStatus == 200
    When method delete
    Then status 200
    And match response == apiResponseSchema
    And match response.message == username
    * print 'Salida - eliminación:', response

    # ---------- Verificación: el usuario ya no existe ----------
    Given path 'user', username
    And retry until responseStatus == 404
    When method get
    Then status 404
    And match response.message == 'User not found'

  @Negativo
  Scenario: Consultar un usuario inexistente retorna 404
    Given path 'user', 'no_existe_' + timestamp
    When method get
    Then status 404
    And match response == { code: 1, type: 'error', message: 'User not found' }
