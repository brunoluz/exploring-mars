FROM bitnami/java

WORKDIR /java

COPY target/exploring-mars-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "exploring-mars-0.0.1-SNAPSHOT.jar"]
