# Reto Técnico Sofka - QA Automation

Autor: **Diego Alejandro Vélez Osorio** — QA Automation Engineer

| Carpeta | Ejercicio | Herramienta | Resultado |
|---|---|---|---|
| `ejercicio1-opencart-serenity` | E2E compra como invitado en OpenCart | Serenity BDD 4 + Screenplay + Cucumber | ✅ 1/1 escenario aprobado |
| `ejercicio2-petstore-karate` | CRUD de usuario en PetStore API | Karate 1.5.2 | ✅ 2/2 escenarios aprobados |

## Requisitos
- Java JDK 17+
- Maven 3.9+
- Google Chrome (solo ejercicio 1)

## Ejecución rápida
```bash
# Ejercicio 1 - E2E OpenCart
cd ejercicio1-opencart-serenity
mvn clean verify
# Reporte: target/site/serenity/index.html

# Ejercicio 2 - API PetStore
cd ejercicio2-petstore-karate
mvn clean test
# Reporte: target/karate-reports/karate-summary.html
```

## Contenido de cada ejercicio
- `readme.txt`: instrucciones paso a paso de ejecución.
- `conclusiones.txt`: hallazgos, decisiones de diseño y mejoras propuestas.
- `evidencias/`: reporte de una ejecución exitosa.
