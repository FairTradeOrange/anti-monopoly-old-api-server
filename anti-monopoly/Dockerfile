
FROM openjdk:17
LABEL authors="ottzoeke"

#################### old version ############################
#WORKDIR /anti-monopoly
# Kopiere die gebaute .jar-Datei aus deinem lokalen target-Verzeichnis in das Image
#COPY target/*.jar app.jar
# Exponiere den Port, auf dem dein Server läuft (z.B. 8080)
#EXPOSE 6666
# Starte die Anwendung
#CMD ["java", "-jar", "app.jar"]

######################### new version #########################
FROM maven:3.8.5-openjdk-17

WORKDIR /anti-monopoly
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run