#!/bin/bash

# Set the current directory to the project root directory
cd "$(dirname "$0")"

# Create the build directory if it doesn't exist
mkdir -p build

# Compile all Java files in the src directory and its subdirectories
find src -name "*.java" -print0 | xargs -0 javac -d build

# Create a JAR file for the compiled classes
jar cvf sequencer_multicast_project.jar -C build .
