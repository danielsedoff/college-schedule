@echo off
chcp 1251
rem mvn install + copy a .war file to tomcat's public directory
rem mind you, the tests are omitted here.

set warfile=*.war
set tompub=C:\tomcat\apache-tomcat-9.0.38\webapps
set projectpath=C:\javaprojects\college-schedule
set skip=-DskipTests

cd %projectpath%
cmd /c mvn install %skip%

if exist %tompub%\%warfile% del %tompub%\%warfile%
copy %projectpath%\target\%warfile% %tompub%

timeout 3