# Oompa Loompa Proyect / Test
This is an application on spring boot to manage the ​Oompa Loompa's crew.

### Third party librarie

 - mysql-connector-java
 - spring-boot-starter-data-jpa
 - spring-boot-starter-web
 - spring-boot-starter-test
  
### Building

mvn clean install

docker build -t loompalandia-backend .

docker-compose up

### URL rest
                    
| Url      | Method | Parameters | 
| ------ | ------ | ------ |
| /v1/api/list  | GET |  ?page={page}&size={size} |
| /v1/api/full/{id}     |   GET  | {id} |
| /v1/api/create      |    POST |  ```{"name": string, "age": int, "job": string, "height": int, "weight": int, description: string}``` |
| /v1/api/update/{id}      |    PUT |  ```{"name": string, "age": int, "job": string, "height": int, "weight": int, description: string}``` |