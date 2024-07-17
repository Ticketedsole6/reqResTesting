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
    │   │                   ├── interactions/
    │   │                   ├── models/
    │   │                   ├── questions/
    │   │                   └── tasks/
    │   │
    │   └── test/
    │       └── java/
    │           └── in/
    │               └── reqres/
    │                   └── testing/
    │
    ├── .gitignore
    ├── pom.xml
    ├── Jenkinsfile
    └── README.md
  ```

- **src/main/java**: Código fuente de la aplicación.
- **src/test/java**: Código fuente para pruebas.
- **pom.xml**: Archivo de configuración de Maven.
- **Jenkinsfile**: Archivo de configuración para Jenkins.

## 🚀 Instalación
1. Clona el repositorio:
  ```sh
  git clone https://github.com/Ticketedsole6/reqResTesting.git
  ```
2. Compila el proyecto usando Maven:
  ```sh
  mvn clean install
  ```

## 🛠️ Jenkins
Este proyecto incluye un archivo Jenkinsfile que define el proceso de CI/CD. Asegúrate de configurar Jenkins para que
apunte a tu repositorio y ejecute el pipeline definido en este archivo.

### Configuración del pipeline en Jenkins
![url=https://postimg.cc/8jcMbtrS](https://i.postimg.cc/MKb5qL6v/img-7.png)


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
![url=https://postimages.org/](https://i.postimg.cc/9Fj132j6/img-6.png)
### **Reporte generado por serenity por medio del pipeline**
![url=https://postimg.cc/py2Dm2Wy](https://i.postimg.cc/8kvwn5xd/img-2.png)

- **Test para el registro de usuario de manera exitosa**
![url=https://postimages.org/](https://i.postimg.cc/1zYMbN9B/img-1.png)


- **Test para obtener los usuarios de manera exitosa**
![url=https://postimages.org/](https://i.postimg.cc/4yp5KLp2/img-3.png)


- **Test para eliminar un usuario de manera exitosa**
![url=https://postimages.org/](https://i.postimg.cc/MTMtwKHS/img-4.png)


- **Test para actualizar un usuario de manera exitosa**
![url=https://postimages.org/](https://i.postimg.cc/50hg2dQF/img-5.png)

## 📧 Owner
Este repositorio fue creado por Juan Felipe Gómez