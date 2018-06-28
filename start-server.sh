#!/bin/sh

mvn clean install package spring-boot:repackage

nohup java -jar target/spring0to1.jar --spring.profiles.active=dev > /dev/null 2>&1 &

#sleep 5
#echo $! > tpid

echo Start Success!
