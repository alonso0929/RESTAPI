Feature: Servicios REST

  Scenario: Subir una imagen
    Given se envia la ruta de la imagen "Descargas/imagen.png"
    When se carga la imagen con el nombre "imagen" al servidor
    Then el servicio cargar responde con status 201

  Scenario: Descargar una imagen
    Given el servicio esta configurado correctamente
    When se descarga la imagen con el nombre "imagen"
    Then el servicio descargar responde con status 200