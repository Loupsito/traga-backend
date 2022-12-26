# How to run the project

## Prerequisites
You must have `PostgresSQL` installed

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
1. Run it with Maven cmd (or your favorite IDE like IntelliJ)
2. You can check the swagger generated here : http://localhost:8080/swagger-ui.html

