Feature: Validar servicio de serverest que Lista usuarios

  @api @listar_usuarios @GET_usuarios @E01
  Scenario Outline: Obtener usuarios con parámetros validos
    Given que el servicio API_GET_usuarios esta disponible en el ambiente
    When realizo una solicitud con los parámetros <_id> <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 200
    And se valida el esquema JSON de la respuesta contra el archivo Api_GET_listarUsuariosSchema.json
    Examples:
      | _id              | nome            | email         | password | administrador |
      | 0uxuPY0cbmQhpEz1 | Fulano          |               |          |               |
      |                  | da              |               |          |               |
      |                  | Silva           |               |          |               |
      |                  |                 | fulano@qa.com |          |               |
      |                  |                 |               | teste    |               |
      |                  |                 |               | tes      |               |
      |                  |                 |               |          | true          |
      | 0uxuPY0cbmQhpEz1 | Fulano da Silva | fulano@qa.com | teste    | true          |


  @api @listar_usuarios @GET_usuarios @E02
  Scenario Outline: Obtener usuarios con parámetros inválidos
    Given que el servicio API_GET_usuarios esta disponible en el ambiente
    When realizo una solicitud con los parámetros <_id> <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 400
    And se valida el esquema JSON de la respuesta contra el archivo Api_GET_listarUsuariosSchema.json
    Examples:
      | _id | nome | email  | password | administrador |
      |     |      | fulano |          |               |
      |     |      |        |          | 1234          |

  @api @listar_usuarios @GET_usuarios @E03
  Scenario Outline: Obtener usuarios con inputs con inputs de busqueda que no existan y se genere filtrado vacio
    Given que el servicio API_GET_usuarios esta disponible en el ambiente
    When realizo una solicitud con los parámetros <_id> <nome> <email> <password> <administrador>
    Then la respuesta tiene un código de estado 200
    And se valida el esquema JSON de la respuesta contra el archivo Api_GET_listarUsuariosSchema.json
    Examples:
      | _id              | nome   | email       | password | administrador |
      | a3929dd5cee1ff24 |        |             |          |               |
      |                  | dasdas |             |          |               |
      |                  |        | aria@qa.com |          |               |
      |                  |        |             | 54665    |               |


