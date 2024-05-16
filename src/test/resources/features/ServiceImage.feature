Feature: Servicios REST

  @uploadImage
  Scenario: Subir una imagen
    Given se envia la ruta de la imagen "C:\Users\amolinae\Downloads\descarga.jpg"
    When se carga la imagen con el nombre "descarga" al servidor
    Then el servicio cargar responde con status 201

  @downloadImage
  Scenario: Descargar una imagen
    Given el servicio esta configurado correctamente
    When se descarga la imagen con el nombre "Yey.jpg"
    Then el servicio descargar responde con status 200