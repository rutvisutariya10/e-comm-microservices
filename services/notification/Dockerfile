# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-slim

# Install curl to fetch the wait-for-it script (if not already available)
RUN apt-get update && apt-get install -y curl

# Download the wait-for-it.sh script and make it executable
RUN curl -sLo /usr/local/bin/wait-for-it.sh https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh && \
    chmod +x /usr/local/bin/wait-for-it.sh

# Copy the JAR file to the container
ADD target/notification-0.0.1-SNAPSHOT.jar notification-0.0.1-SNAPSHOT.jar

# Run the application
CMD ["/usr/local/bin/wait-for-it.sh", "discovery:8761", "--", "java", "-jar", "notification-0.0.1-SNAPSHOT.jar"]