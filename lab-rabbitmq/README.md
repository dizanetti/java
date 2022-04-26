# lab-rabbitmq

## Getting Started

Download links:

https://github.com/dizanetti/java

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites

What things you need to install the software and how to install them.

```
docker pull rabbitmq
docker run -d --hostname local-rabbit --name rabbit-mq -p 15672:15672 -p 5672:5672 rabbitmq:3.9.7-management              
```

## Deployment

Add additional notes about how to deploy this on a production system.

## Resources

Add links to external resources for this project, such as CI server, bug tracker, etc.
