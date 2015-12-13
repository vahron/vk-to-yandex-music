#!/bin/sh
mvn clean package
cp src/main/docker/Dockerfile target/
docker build -t com.pashkan/vk-to-yandex-music target
