# language: pt

@ChallengeAccenture
Funcionalidade: Preencher Formulários do portal

Contexto:
Dado que tenha carregado o portal da Tricentis

@PreencherFormularios
Cenário: Deve efetuar preenchimento dos formulários e enviar e-mail com sucesso
Quando preencher o formulario Enter Vehicle Data
E o formulario Enter Insurant Data
E o formulario Enter Product Data
E selecionar opcao de precos
Entao sera possivel enviar cota
E sera possivel Verificar a mensagem "Sending e-mail success!"