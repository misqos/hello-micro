FROM java:8

WORKDIR /

ADD greeting-0.0.1-SNAPSHOT.jar greeting-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD java -jar greeting-0.0.1-SNAPSHOT.jar
