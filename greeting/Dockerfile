FROM openjdk:8
COPY target/greeting-0.0.1-SNAPSHOT.jar /app/main.jar
WORKDIR /app
CMD ["java", "-Xmx512m", "-jar", "main.jar"]
