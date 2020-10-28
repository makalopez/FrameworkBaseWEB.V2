Feature: Inicio sesión

  @Test-PlazaVea7
  Scenario Outline: Inicio sesión cuenta recurrente

    Given Usuario ingresa a la URL Plaza Vea "<casodeprueba>"
    When  Ingreso a perfil e Inicia sesión como usuario recurrente "<casodeprueba>"
    Then  Valido el inicio de sesión
    Examples:
      | casodeprueba |
      | 1            |