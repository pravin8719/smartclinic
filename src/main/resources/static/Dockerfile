# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set workdir
WORKDIR /app

# Copy everything
COPY . /app

# Build the project (adjust to your build tool)
RUN ./gradlew build

# Run the jar file (adjust jar name)
CMD ["java", "-jar", "build/libs/smartclinic-0.0.1-SNAPSHOT.jar"]
