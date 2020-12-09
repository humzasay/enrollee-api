# enrolle-api
Spring boot Based REST microservice

Created api which can perform CRUD operations on Enrolle and dependents  "enrolle-api".

1. In memory H2 database used.

2. Added logger for controller 
 
3. Added Monitoring with spring actuator

4. Added docker file for dockerize project

Instruction to run :

Execute command to build the project. ./gradlew build

Execute command to run the project. ./gradlew bootRun This will start App.

This route will create new Enrolle with its dependents- 

Create Enrolle- 

http://localhost:9002/enrollee

Get Enrolle- 

http://localhost:9002/{101}

Delete Enrolle- 

http://localhost:9002/{101}


All Monitoring endpoint http://localhost:9002/actuator

Docker Instructions - 

Build Docker Image
$ docker build -t enroll-api.jar

Check Docker Image
$ docker image ls

Run Docker Image
$ docker run -p 9090:9002 enroll-api.jar