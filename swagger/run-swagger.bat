set swaggerpath=c:\software\swagger\swagger-codegen-cli-2.2.1.jar
set apidocspath=http://localhost:8080/v2/api-docs

md swagger
cd swagger

java -jar %swaggerpath% generate -i %apidocspath% -l java

pause
