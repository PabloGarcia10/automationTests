Feature: Validacao site correios

  Scenario Outline: Validar busca de endereco por CEP
    Given que eu acesso o site dos correios na url "https://www.correios.com.br"
    And clico no campo busca CEP ou endereco
    And preencho com o <cep>
    When clico em buscar
    And for levado a outra pagina
    Then resultado deve ser <resultado>

    Examples: 
      | cep        | resultado                              |
      | "80700000" | "Não há dados a serem exibidos"        |
      | "01013001" | "Rua Quinze de Novembro, São Paulo/SP" |
