FROM amazoncorretto:11-alpine-jdk

WORKDIR /worker-print-messge

COPY target/worker-print-messge-1.0.0-SNAPSHOT.jar ./
CMD ["java", "-Xms768m", "-Xmx768m", "-jar", "worker-print-messge-1.0.0-SNAPSHOT.jar"]

EXPOSE 8042
