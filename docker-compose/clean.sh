#!/bin/bash

echo '###############################################################'
echo 'Eliminacion de la red para todos los contenedos "licencium-net"'
echo '###############################################################'

docker network rm licencium-net

echo '###########################################################'
echo 'Creacion del stack de contenedores"'
echo '###########################################################'

docker-compose -f 01-pg-usuario.yml \
				-f 02-pg-cliente.yml \
				-f 03-pg-licencia.yml \
				down
