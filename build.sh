#!/bin/bash

# Check if Maven is installed
if ! command -v mvn &> /dev/null
then
    echo "Maven is not installed. Please install Maven and try again."
    exit 1
fi

# Build the project using Maven
mvn clean install

# Check if the build was successful
if [ $? -eq 0 ]; then
    echo "Build successful."
else
    echo "Build failed. Please check the error messages."
    exit 1
fi

