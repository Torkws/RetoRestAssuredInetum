Feature: Validar servicio de serverest que elimina usuarios

  @api @eliminar_usuarios @DELETE_usuarios @E01
  Scenario Outline: Eliminar usuarios satisfactoriamente con parámetros válidos
    Given que el servicio API_DELETE_usuarios esta disponible en el ambiente
    When realizo una busqueda por id con el parámetro <_id>
    Then la respuesta tiene un código de estado 200
    And se obtiene un id existente de la lista para ser eliminado
    When realizo una eliminación con el parámetro <_id>
    Then la respuesta tiene un código de estado 200
    And se valida que el campo message de la respuesta sea Registro excluído com sucesso
    And se valida el esquema JSON de la respuesta contra el archivo Api_DELETE_eliminarUsuariosSchema.json
    Examples:
      | _id    |
      | exists |

  @api @eliminar_usuarios @DELETE_usuarios @E02
  Scenario Outline: Eliminar usuarios con usuario inexistente
    Given que el servicio API_DELETE_usuarios esta disponible en el ambiente
    When realizo una eliminación con el parámetro <_id>
    Then la respuesta tiene un código de estado 200
    And se valida que el campo message de la respuesta sea Nenhum registro excluído
    Examples:
      | _id    |
      | random |

  @api @eliminar_usuarios @DELETE_usuarios @E03
  Scenario Outline: Eliminar usuarios con usuario que posee carrito asociado
    Given que el servicio API_DELETE_usuarios esta disponible en el ambiente
    When realizo una eliminación con el parámetro <_id>
    Then la respuesta tiene un código de estado 400
    And se valida que el campo message de la respuesta sea Não é permitido excluir usuário com carrinho cadastrado
    Examples:
      | _id              |
      | 0uxuPY0cbmQhpEz1 |