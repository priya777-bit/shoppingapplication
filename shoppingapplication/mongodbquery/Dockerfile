FROM openjdk:11-jre-slim
WORKDIR prod/lib
ENV MONGO_URI=mongodb://localhost:27017/Productdb
ADD ./target/mongodbquery-0.0.1-SNAPSHOT.jar /prod/lib/mongodbquery-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","mongodbquery-0.0.1-SNAPSHOT.jar"]