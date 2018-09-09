#!/bin/bash
dir=$( cd "$( echo "${BASH_SOURCE[0]%/*}" )"; pwd )
kubectl delete secret springboot-swagger-example-server 
kubectl create secret generic springboot-swagger-example-server \
	--from-file $dir/../server/src/main/resources/application.yaml \
	--from-file $dir/../server/src/main/resources/application-dev.yaml \
	--from-file $dir/../server/src/main/resources/application-prod.yaml \
	--from-file $dir/../server/src/main/resources/logback-spring.xml		
kubectl delete -f $dir/springboot-swagger-example-server.yml
kubectl create -f $dir/springboot-swagger-example-server.yml