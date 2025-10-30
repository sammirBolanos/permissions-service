# permissions-service
Control de acceso por rol administrativo: Solo usuarios con perfil de coordinador o 
médico pueden modificar configuraciones de agenda.

## Pruebas y Cobertura

### Ejecutar pruebas unitarias
```bash
cd demo
mvn test
```

### Generar reporte de cobertura JaCoCo
```bash
cd demo
mvn clean test
```

El reporte HTML se genera en: `demo/target/site/jacoco/index.html`

### Ver reporte de cobertura
```bash
# En Windows
start demo/target/site/jacoco/index.html
```

### Cobertura mínima requerida
El proyecto está configurado con una cobertura mínima del **50%** por paquete.

### CI/CD
El workflow de GitHub Actions ejecuta automáticamente las pruebas y genera:
- Reportes de cobertura JaCoCo
- Badges de cobertura
- Reportes de pruebas Surefire

Los reportes están disponibles como artifacts en cada ejecución del workflow.
