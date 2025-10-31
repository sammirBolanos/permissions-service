# Permissions Service

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sammirBolanos_permissions-service&metric=alert_status&token=d1787cc6997af598b643688b11e7dacff1a383e0)](https://sonarcloud.io/summary/new_code?id=sammirBolanos_permissions-service)
[![Java CI with SonarCloud](https://github.com/sammirBolanos/permissions-service/actions/workflows/ci.yml/badge.svg)](https://github.com/sammirBolanos/permissions-service/actions/workflows/ci.yml)

Microservicio para la gestión de permisos y control de acceso basado en roles (RBAC) para el sistema CitaSalud.

## 📋 Descripción

Control de acceso por rol administrativo que permite:
- Consultar permisos asignados a roles específicos
- Solo usuarios con perfil de coordinador o médico pueden modificar configuraciones de agenda
- Gestión centralizada de permisos del sistema

## 🚀 Tecnologías

- **Java 21** - Lenguaje de programación
- **Spring Boot 3.4.0** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **PostgreSQL** - Base de datos
- **Maven** - Gestión de dependencias
- **JUnit 5** - Framework de pruebas
- **Mockito** - Mocking para pruebas
- **JaCoCo** - Cobertura de código
- **SonarCloud** - Análisis de calidad de código
- **SpringDoc OpenAPI** - Documentación de API
- **Lombok** - Reducción de código boilerplate

## 📁 Estructura del Proyecto

```
permissions-service/
├── .github/
│   └── workflows/
│       └── ci.yml              # Pipeline CI/CD con GitHub Actions
├── demo/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/citasalud/demo/
│   │   │   │       ├── controllers/      # Controladores REST
│   │   │   │       ├── models/
│   │   │   │       │   ├── Dtos/         # Data Transfer Objects
│   │   │   │       │   └── OrmModels/    # Entidades JPA
│   │   │   │       ├── repositories/     # Repositorios JPA
│   │   │   │       └── services/         # Lógica de negocio
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   │       └── java/                     # Pruebas unitarias
│   ├── pom.xml                           # Configuración Maven
│   └── .env.example                      # Ejemplo de variables de entorno
├── .gitignore
└── README.md
```

## 🔧 Configuración Local

### Prerrequisitos

- Java 21 o superior
- Maven 3.8+
- PostgreSQL 15+
- Git

### Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/sammirBolanos/permissions-service.git
   cd permissions-service
   ```

2. **Configurar variables de entorno**
   ```bash
   cd demo
   cp .env.example .env
   ```

3. **Editar el archivo `.env` con tus credenciales**
   ```properties
   DB_URL=jdbc:postgresql://localhost:5432/citasalud
   DB_USERNAME=tu_usuario
   DB_PASSWORD=tu_contraseña
   ```

4. **Crear la base de datos**
   ```sql
   CREATE DATABASE citasalud;
   ```

### Ejecutar la aplicación

```bash
cd demo
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 📚 API Documentation

Una vez que la aplicación esté corriendo, la documentación interactiva de la API estará disponible en:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

### Endpoints Principales

#### Obtener permisos por rol
```http
GET /rol/{idRol}
```

**Parámetros:**
- `idRol` (Integer) - ID del rol

**Respuesta exitosa (200):**
```json
[
  {
    "nombreRol": "ADMIN",
    "nombrePermiso": "CREATE_USER"
  },
  {
    "nombreRol": "ADMIN",
    "nombrePermiso": "DELETE_USER"
  }
]
```

## 🧪 Pruebas

### Ejecutar todas las pruebas
```bash
cd demo
mvn test
```

### Ejecutar pruebas con cobertura
```bash
cd demo
mvn clean test
```

### Ver reporte de cobertura JaCoCo

El reporte HTML se genera automáticamente en: `demo/target/site/jacoco/index.html`

**En Windows:**
```bash
start target/site/jacoco/index.html
```

**En Linux/Mac:**
```bash
open target/site/jacoco/index.html
```

### Verificar cobertura mínima
```bash
cd demo
mvn clean verify
```

El proyecto requiere una **cobertura mínima del 50%** por paquete. La verificación falla si no se cumple este umbral.

### Estructura de Pruebas

```
demo/src/test/java/com/citasalud/demo/
├── controllers/
│   └── RolePermissionControllerTest.java    # Tests del controlador
├── services/
│   └── RolePermissionServiceTest.java       # Tests del servicio
└── models/
    ├── Dtos/
    │   └── RoleResponseDtoTest.java         # Tests del DTO
    └── OrmModels/
        ├── RoleTest.java                    # Tests de entidad Role
        ├── PermissionTest.java              # Tests de entidad Permission
        └── RolePermissionTest.java          # Tests de entidad RolePermission
```

**Total:** 18 pruebas unitarias

## 🔄 CI/CD

El proyecto utiliza **GitHub Actions** para integración y despliegue continuo.

### Pipeline

El workflow se ejecuta automáticamente en:
- Push a ramas `develop` y `main`
- Pull requests a ramas `develop` y `main`

### Jobs

#### 1. Unit Tests (41s aprox.)
- ✅ Ejecuta todas las pruebas unitarias
- ✅ Genera reportes de cobertura con JaCoCo
- ✅ Crea badges de cobertura
- ✅ Sube artifacts (reportes de pruebas y cobertura)

#### 2. SonarCloud Analysis (1m 2s aprox.)
- ✅ Análisis estático de código
- ✅ Detección de code smells
- ✅ Detección de vulnerabilidades
- ✅ Análisis de duplicación de código
- ✅ Reporte de cobertura integrado

### Ver Resultados

- **GitHub Actions**: [Ver workflows](https://github.com/sammirBolanos/permissions-service/actions)
- **SonarCloud**: [Ver análisis](https://sonarcloud.io/summary/new_code?id=sammirBolanos_permissions-service)

## 📊 Métricas de Calidad

### Cobertura de Código
- **Objetivo:** >80%
- **Mínimo requerido:** 50%
- **Herramienta:** JaCoCo

### Análisis Estático
- **Herramienta:** SonarCloud
- **Quality Gate:** Configurado
- **Métricas monitoreadas:**
  - Bugs
  - Vulnerabilidades
  - Code Smells
  - Duplicación
  - Cobertura

## 🗄️ Modelo de Datos

### Entidades Principales

#### Role
```java
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String descripcion;
    
    // Relaciones y métodos...
}
```

#### Permission
```java
@Entity
@Table(name = "permisos")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String descripcion;
    
    // Relaciones y métodos...
}
```

#### RolePermission
```java
@Entity
@Table(name = "rol_permiso")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "idrol")
    private Role role;
    
    @ManyToOne
    @JoinColumn(name = "idpermiso")
    private Permission permission;
    
    // Métodos...
}
```

## 🔐 Seguridad

### Variables de Entorno

Las credenciales sensibles **NUNCA** deben incluirse en el código fuente. Usa variables de entorno:

- `DB_URL` - URL de conexión a la base de datos
- `DB_USERNAME` - Usuario de la base de datos
- `DB_PASSWORD` - Contraseña de la base de datos

### Buenas Prácticas

- ✅ `.env` está en `.gitignore`
- ✅ Usa `.env.example` como plantilla
- ✅ Configura secrets en GitHub Actions
- ✅ No hardcodees credenciales

## 🤝 Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Estándares de Código

- Sigue las convenciones de Java
- Escribe pruebas para código nuevo
- Mantén la cobertura >80%
- Asegúrate de que pase el Quality Gate de SonarCloud
