Implementation of spring-boot microservices architecture from the ground up.

The basic layout of the initial application has these features:

- The docker folder is the root of all docker containers that will be used as this application grows
  - Initially this just has a mysql container that needs to be started before any of the services are
- The infrastructure folder contains essential services that the microservices need to function
  - Initially there is only the service-registry, which is a spring boot service that runs a Eureka server for service discovery
    - All services register with the service registry and use Feign clients for service-to-service communication
- The services folder is the root of all custom microservices in this repository

# Getting Started
- Make any changes to docker/mysql/docker-compose.yml
  - If you change the password or the schema name, you will also need to reflect those changes in all application.yml files that have these credentials
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sbmicro
    username: root
    password: sellis
```
  - Note that in the future this will be consolidated so that changes in the user, password or schema will be in a central location--this is just an early-stage POC
- Start mysql in docker/mysql
```bash
cd docker/mysql
docker-compose up -d
```
- Once MySQL is running you will have to connect to the database and run the scripts found in each of the service resource roots to create tables and populate the data
  - This is another task that will be automated in the future, but for now this is a manual task
- Package all the services for execution
```bash
./mvnw package 
```
  - Note that when building the application you will see errors regarding connection to the service registry, which at this point is not running.  
    - This is another future enhancement to fix services in test to work correctly
    - Even though errors show in the output, all test cases will pass
- Start up the service-registry, address-service and employee-service, in that order:
```bash
java -jar infrastructure/service-registry/target/service-registry-0.0.1-SNAPSHOT.jar
java -jar services/address-service/target/address-service-0.0.1-SNAPSHOT.jar
java -jar services/employee-service/target/employee-service-0.0.1-SNAPSHOT.jar 
```
  - Alternatively, you can simply run these services in IntelliJ from the run configurations that are automatically generated

- Verify that everything is working with this curl command:
```bash
curl http://localhost:8080/employee-service/employees/1 
```
and you should see:
```json
{"id":1,"name":"Scott Ellis","email":"j.scott.ellis64@gmail.com","age":"59","address":{"id":1,"city":"Littleton","state":"Massachusetts"}}
```


