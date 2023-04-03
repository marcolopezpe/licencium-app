#!/bin/bash

echo '###########################################################'
echo 'Eliminacion del stack de contenedores"'
echo '###########################################################'

docker-compose -f 01-pg-usuario.yml \
				-f 02-pg-cliente.yml \
				-f 03-pg-licencia.yml \
				-f 04-kafka-server.yml \
				-f 05-mongo-audit.yml \
				-f 06-zipkin-server.yml \
				-f 07-grafana-prometheus.yml \
				-p licencium-app \
				down

echo '###############################################################'
echo 'Eliminacion de la red para todos los contenedos "licencium-net"'
echo '###############################################################'

docker network rm licencium-net
