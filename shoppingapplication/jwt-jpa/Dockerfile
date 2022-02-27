FROM openjdk
WORKDIR jwt/lib
EXPOSE 8085
ADD ./target/jwt-jpa-0.0.1-SNAPSHOT.jar  /jwt/lib/jwt-jpa-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","jwt-jpa-0.0.1-SNAPSHOT.jar"]
