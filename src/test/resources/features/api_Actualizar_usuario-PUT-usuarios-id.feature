Feature: Validar servicio de serverest que Actualiza usuarios

  @api @actualizar_usuarios @PUT_usuarios @E01
  Scenario Outline: Actualizar usuarios satisfactoriamente con parámetros válidos
    Given que el servicio API_PUT_usuarios esta disponible en el ambiente
    When realizo una actualización con el parámetro <_id> y el cuerpo: <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 200
    And se valida que el campo message de la respuesta sea Registro alterado com sucesso
    And se valida el esquema JSON de la respuesta contra el archivo Api_PUT_actualizarUsuariosSchema.json
    Examples:
      | _id              | nome            | email  | password | administrador |
      | 0uxuPY0cbmQhpEz1 | Fulano da Silva | random | teste    | true          |

  @api @actualizar_usuarios @PUT_usuarios @E02
  Scenario Outline: Creo usuarios nuevos desde el Servicio de Actualizar satisfactoriamente con parámetros válidos
    Given que el servicio API_PUT_usuarios esta disponible en el ambiente
    When realizo una actualización con el parámetro <_id> y el cuerpo: <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 201
    And se valida que el campo message de la respuesta sea Cadastro realizado com sucesso
    And se valida que el campo _id de la respuesta no sea nulo
    Examples:
      | _id    | nome   | email  | password | administrador |
      | random | random | random | random   | random        |


  @api @actualizar_usuarios @PUT_usuarios @E03
  Scenario Outline: Actualizar usuarios con parámetros inválidos
    Given que el servicio API_PUT_usuarios esta disponible en el ambiente
    When realizo una actualización con el parámetro <_id> y el cuerpo: <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 400
    And se valida que el campo <field> de la respuesta sea <messageError>
    Examples:
      | _id              | nome   | email              | password | administrador | field         | messageError                |
      | 0uxuPY0cbmQhpEz1 |        | beltrano@qa.com.br | teste    | true          | nome          | nome é obrigatório          |
      | 0uxuPY0cbmQhpEz1 | Fulano |                    | teste    | true          | email         | email é obrigatório         |
      | 0uxuPY0cbmQhpEz1 | Fulano | beltrano@qa.com.br |          | true          | password      | password é obrigatório      |
      | 0uxuPY0cbmQhpEz1 | Fulano | beltrano@qa.com.br | teste    |               | administrador | administrador é obrigatório |


  @api @actualizar_usuarios @PUT_usuarios @E04
  Scenario Outline: Actualizar usuarios con error con parámetro email duplicado
    Given que el servicio API_PUT_usuarios esta disponible en el ambiente
    When realizo una actualización con el parámetro <_id> y el cuerpo: <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 400
    And se valida que el campo message de la respuesta sea Este email já está sendo usado
    Examples:
      | _id              | nome            | email              | password | administrador |
      | 0uxuPY0cbmQhpEz1 | Fulano da Silva | beltrano@qa.com.br | teste    | true          |

