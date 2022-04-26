# dp-j/lab-grafana

### Install and run Prometheus
```
$ docker pull prom/prometheus

$ docker run -d -p 9090:9090 -v C:/desenvolvimento/space/lab-grafana/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
```
Access http://localhost:9090

### Install and run Grafana
```
$ docker pull grafana/grafana

$ docker run -d -p 3000:3000 grafana/grafana
```
Access http://localhost:3000

## Getting Started

Download links:

SSH clone URL: ssh://git@git.jetbrains.space/my-projects/dp-j/lab-grafana.git

HTTPS clone URL: https://git.jetbrains.space/my-projects/dp-j/lab-grafana.git


These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites

What things you need to install the software and how to install them.

```
Examples
```

## Deployment

Add additional notes about how to deploy this on a production system.

## Resources

Add links to external resources for this project, such as CI server, bug tracker, etc.
