#!/bin/bash

echo '###########################################################'
echo 'Eliminacion del stack de contenedores"'
echo '###########################################################'

docker-compose -f 01-pg-usuario.yml \
				-f 02-pg-cliente.yml \
				-f 03-pg-licencia.yml \
				-f 04-kafka.yml \
				-p licencium-app \
				down

echo '###############################################################'
echo 'Eliminacion de la red para todos los contenedos "licencium-net"'
echo '###############################################################'

docker network rm licencium-net
