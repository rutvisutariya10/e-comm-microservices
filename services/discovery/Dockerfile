# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-slim

# Install curl to fetch the wait-for-it script (if not already available)
RUN apt-get update && apt-get install -y curl

# Download the wait-for-it.sh script and make it executable
RUN curl -sLo /usr/local/bin/wait-for-it.sh https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh && \
    chmod +x /usr/local/bin/wait-for-it.sh

# Copy the JAR file to the container
ADD target/discovery-0.0.1-SNAPSHOT.jar discovery-0.0.1-SNAPSHOT.jar

# Specify the default command to wait for the dependent service and then start the Spring Boot application
CMD ["/usr/local/bin/wait-for-it.sh", "config-server:8889", "--", "java", "-jar", "discovery-0.0.1-SNAPSHOT.jar"]
