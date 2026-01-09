# food-api-ed-it-jwt - Educación IT 2025 (Curso dictado por mi autoría)

Este proyecto implementa un servicio REST que gestiona comidas (**CRUD completo**), utilizando Spring Boot, Spring Security (JWT), JPA/Hibernate, base de datos en memoria H2 y Caché.
Además, **consume un endpoint de la misma aplicación**, reutilizando el token JWT vigente.

Utiliza arquitectura en capas (entity -> repository -> service -> controller), manejo de excepciones y validaciones de duplicidad en la creación de entidades.
Además la app cuenta con seguridad con JWT (login, registro y logout), uso de roles y un endpoint de administración de usuarios, disponible solo para el rol Administrador.

<p align="center">
  <img src="https://github.com/user-attachments/assets/64a0413b-6d56-4829-886f-ee0a9c181fa3"/>
</p>

---

## Tecnologías Utilizadas
- **Spring Boot Versión 3.5.3** 
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Test / Junit**
- **H2 Database:**
- **Spring Boot Starter Validation**
- **Lombok**
- **Spring Boot Starter Security**
- **Spring Boot Starter Cache y Caffeine**
- **DataFaker:** Utilizado para generar datos para los test unitarios.
- **Swagger**

## Construcción y Ejecución

Utiliza el siguiente comando Maven:

```bash
mvn clean install
```

## Endpoint swagger

El endpoint de swagger se encuentra en:

`/swagger-ui/index.html`

<img width="2174" height="966" alt="image" src="https://github.com/user-attachments/assets/356bb917-8795-4673-82f6-711aaafc1dd3" />

## Live Demo

### [Click Here! 🖱️](https://food-api-ed-it-jwt.onrender.com/)

#### Usuarios de prueba (pass: *password*):
- admin
- user1

<hr>

## Información Adicional
Para cualquier información adicional o consultas: <maxisandoval98@gmail.com>

<p align="center"><b>¡Muchas gracias! 🦔</b></p>
