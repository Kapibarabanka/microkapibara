FROM java:8-jre

ADD ./target/hello-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/hello-service.jar"]

EXPOSE 8080