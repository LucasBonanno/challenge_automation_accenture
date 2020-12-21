[![](https://www.accenture.com/t20180820T080654Z__w__/br-pt/_acnmedia/Accenture/Dev/Redesign/Acc_Logo_Black_Purple_RGB.PNG)](https://www.accenture.com/br-pt)

# Lucas Bonanno Casanova 

### https://www.linkedin.com/in/lucas-bonanno-casanova-automation-qa/

### Desafio - Accenture
Entrar no site http://sampleapp.tricentis.com/101/app.php
Preencher o formulário, aba “Enter Vehicle Data” e pressione next
Preencher o formulário, aba “Enter Insurant Data” e pressione next
Preencher o formulário, aba “Enter Product Data” e pressione next
Preencher o formulário, aba “Select Price Option” e pressione next
Preencher o formulário, aba “Send Quote” e pressione Send
Verificar a mensagem “Sending e-mail success!” na tela



### Estrutura
É um Projeto Maven baseado na técnica de desenvolvimento BDD (Behavior Driven Development). Desenvolvido em Java e Gherkin com framework Selenium e as ferramentas JUnit e Cucumber. 

### Instalação
Clonar o projeto do repositório para ter acesso. Executar o comando no terminal:
```sh
$ git clone linkDoProjeto
```
**Observações:**
 - É necessário ter o plugin do Cucumber intalado na IDE

### Execução dos Casos de Testes
A **RunCucumberTest.class** foi estruturada para ser o disparador. 
Para executar basta alimentar a opção "tags" da anotação @CucumberOptions da classe executora.
Exemplo:
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.com.accenture.challenge.teste",
        **tags = {"@PreencherFormularios"},** 
		plugin = {"pretty", "html:evidences/report-html", "json:evidences/report.json"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true
		)

A classe executora está em: **/src/test/java/br/com/accenture/challenge/teste/runner/RunCucumberTest.java**

Os Casos de Testes estão em:
**/src/test/resources/features**

Para selecionar o browser que será utilizado para execução dos Casos de Testes é necessário alterar o enum Browser da Propriedades.class em: 
**/src/test/java/br/com/accenture/challenge/core/Propriedades.java**
Exemplo:
- Utilizando o browser Chrome
  public static Browser browser = Browser.CHROME;

### Plugins e Drivers

| Plugin | Link |
| ------ | ------ |
| Cucumber Eclipse | https://marketplace.eclipse.org/content/cucumber-eclipse-plugin |
| Cucumber Intellij | https://plugins.jetbrains.com/plugin/7212-cucumber-for-java|
| Chrome Drive | https://chromedriver.chromium.org/getting-started |
| FireFox Drive | https://github.com/mozilla/geckodriver/releases |