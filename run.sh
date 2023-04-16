#!/bin/bash

# Check if Maven is installed
if ! command -v mvn &> /dev/null
then
    echo "Maven is not installed. Please install Maven and try again."
    exit 1
fi

# Run the application using Maven
mvn spring-boot:run

