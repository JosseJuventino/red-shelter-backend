# RedShelter API

**RedShelter API** es una API REST desarrollada con **Java y Spring Boot**, cuyo propósito es facilitar y centralizar los procesos de adopción de animales rescatados por refugios y organizaciones sin fines de lucro.

## Descripción

RedShelter nace de la necesidad de proporcionar una plataforma centralizada donde diferentes refugios y organizaciones dedicadas al bienestar animal puedan registrar, administrar y publicar información sobre los animales que se encuentran disponibles para adopción.

El proyecto busca facilitar la conexión entre las organizaciones de rescate y las personas interesadas en adoptar, promoviendo la adopción responsable y mejorando la visibilidad de los animales que necesitan un hogar.

Esta API funciona como el **backend de la plataforma RedShelter**, proporcionando los servicios necesarios para la comunicación con el frontend, la aplicación de reglas de negocio y la gestión de la información almacenada.

## Objetivos

- **Centralizar la información:** reunir en una misma plataforma los animales disponibles para adopción de diferentes refugios y organizaciones.
- **Facilitar la adopción:** permitir que las personas interesadas encuentren animales que se ajusten a sus preferencias y necesidades.
- **Apoyar a los refugios:** proporcionar herramientas para administrar la información de sus animales y organizaciones.
- **Promover la adopción responsable:** contribuir a que los animales rescatados encuentren hogares adecuados.
- **Garantizar la integridad de los datos:** gestionar de manera segura y consistente la información utilizada por la plataforma.

## Responsabilidades de la API

RedShelter API actúa como intermediario entre el frontend y la base de datos. Entre sus principales responsabilidades se encuentran:

- Recibir y procesar solicitudes HTTP.
- Validar los datos recibidos.
- Aplicar las reglas de negocio.
- Gestionar usuarios, roles y organizaciones.
- Administrar la información de los animales disponibles para adopción.
- Gestionar los procesos y solicitudes de adopción.
- Realizar operaciones de creación, consulta, actualización y eliminación de registros.
- Proporcionar respuestas estructuradas y consistentes al frontend.

## Tecnologías

| Tecnología | Propósito |
|---|---|
| Java | Lenguaje de programación |
| Spring Boot | Framework para el desarrollo de la API |
| Spring Web | Construcción de endpoints REST |
| Spring Data JPA | Persistencia y acceso a datos |
| Spring Security | Autenticación y autorización |
| PostgreSQL | Base de datos relacional |
| Supabase | Servicio de alojamiento de PostgreSQL |
| Maven | Gestión de dependencias y construcción |

## Arquitectura

El proyecto utiliza una **arquitectura monolítica en capas, organizada por funcionalidades (Package-by-Feature)**.

Cada funcionalidad agrupa sus propios componentes, lo que permite mantener una separación clara de responsabilidades y facilita la evolución y el mantenimiento del sistema.

El flujo general de una solicitud es:

`Controller → Service → Repository → PostgreSQL`

### Responsabilidades por capa

- **Controller:** recibe las solicitudes HTTP y devuelve las respuestas correspondientes.
- **Service:** implementa las reglas de negocio y coordina las operaciones.
- **Repository:** proporciona el acceso a la base de datos.
- **Entity:** representa las entidades del dominio y su persistencia.
- **DTO:** define las estructuras utilizadas para intercambiar información entre el cliente y la API.

## Propósito del proyecto

RedShelter busca aprovechar la tecnología para generar un impacto positivo en el bienestar animal, brindando a los refugios una herramienta accesible para dar visibilidad a los animales rescatados y acercarlos a personas dispuestas a ofrecerles un hogar.