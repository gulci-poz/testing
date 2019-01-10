#!/bin/sh
mv Dockerfile Dockerfile_temp
mv Dockerfile_fat Dockerfile
mvn clean package
java -jar payara-micro-5.184.jar --port 8080 --deploy target/testing.war --outputUberJar target/testing_fat.jar
docker build --force-rm -t pl.gulci/testing_fat .
docker rm -f testing_fat || true && docker run -d -p 8080:8080 --name testing_fat pl.gulci/testing_fat
mv Dockerfile Dockerfile_fat
mv Dockerfile_temp Dockerfile
rm target/testing_fat.jar || true
