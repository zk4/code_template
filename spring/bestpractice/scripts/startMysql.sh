#!/bin/bash

docker rm -f bestpractice
docker run --detach \
	--name bestpractice \
	--env MYSQL_DATABASE=bestpractice \
	--env MYSQL_ROOT_PASSWORD=root \
	--env MYSQL_USER=root \
	--env MYSQL_PASSWORD= \
  -v `realpath .`/mysql:/var/lib/mysql \
	-p 3307:3306 \
	mysql:5.7 \
	--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
