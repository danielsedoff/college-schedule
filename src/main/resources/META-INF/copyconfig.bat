set  target="C:\javaprojects\Servers\Tomcat v9.0 Server at localhost-config"
set  source=%cd%
cd   %target%
ren  server.xml  server.xml.old
ren  context.xml context.xml.old
ren  web.xml     web.xml.old
cd   %source%
copy server.xml  %target%
copy context.xml %target%
copy web.xml     %target%
