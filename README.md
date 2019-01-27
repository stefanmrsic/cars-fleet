# cars-fleet
Test application for MTribes

# Address of running app
https://cars-fleet.herokuapp.com/

# Running locally
Need maven installed <br />
Java JDK 1.8 or higher <br />

# Commands
mvn clean <br />
mvn compile <br />
mvn test <br />

$java -jar target/cars-fleet-1.0.0-SNAPSHOT.jar <br />
OR <br />
mvn spring-boot:run

# Known improvements needed (didn't have the time :) )
-Move external properties to Environment variables <br />
-Add builder objects validation <br />
-Add Flyway migration scripts and move DB from in memory H2 to stored relational DB <br />
-Upgrade frontend to use React or Angular <br />
-Split monolith into several individual maven projects (with a parrent project), e.g. domain shouldn't have any external dependencies, spring, immutables etc.
