FROM maven:3.8-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn install

FROM openjdk:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-*.jar /app/app.jar
EXPOSE 8080 
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar app.jar"]