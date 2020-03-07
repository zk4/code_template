#!/bin/bash
docker rm -f rabbit
docker run -d  --name rabbit --hostname rabbit -p 15671:15671 -p 15672:15672 -p 5672:5672  rabbitmq:3-management
