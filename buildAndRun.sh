#!/bin/sh
mvn clean package && docker build --force-rm -t pl.gulci/testing .
docker rm -f testing || true && docker run -d -p 8080:8080 --name testing pl.gulci/testing
