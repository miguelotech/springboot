FROM eclipse-temurin:21-jdk AS build
WORKDIR /app-sb
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app-sb
COPY --from=build /app-sb/target/springboot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
