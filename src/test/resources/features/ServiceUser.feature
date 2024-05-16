Feature: Servicios REST

  @getAuthors
  Scenario: Obtener un registro Author por ID existente
    Given los servicios GET Author se encuentran funcionando correctamente
    When se hace una petición GET Author para obtener el usuario con ID 3
    Then se valida la respuesta correcta GET Author con codigo de estado 200

  @postMembers
  @regresion
  Scenario: Crear nuevo usuario
    Given se ingresa la data del usuario
      | name    | gender |
      | Alonso  | Male   |
    When se envia un request para crear un nuevo usuario
    And se genera el response 201
    Then se validan los datos del response

  @getMembers
  @regresion
  Scenario: Obtener un registro Member por ID existente
    Given los servicios GET Member se encuentran funcionando correctamente
    When se hace una petición GET Member para obtener el usuario con ID 5
    Then se valida la respuesta correcta GET Member con codigo de estado 200

  @putMembers
  @regresion
  Scenario: Actualizar un usuario via PUT
    Given se ingresa la data del usuario PUT
      | name        | gender |
      | Alonso PUT  | Male   |
    When se envia un request para actualizar un nuevo usuario PUT 5
    And se genera el response de PUT 200
    Then se validan los datos del response PUT

  @patchMembers
  Scenario: Actualizar un usuario via PATCH
    Given se ingresa la data del usuario PATCH
      | name          | gender |
      | Alonso PATCH  | Male   |
    When se envia un request para actualizar un nuevo usuario PATCH 1
    And se genera el response de PATCH 200
    Then se validan los datos del response PATCH

  @deleteMembers
  @regresion
  Scenario: Eliminar un usuario
    Given los servicios DELETE Member se encuentran funcionando correctamente
    When se hace una petición DELETE Member para eliminar el usuario con ID 5
    Then se valida la respuesta correcta DELETE Member con codigo de estado 200