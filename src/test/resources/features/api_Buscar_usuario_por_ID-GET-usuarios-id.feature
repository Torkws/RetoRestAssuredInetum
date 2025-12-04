Feature: Validar servicio de serverest que Buscar usuarios por ID

  @api @buscar_usuarios @GET_usuarios @E01
  Scenario Outline: Realiza la busqueda de usuarios por id satisfactoriamente con parámetros validos
    Given que el servicio API_GET_usuarios-ID esta disponible en el ambiente
    When realizo una busqueda por id con el parámetro <_id>
    Then la respuesta tiene un código de estado 200
    And se valida el esquema JSON de la respuesta contra el archivo Api_GET_listarUsuariosSchema.json
    Examples:
      | _id              |
      | 0uxuPY0cbmQhpEz1 |
      |                  |

  @api @buscar_usuarios @GET_usuarios @E02
  Scenario Outline: Realiza la busqueda de usuarios por id con parámetros invalidos
    Given que el servicio API_GET_usuarios-ID esta disponible en el ambiente
    When realizo una busqueda por id con el parámetro <_id>
    Then la respuesta tiene un código de estado 400
    And se valida que el campo <field> de la respuesta sea <messageError>
    Examples:
      | _id                    | field   | messageError                                       |
      | sadsad                 | id      | id deve ter exatamente 16 caracteres alfanuméricos |
      | 0uxuPY0cbdssdmQhpEz1sd | id      | id deve ter exatamente 16 caracteres alfanuméricos |
      | random                 | message | Usuário não encontrado                             |
