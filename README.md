# Traga backend API

## Prerequisites
You must have the following installed :
  - `PostgresSQL`
  - `Maven`

Create a database named "Traga" or run this script :
   ```postgresql
   CREATE DATABASE traga
     WITH
     OWNER = <change it>
     ENCODING = 'UTF8'
     LC_COLLATE = 'en_US.UTF-8'
     LC_CTYPE = 'en_US.UTF-8'
     TABLESPACE = pg_default
     CONNECTION LIMIT = -1;
   ```
# Run the project

## Run with your favorite IDE
I use `IntelliJ` to develop and run this backend app

## Run with commands line
   ```bash
   # 1. Build jar (you will need to run it from the project folder containing the pom.xml file)
   mvn install

   # 2. Run the springboot application with maven
   mvn spring-boot:run

   # 2(bis). Or run the springboot application with java -jar command
   java -jar target/Traga-0.0.1-SNAPSHOT.jar
   ```
## Swagger
You can check the swagger generated here : http://localhost:8080/swagger-ui.html

