#Test Automation - Arcadio Buelvas
Este Repositorio usa:
```
Selenium
Cucumber
Gherkin
SerenityBDD
Java 8
chromedriver
Junit
Gradle
```

## Environment Setup

```
1 --> Install Java 8 --> https://www.java.com/es/download/help/windows_manual_download.html#download
2 --> Install Gradle --> https://gradle.org/install/
3 --> Install a IDE, IntelliJ estaria bien (Opcional)
```

## Install Dependencies

```
Usando el IDE.
Abrir el proyecto y correr el archivo "build.gradle"
```

## Correr Los Tests

```
Usando el CMD.
Para correr todos los tests --> "gradle clean test aggregate" (Este comando ademas crea un reporte HTML con los resultados de cada ejecucion)

```

## Manejo de Enviroments y Browsers 

```

Ejemplo --> "gradle clean test aggregate  -Denvironment=dev  -Dcontext=chrome -Dwebdriver.driver=chrome -Dinjected.tags=browser:chrome"

-Denvironment -> (default, dev, staging, prod) Env en el que se quieren ejecutar las pruebas, si no se inclueye el parametro se ejecutara en un ambiento 'default' definido por defecto en el archivo serenity.conf

-Dwebdriver.driver --> Parametro para indicar en que navegador se van a ejecutar las pruebas.

-Dcontext and Dinjected.tags --> Parametros que usa serenity para agregar tags y diferenciar los browsers en los que se corrienron las pruebas cuando genera el reporte HTML.
```

##Usando el IDE.

```
Para correr un solo test --> Ir al folder Runners, abrir la clase Java llamada "Runner" y cambiar el @Tags. 

Para correr todos los Test debe usar el @Tag de la .feature. 

Seria algo como lo siguiente:

@CucumberOptions(features = {"src/test/resources/features/"},
        tags = "@TagParaUsar",
        glue = "Definitions",
        snippets = SnippetType.CAMELCASE )
			
```
		
# Acerca del Framework y el Patron de Diseño

El framework está construido bajo BDD (Behavior Driven Development) bajo el patrón de diseño POM (Page Object Model).

Toda la lógica de las pruebas se puede encontrar en -> src/test/java/PageObjects/ 

El Runner para las pruebas se puede encontrar en -> src/test/Runners/Runner

La definición de los pasos de la prueba (Orquestador) se puede encontrar en -> src/test/Definitions

El comportamiento de la prueba está escrito en Gherkin con la idea principal de que una persona sin conocimientos de programación pueda entender 
lo que está haciendo la prueba.  

Puede encontrar el .feature de la prueba aquí -> src/test/resources/jikkosoft.feature.

# Reportes

Se crea automáticamente un reporte HTML para cada ejecución de las pruebas usando este comando -> "gradle clean test aggregate".

Puede encontrar el reporte en -> target/site/serenity/index.html
