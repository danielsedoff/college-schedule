rem Copy a .war file to tomcat's public directory

set warfile=college-schedule-0.0.1-SNAPSHOT.war
set tompub=C:\tomcat\apache-tomcat-9.0.38\webapps
set build=C:\javaprojects\college-schedule\target

if exist %tompub%\%warfile% del %tompub%\%warfile%
copy %build%\%warfile% %tompub%
