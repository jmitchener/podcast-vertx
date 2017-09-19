# Podcast Server

Personal podcast manager and player

# Getting started

    ./gradlew clean shadowJar && ./build/libs/podcast-vertx-all.jar

# Configuration

All configuration should be kept to environment variables for ease of containerization.

Current environment vars:

`JCM_PODCAST_HTTP_PORT` http port (default 9999)
