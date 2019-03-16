#! /usr/bin/env bash

mvn clean package -DskipTests -U

docker build -t registry.cn-shenzhen.aliyuncs.com/deserttown/product:latest .

docker push registry.cn-shenzhen.aliyuncs.com/deserttown/product:latest