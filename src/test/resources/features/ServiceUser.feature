Feature: Servicios REST

  Scenario: Obtener un registro por ID existente
    Given los servicios se encuentran funcionando correctamente
    When se hace una petición GET para obtener el usuario con ID 1
    Then se valida la respuesta con codigo de estado 200

  @regresion
  Scenario: Crear nuevo usuario
    Given se ingresa la data del usuario
      | name    | gender |
      | Alonso  | Male   |
    When se envia un request para crear un nuevo usuario
    And se genera el response
    Then se validan los datos del response

  @regresion
  Scenario: Actualizar un usuario via PUT
    Given se ingresa la data del usuario PUT
      | name    | gender |
      | Alonso  | Male   |
    When se envia un request para crear un nuevo usuario PUT 1
    And se genera el response de PUT
    Then se validan los datos del response PUT

  @regresion
  Scenario: Actualizar un usuario via PATCH
    Given se ingresa la data del usuario PATCH
      | name    | gender |
      | Alonso  | Male   |
    When se envia un request para crear un nuevo usuario PATCH 1
    And se genera el response de PATCH
    Then se validan los datos del response PATCH