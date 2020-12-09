FROM openjdk:8
EXPOSE 9002
ADD target/enroll-api.jar enroll-api.jar
ENTRYPOINT ["java","-jar","/enroll-api.jar"]