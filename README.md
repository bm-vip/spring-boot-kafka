# spring-boot-kafka
## Installation
Before running the application, the following commands must be executed in the terminal from the project root directory:
1. Prerequisites for running app, we must proceed according to the following steps:
   1. Install Java 17
   2. Maven 3
   3. Install Docker
   4. run the following command:
```
docker-compose up
mvn clean install
java -jar target/spring-boot-kafka-0.0.1-SNAPSHOT.jar
```