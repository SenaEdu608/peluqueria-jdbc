# Proyecto JDBC - Gestión de Servicios

**Nombre del aprendiz:** John Jairo Zamudio Agudelo  
**Evidencia:** GA7-220501096-AA2-EV01  
**Tecnología utilizada:** Java SE 17, JDBC, MySQL 8, Visual Studio Code  
**Versión de Maven:** Apache Maven 3.8.6

Este proyecto implementa un módulo de software que realiza conexión a una base de datos MySQL mediante JDBC, permitiendo realizar operaciones CRUD sobre una tabla de servicios de peluquería.

## Funcionalidades
- Registrar servicio
- Listar servicios
- Actualizar servicio por ID
- Eliminar servicio por ID

## Requisitos
- Java JDK 17
- MySQL (base de datos `peluqueria_jdbc`)
- Conector MySQL (`mysql-connector-j-9.3.0.jar`)
- IDE (Visual Studio Code o similar)

## Estructura del proyecto

```
peluqueriaAPP-jdbc/
├── bin/ ← Clases compiladas (.class)
├── lib/ ← Conector JDBC
├── src/ ← Código fuente
│   ├── Main.java
│   ├── Servicio.java
│   └── ServicioDAO.java
└── README.md
```

## Base de datos

```sql
CREATE DATABASE peluqueria_jdbc;
USE peluqueria_jdbc;

CREATE TABLE servicios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);
```

## Ejecución

1. Compilar:

```bash
javac -cp lib/mysql-connector-j-9.3.0.jar -encoding UTF-8 -d bin src/*.java
```

2. Ejecutar (PowerShell):

```bash
java -cp "bin`;lib/mysql-connector-j-9.3.0.jar" Main
```

## Enlace del repositorio

[https://github.com/SenaEdu608/peluqueria-jdbc.git](https://github.com/SenaEdu608/peluqueria-jdbc.git)
