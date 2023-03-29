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
				-f 04-kafka.yml \
				-p licencium-app \
				up -d
