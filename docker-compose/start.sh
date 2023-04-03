#!/bin/bash

echo '###########################################################'
echo 'Creacion de la red para todos los contenedos "licencium-net"'
echo '###########################################################'

docker network create --driver=bridge --subnet=172.20.0.1/16 licencium-net

echo '###########################################################'
echo 'Creacion del stack de contenedores"'
echo '###########################################################'

docker-compose -f 01-pg-usuario.yml \
				-f 02-pg-cliente.yml \
				-f 03-pg-licencia.yml \
				-f 04-kafka-server.yml \
				-f 05-mongo-audit.yml \
				-f 06-zipkin-server.yml \
				-f 07-grafana-prometheus.yml \
				-p licencium-app \
				up -d

echo '###########################################################'
echo 'Creacion de los topicos de kafka"'
echo '###########################################################'

docker exec -it kafka01 kafka-topics --bootstrap-server localhost:9092 --create --topic usuarios --partitions 3 --replication-factor 2
docker exec -it kafka01 kafka-topics --bootstrap-server localhost:9092 --create --topic clientes --partitions 3 --replication-factor 2
docker exec -it kafka01 kafka-topics --bootstrap-server localhost:9092 --create --topic licencias --partitions 3 --replication-factor 2
