# Useful-tool-microservices-project

Design Microservice structure with Docker using Spring Boot and Maven.

## How to run?

### Build all modules:

`useful-tool-microservices-project> mvn clean package -DskipTests=true`

### Start infrastructure modules in docker:

`useful-tool-microservices-project> docker-compose up --build`

**Start each microservice either in docker:**

**Docker:** `useful-tool-microservices-project> docker-compose up -d <service> --build --force-recreate`

Ex: `useful-tool-microservices-project> docker-compose up -d catalog-service --build --force-recreate`


* MySQL container:
     * hostname: mysqldb
     * Ports : 3306:3306 (<host_port>:<container_port>)
     * Username/Password: root/admin

* RabbitMQ:
     * hostname: rabbitmq
     * Ports: 5672:5672, 15672:15672
     * Admin UI: http://localhost:15672
     * Username/password: guest/guest

* config-server:
    * hostname: config-server
    * Ports: 8888:8888
    * URL: http://localhost:8888/
    
* service-registry:
    * hostname: service-registry
    * Ports: 8761:8761
    * URL: http://localhost:8761/
    
* oauth-server:
	* hostname: oauth-server
    * Ports: 8901:8901
    * URL: http://localhost:8901/
    
* explain-service:
	* hostname: explain-service
    * Ports: 8081:8081
    * URL: http://localhost:8081/
   
* useful-service:
    * hostname: useful-service
    * Ports: 8082:8082
    * URL: http://localhost:8082/
    
    
## Docker image explain

* Vault 
Vault is a tool for securely accessing secrets via a unified interface and tight access control.

* RabbitMQ
RabbitMQ is an open source multi-protocol messaging broker.

* MySQL
MySQL is a widely used, open-source relational database management system (RDBMS).

## reference
- http://blog.leekyoungil.com/?p=352#comments
- https://coe.gitbook.io/guide/service-discovery/eureka
- http://www.littlebigextra.com/use-spring-profiles-docker-containers/
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-profile-specific-properties
- https://books.sonatype.com/mvnex-book/reference/multimodule.html




