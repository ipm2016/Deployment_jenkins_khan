# Utiliser une image de base contenant Java 17
FROM adoptopenjdk/openjdk17:alpine

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/my_reactive_app.jar /app/my_reactive_app.jar

EXPOSE 9091

# Commande par défaut pour exécuter l'application lorsque le conteneur démarre
CMD ["java", "-jar", "my_reactive_app.jar"]
