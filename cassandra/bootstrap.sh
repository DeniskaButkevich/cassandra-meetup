#!/bin/bash

#port and server should be passed as env variables
server=localhost
port=22
connection_timeout=5

check_ssh_connection() {
  timeout $connection_timeout bash -c "</dev/tcp/$server/$port"
  if [ $? == 0 ]; then
    echo "SSH Connection to $server over port $port is possible"
  else
    #todo add if check - if key already exists
    echo "Trying to establish SSH connection to $server over port $port"
    #start ssh
    sudo service ssh start
  fi
}

start_cassandra() {
  mkdir -p "${HOME}/.cassandra" &&
    sed -e "s/127.0.0.1/${HOSTNAME}/" /cassandra/conf/cqlshrc.sample >"${HOME}/.cassandra/cqlshrc"

  sed -i -e "s/127.0.0.1/${HOSTNAME}/" /cassandra/conf/cassandra.yaml

  sed -i "s/^listen_address: 127.0.0.1.*/listen_address: ${h}/" /cassandra/conf/cassandra.yaml
  sed -i "s/^broadcast_address: 127.0.0.1.*/broadcast_address: ${h}/" /cassandra/conf/cassandra.yaml
  sed -i "s/^broadcast_rpc_address: 127.0.0.1.*/broadcast_rpc_address: ${h}/" /cassandra/conf/cassandra.yaml

  ./service -c config.yaml &
  cassandra -R
}

check_ssh_connection
start_cassandra

tail -f /dev/null
