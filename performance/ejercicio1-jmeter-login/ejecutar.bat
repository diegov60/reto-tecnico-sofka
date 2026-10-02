@echo off
REM Ejecuta la prueba de carga en modo no grafico y genera el dashboard HTML
cd /d "%~dp0"
if exist reports\dashboard rmdir /s /q reports\dashboard
if exist results\resultados.jtl del /q results\resultados.jtl
jmeter -n -t login-load-test.jmx -l results\resultados.jtl -j results\jmeter.log -e -o reports\dashboard -Jjmeter.reportgenerator.apdex_satisfied_threshold=1500 -Jjmeter.reportgenerator.apdex_tolerated_threshold=3000
echo.
echo Reporte generado en: reports\dashboard\index.html
pause
