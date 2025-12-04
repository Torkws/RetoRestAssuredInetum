Feature: Validar servicio de serverest que registra nuevos usuarios

  @api @listar_usuarios @GET_usuarios @E01
  Scenario Outline: Registrar nuevos usuarios satisfactoriamente con parámetros validos
    Given que el servicio API_POST_usuarios esta disponible en el ambiente
    When realizo una nuevo registro con los parámetros <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 201
#    And se valida el esquema JSON de la respuesta contra el archivo Api_GET_listarUsuariosSchema.json
    Examples:
      | nome   | email | password | administrador |
      | Fulano |       |          |               |