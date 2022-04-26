# lab-docker-image

## Getting Started

Download links:

https://github.com/dizanetti/java

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites

What things you need to install the software and how to install them.

```
- Java 11
- Maven
- Docker
```

## Deployment

To generate a JAR file and create an image docker run: `mvn spring-boot:build-image` and `docker run -d --name lab-docker-image -p 8080:8080 lab-docker-image:0.0.1-SNAPSHOT`.
