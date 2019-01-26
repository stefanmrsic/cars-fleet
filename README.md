# cars-fleet
Test application for MTribes

#Address of running app
https://cars-fleet.herokuapp.com/

#Running locally
Need maven installed
Java JDK 1.8 or higher

#Commands
mvn clean
mvn compile
mvn test

$java -jar target/cars-fleet-1.0.0-SNAPSHOT.jar
OR
mvn spring-boot:run

#Known improvements needed (didn't have the time :) )
-Move external properties to Environment variables
-Add builder objects validation
-Add Flyway migration scripts and move DB from in memory H2 to stored relational DB
