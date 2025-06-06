FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app/ResumeAnalyzer
COPY ResumeAnalyzer ./
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/ResumeAnalyzer/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
