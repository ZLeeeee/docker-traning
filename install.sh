#!/usr/bin/env bash

cd -
cd docker-compose

echo '================== start redis ================='
docker-compose -f docker-compose.yml up -d redis
echo '================== start nginx ================='
docker-compose -f docker-compose.yml up -d nginx
echo '================== build demo =================='
cd -
mvn package
docker build -f Dockerfile -t demo:latest .
cd docker-compose
echo '================== start demo ================='
docker-compose -f docker-compose.yml up -d demo

cd -
