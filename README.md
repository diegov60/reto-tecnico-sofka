# Reto Técnico Sofka - QA Automation

Autor: **Diego Alejandro Vélez Osorio** — QA Automation Engineer

| Carpeta | Ejercicio | Herramienta | Resultado |
|---|---|---|---|
| `ejercicio1-opencart-serenity` | E2E compra como invitado en OpenCart | Serenity BDD 4 + Screenplay + Cucumber | ✅ 1/1 escenario aprobado |
| `ejercicio2-petstore-karate` | CRUD de usuario en PetStore API | Karate 1.5.2 | ✅ 2/2 escenarios aprobados |
| `performance/ejercicio1-jmeter-login` | Prueba de carga del servicio de login | Apache JMeter 5.6.3 | ✅ 24,81 TPS, 0,40 % error, p95 150 ms* |
| `performance/ejercicio2-analisis-resultados` | Análisis de resultados de prueba de carga | Informe Word | ✅ InformeResultados.doc |

\* FakeStoreAPI no estuvo disponible durante el reto (errores 521/522 de Cloudflare). La caída está documentada en `performance/ejercicio1-jmeter-login/evidencias` y el mismo script se ejecutó contra un servicio equivalente (DummyJSON). Ver `conclusiones.txt`.

## Requisitos
- Java JDK 17+
- Maven 3.9+
- Google Chrome (ejercicio OpenCart)
- Apache JMeter 5.6.3 (ejercicio de carga)

## Ejecución rápida
```bash
# E2E OpenCart
cd ejercicio1-opencart-serenity
mvn clean verify

# API PetStore
cd ejercicio2-petstore-karate
mvn clean test

# Carga login (Windows)
cd performance/ejercicio1-jmeter-login
ejecutar.bat
```

## Contenido de cada ejercicio
- `readme.txt`: instrucciones paso a paso y versiones.
- `conclusiones.txt`: hallazgos, decisiones y recomendaciones.
- `evidencias/` y `reports/`: reportes de ejecución.
