#!/bin/bash

echo '#########################################################'
echo '#########################################################'
echo 'Creacion de la red para todos los contenedos "licencia-net"'
echo '#########################################################'
echo '#########################################################'

docker network create --driver=bridge --subnet=172.20.0.1/16 licencia-net
