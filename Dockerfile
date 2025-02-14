# Etapa 1: Construção do projeto
FROM sapmachine:21-jdk-alpine
WORKDIR /app

# Copy api files from project to container image
COPY . .

# Compile application
RUN chmod 775 ./gradlew && ./gradlew build --no-daemon -x test

# Expose the port that will be used by the API
EXPOSE 8080

# Command to initiate the api - For some reason commented out because not worked. It's necessary to run another container with the image created, exec the container with /bin/sh and then execute "$ java -jar /app/build/libs/*.jar"
CMD ["java", "-jar", "/app/build/libs/*.jar"]
#CMD ["/bin/sh", "-c" ,"'java -jar /app/build/libs/*.jar'"]
#CMD ["jshell", "java", "-jar", "/app/build/libs/*.jar"]