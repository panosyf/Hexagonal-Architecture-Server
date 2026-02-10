#!/bin/bash

set -e

echo "Building all modules..."
#mvn clean install -DskipTests
./mvnw clean install -DskipTests

echo ""
echo "Starting application..."
cd app
#mvn spring-boot:run -Dspring-boot.run.profiles=local
.././mvnw spring-boot:run -Dspring-boot.run.profiles=local