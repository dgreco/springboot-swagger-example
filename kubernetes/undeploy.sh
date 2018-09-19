#!/bin/bash
dir=$( cd "$( echo "${BASH_SOURCE[0]%/*}" )"; pwd )
kubectl delete secret springboot-swagger-example-server 
kubectl delete -f $dir/springboot-swagger-example-server.yml

kubectl delete secret springboot-swagger-example-admin-server
kubectl delete -f $dir/springboot-swagger-example-admin-server.yml
