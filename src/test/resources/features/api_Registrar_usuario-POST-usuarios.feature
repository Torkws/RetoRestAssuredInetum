Feature: Validar servicio de serverest que registra nuevos usuarios

  @api @registrar_usuarios @GET_usuarios @E01
  Scenario Outline: Registrar nuevos usuarios satisfactoriamente con parámetros validos
    Given que el servicio API_POST_usuarios esta disponible en el ambiente
    When realizo una nuevo registro con los parámetros <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 201
    And se valida que el campo message de la respuesta sea Cadastro realizado com sucesso
    And se valida que el campo _id de la respuesta no sea nulo
    And se valida el esquema JSON de la respuesta contra el archivo Api_POST_registrarUsuariosSchema.json
    Examples:
      | nome   | email  | password | administrador |
      | random | random | random   | random        |

  @api @registrar_usuarios @GET_usuarios @E02
  Scenario Outline: Registrar nuevos usuarios con parámetros inválidos o faltantes
    Given que el servicio API_POST_usuarios esta disponible en el ambiente
    When realizo una nuevo registro con los parámetros <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 400
    And se valida que el campo <field> de la respuesta sea <messageError>
    Examples:
      | nome   | email  | password | administrador | field         | messageError                |
      |        | random | random   | random        | nome          | nome é obrigatório          |
      | random |        | random   | random        | email         | email é obrigatório         |
      | random | random |          | random        | password      | password é obrigatório      |
      | random | random | random   |               | administrador | administrador é obrigatório |

  @api @registrar_usuarios @GET_usuarios @E03
  Scenario Outline: Registrar nuevos usuarios con error con parámetro email duplicado
    Given que el servicio API_POST_usuarios esta disponible en el ambiente
    When realizo una nuevo registro con los parámetros <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 400
    And se valida que el campo message de la respuesta sea Este email já está sendo usado
    Examples:
      | nome   | email         | password | administrador |
      | random | fulano@qa.com | random   | random        |