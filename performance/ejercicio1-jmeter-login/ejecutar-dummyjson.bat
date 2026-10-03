@echo off
REM Plan B: ejecuta el MISMO script contra DummyJSON (servicio alternativo)
REM por indisponibilidad de fakestoreapi.com (errores 521/522 de Cloudflare)
cd /d "%~dp0"
if exist reports\dashboard-dummyjson rmdir /s /q reports\dashboard-dummyjson
if exist results\resultados-dummyjson.jtl del /q results\resultados-dummyjson.jtl
jmeter -n -t login-load-test.jmx -l results\resultados-dummyjson.jtl -j results\jmeter-dummyjson.log -e -o reports\dashboard-dummyjson -Jhost=dummyjson.com -Jcsv=data/usuarios-dummyjson.csv -JtokenPath=$.accessToken -Jjmeter.reportgenerator.apdex_satisfied_threshold=1500 -Jjmeter.reportgenerator.apdex_tolerated_threshold=3000
echo.
echo Reporte generado en: reports\dashboard-dummyjson\index.html
pause
