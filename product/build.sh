#! /usr/bin/env bash

mvn clean package -DskipTests -U

docker build -t registry.cn-shenzhen.aliyuncs.com/messi/product:latest .

docker push registry.cn-shenzhen.aliyuncs.com/messi/product:latest