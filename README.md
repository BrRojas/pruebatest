# pruebatest

Proyecto de práctica con Spring Boot enfocado en la capa de servicio y pruebas unitarias.

## 🧩 Estructura del proyecto

| Capa       | Descripción                                     |
|------------|-------------------------------------------------|
| Entity     | Clase `User` que representa el modelo de datos  |
| Repository | Interfaz `UserRepository` con JPA               |
| Service    | Clase `UserService` con la lógica del negocio   |
| Test       | Pruebas unitarias con JUnit 5 y Mockito         |

## ⚙️ Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- JUnit 5
- Mockito

## 🧪 Cómo correr los tests

```bash
./mvnw test
