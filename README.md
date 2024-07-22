# reqResTesting Repository

## 📋 Descripción

**reqResTesting** es un proyecto que se centra en la realización de pruebas automatizadas para APIs. Utiliza Java 1.8
para el desarrollo, Maven para la gestión de dependencias y construcción del proyecto, y Jenkins para ejecutar las pruebas desde un pipeline.

## ⚙️ Requisitos

- **Java 1.8**: Asegúrate de tener Java 1.8 instalado en tu máquina. Puedes verificarlo con el comando:
  ```sh
  java -version
  ```

- **Maven**: Necesitarás Maven para manejar las dependencias y construir el proyecto. Verifica tu versión de Maven con:
  ```sh
  mvn -v
  ```
  
## 📂 Estructura del Proyecto
  La estructura del proyecto es la siguiente:

  ```text
    reqResTesting/
    │
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── in/
    │   │           └── reqres/
    │   │               └── testing/
    │   │                   ├── exceptions/
    │   │                   ├── interactions/
    │   │                   ├── models/
    │   │                   ├── questions/
    │   │                   ├── tasks/
    │   │                   └── utils/
    │   │
    │   └── test/
    │       ├── java/
    │       │   └── in/
    │       │       └── reqres/
    │       │           └── testing/
    │       │               ├── runners/
    │       │               └── stepdefinitions/
    │       │
    │       └── resources/
    │           ├── data/
    │           ├── features/
    │           ├── schemas/
    │           ├── templates/
    │           └── serenity.conf
    │
    ├── JenkinsFile
    ├── pom.xml
    └── serenity.properties
  ```

### Carpeta `src/main/java/in/reqres/testing/`

- **`exceptions/`**: Contiene clases para gestionar excepciones personalizadas específicas de la aplicación.
- **`interactions/`**: Define interacciones con la aplicación, como acciones que los usuarios realizan.
- **`models/`**: Incluye clases que representan los modelos de datos utilizados en las pruebas y en la aplicación.
- **`questions/`**: Contiene clases que definen preguntas sobre el estado de la aplicación para verificar resultados.
- **`tasks/`**: Define tareas que deben ejecutarse durante las pruebas, como acciones a realizar en la aplicación.
- **`utils/`**: Utilidades y clases helper que proporcionan funciones auxiliares para el proyecto.

### Carpeta `src/test/java/in/reqres/testing/`

- **`runners/`**: Contiene clases que configuran y ejecutan los runners de prueba, como la clase que inicia las pruebas de Cucumber.
- **`stepdefinitions/`**: Define las definiciones de pasos para las pruebas en Cucumber, especificando cómo cada paso en las características debe ser ejecutado.

### Carpeta `src/test/resources/`

- **`data/`**: Archivos de datos para las pruebas, como datos de entrada y salida.
- **`features/`**: Archivos de características de Cucumber, que describen las pruebas en formato Gherkin.
- **`schemas/`**: Esquemas que pueden ser utilizados para validar datos en las pruebas.
- **`templates/`**: Plantillas utilizadas en las pruebas para generar datos o estructuras.
- **`serenity.conf`**: Archivo de configuración para Serenity BDD, que define cómo se ejecutan las pruebas y cómo se generan los reportes.

### Archivos en la raíz del proyecto

- **`JenkinsFile`**: Archivo de configuración para Jenkins, que define cómo se deben ejecutar las builds y pruebas en el entorno de integración continua.
- **`pom.xml`**: Archivo de configuración de Maven que especifica las dependencias del proyecto, los plugins y otros detalles de construcción.
- **`serenity.properties`**: Archivo de configuración para Serenity BDD, utilizado para configurar aspectos específicos del marco de trabajo.

## 🚀 Instalación
1. Clona el repositorio:
  ```sh
  git clone https://github.com/Ticketedsole6/reqResTesting.git
  ```
2. Compila el proyecto usando Maven:
  ```sh
  mvn clean verify
  ```

## 🛠️ Jenkins
Este proyecto incluye un archivo Jenkinsfile que define el proceso de CI/CD. Asegúrate de configurar Jenkins para que
apunte a tu repositorio y ejecute el pipeline definido en este archivo.

### Configuración del pipeline en Jenkins
![img.png](https://i.postimg.cc/TP9hPryj/img.png)


## 🔍 Ejecución de Pruebas
Para ejecutar las pruebas localmente, usa Maven:

  ```sh
  mvn clean verify
  ```

Para generar el reporte:

```sh
  mvn serenity:aggregate
  ```

## Resultados de la Ejecución del Pipeline en Jenkins

### **Etapas ejecutadas del pipeline:**
![steps.jpg](https://i.postimg.cc/t4ymqv4d/steps.jpg)

### **Reporte generado por serenity por medio del pipeline**
![results.jpg](https://i.postimg.cc/RFrtmyM4/results.jpg)

### **Ejecución de los Tests de la Feature Create User**
![create.jpg](https://i.postimg.cc/dVPDLdbj/create.jpg)

#### **Ejemplo de los pasos ejecutados**
![example-create.jpg](https://i.postimg.cc/bvM5hQV1/example-create.jpg)

### **Ejecución de los Tests de la Feature Update User Information Data**
![update.jpg](https://i.postimg.cc/Xv0bfkLQ/update.jpg)

#### **Ejemplo de los pasos ejecutados**
![example.jpg](https://i.postimg.cc/RhqxRMYT/example.jpg)

### **Ejecución de los Tests de la Feature Get Information to individual User**
![get.jpg](https://i.postimg.cc/4x8Jg9Q5/get.jpg)

#### **Ejemplo de los pasos ejecutados**
![example-get.jpg](https://i.postimg.cc/5ytQSC1k/example-get.jpg)

### **Ejecución de los Tests de la Feature Delete User**
![delete.jpg](https://i.postimg.cc/QMHS62Mb/delete.jpg)

#### **Ejemplo de los pasos ejecutados**
![delete-example.jpg](https://i.postimg.cc/sD7G9sRz/delete-example.jpg)

## 📧 Owner
Este repositorio fue creado por Juan Felipe Gómez
