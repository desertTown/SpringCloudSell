#! /usr/bin/env bash

mvn clean package -DskipTests -U

docker build -t hub.c.163.com/springcloud/config .

docker push hub.c.163.com/spring/config