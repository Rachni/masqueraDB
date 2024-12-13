### 🌍 Readme in Other Languages

- [README in Spanish](#readme-en-espa%C3%B1ol)

- # README (English)

## 🌐 MasqueraDB

MasqueraDB is a backend application designed for managing characters, chronicles, and users, primarily through a console-based user interface. This project was created as the final project for the first year of a web development program, with the goal of practicing Java and database management concepts.

You can view the project repository on GitHub [here](https://github.com/Rachni/masqueraDB/).

### ✨ Features

- Manage users, characters, and chronicles.
- Console-based user interface for interaction.
- **Modular Architecture**:
  - **UIConsole Module**: Handles user interaction via a menu-driven console.
  - **Backend Module**: Processes business logic and data manipulation.
  - **Entity Layer**: Encapsulates core entities like users, characters, and chronicles.
  - **Repository Layer**: Manages database interactions and abstracts data access logic.
  - **Service Layer**: Orchestrates business logic and coordinates between the repository and UI layers.
- Docker support for easy deployment.

### 🏛️ Architecture Overview

The application is designed with a modular architecture to ensure flexibility and scalability:

1. **UIConsole**:

   - Provides an interactive console-based interface.
   - Includes components like `MenuBuilder` for dynamic menu creation.

2. **Backend**:

   - Manages the core logic for entities such as Users, Characters, and Chronicles.
   - Implements reusable operations for data handling.

3. **Entity Layer**:

   - Encapsulates the primary data models and ensures separation of concerns.

4. **Repository Layer**:

   - Handles all interactions with the data storage layer.
   - Ensures a clean separation of concerns by abstracting database queries.

5. **Service Layer**:

   - Coordinates business logic between the UIConsole and Repository layers.
   - Encapsulates complex workflows and ensures consistency.

6. **Docker Integration**:

   - Enables containerized deployment for consistent runtime environments.

### 📁 Project Structure

```plaintext
masqueradb/
├── LICENSE
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── rachni/masqueradb/
│   │   │       ├── backend/
│   │   │       ├── UIConsole/
│   │   │       └── entities/
│   ├── test/
├── build.gradle.kts
├── settings.gradle.kts
├── docker/
│   └── Dockerfile
└── (other files and folders)
```

### 💻 Technologies Used

- Java
- Gradle
- Docker (for containerization)

### ⚡ Getting Started

#### Prerequisites

- Java JDK 11 or higher
- Gradle
- Docker (optional, for containerized deployment)

#### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Rachni/masqueraDB.git
   ```
2. Navigate to the project directory:
   ```bash
   cd masqueradb
   ```
3. Build the project:
   ```bash
   ./gradlew build
   ```

#### Running the Application

1. Run the application:
   ```bash
   java -jar build/libs/masqueradb.jar
   ```
2. Follow the console prompts to interact with the system.

### 🎡 Future Enhancements

- Add a web-based frontend using Spring Boot.
- Enhance database interactions with advanced querying.
- Implement multi-language support.

### 📄 Documentation

For more details about the database design and logic, check the [MasqueraDB Documentation](docs/MASQUERADB_DOCS.pdf) (available only in Spanish).

### ⚖️ License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## README en Español

### 🌐 MasqueraDB

MasqueraDB es una aplicación backend diseñada para gestionar personajes, crónicas y usuarios, principalmente a través de una interfaz de usuario basada en consola. Este proyecto fue creado como proyecto final del primer curso de un ciclo de desarrollo web, con el objetivo de practicar mis nociones de Java y de gestión de bases de datos.

Puedes ver el repositorio del proyecto en GitHub [aquí](https://github.com/Rachni/masqueraDB/).

### ✨ Características

- Gestión de usuarios, personajes y crónicas.
- Interfaz de usuario basada en consola para interacción.
- **Arquitectura Modular**:
  - **Módulo UIConsole**: Maneja la interacción del usuario mediante un menú basado en consola.
  - **Módulo Backend**: Procesa la lógica empresarial y manipulación de datos.
  - **Capa de Entidad**: Encapsula entidades principales como usuarios, personajes y crónicas.
  - **Capa de Repositorio**: Administra las interacciones con la base de datos y abstrae la lógica de acceso a datos.
  - **Capa de Servicio**: Orquesta la lógica empresarial y coordina entre el repositorio y las capas de UI.
- Soporte para Docker para un despliegue sencillo.

### 🏛️ Resumen de Arquitectura

La aplicación está diseñada con una arquitectura modular para garantizar flexibilidad y escalabilidad:

1. **UIConsole**:

   - Proporciona una interfaz interactiva basada en consola.
   - Incluye componentes como `MenuBuilder` para la creación dinámica de menús.

2. **Backend**:

   - Gestiona la lógica principal para entidades como Usuarios, Personajes y Crónicas.
   - Implementa operaciones reutilizables para manejo de datos.

3. **Capa de Entidad**:

   - Encapsula los modelos de datos principales y garantiza la separación de responsabilidades.

4. **Capa de Repositorio**:

   - Maneja todas las interacciones con la capa de almacenamiento de datos.
   - Garantiza una separación limpia de responsabilidades mediante la abstracción de consultas a bases de datos.

5. **Capa de Servicio**:

   - Coordina la lógica empresarial entre las capas de UIConsole y Repositorio.
   - Encapsula flujos de trabajo complejos y asegura consistencia.

6. **Integración con Docker**:

   - Habilita el despliegue en contenedores para entornos de ejecución consistentes.

### 📁 Estructura del Proyecto

```plaintext
masqueradb/
├── LICENSE
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── rachni/masqueradb/
│   │   │       ├── backend/
│   │   │       ├── UIConsole/
│   │   │       └── entidades/
│   ├── test/
├── build.gradle.kts
├── settings.gradle.kts
├── docker/
│   └── Dockerfile
└── (otros archivos y carpetas)
```

### 💻 Tecnologías Utilizadas

- Java
- Gradle
- Docker (para contenedores)

### ⚡ Primeros Pasos

#### Prerrequisitos

- Java JDK 11 o superior
- Gradle
- Docker (opcional, para despliegue en contenedores)

#### Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Rachni/masqueraDB.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd masqueradb
   ```
3. Construye el proyecto:
   ```bash
   ./gradlew build
   ```

#### Ejecutar la Aplicación

1. Ejecuta la aplicación:
   ```bash
   java -jar build/libs/masqueradb.jar
   ```
2. Sigue las instrucciones en la consola para interactuar con el sistema.

### 🎡 Mejoras Futuras

- Agregar un frontend basado en web utilizando Spring Boot.
- Mejorar las interacciones con la base de datos con consultas avanzadas.
- Implementar soporte multilingüe.

### 📄 Documentación

Para más detalles sobre el diseño y la lógica de la base de datos, consulta la [Documentación de MasqueraDB](docs/MASQUERADB_DOCS.pdf).


### ⚖️ Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

