# Oompa Loompa Proyect / Test
This is an application builder on springboot to manage the ​Oompa Loompa's crew.

### Third party librarie

 - mysql-connector-java
 - spring-boot-starter-data-jpa
 - spring-boot-starter-web
 - spring-boot-starter-test
  
### Installation with docker

### Building

mvn clean install

docker build -t loompalandia-backend .

docker-compose up




### URL to use
                    
| Url      | Method | Parameters | 
| ------ | ------ | ------ |
| /v1/api/list  | GET |  ?page=0&size=10 |
| /v1/api/full/{id}     |   GET  | {id} |
| /v1/api/create      |    POST |  ```{"name": string, "age": int, "job": string, "height": int, "weight": int, description: string}``` |
| /v1/api/update      |    PUT |  ```{"id": int:"name": string, "age": int, "job": string, "height": int, "weight": int, description: string}``` |