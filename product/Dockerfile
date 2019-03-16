FROM  hub.c.163.com/library/java:8-alpine

MAINTAINER  DESERTTOWN  13631260372@163.com

ADD product_server/target/*.jar app.jar

EXPOSE 8762

ENTRYPOINT ["java", "-jar", "/app.jar"]