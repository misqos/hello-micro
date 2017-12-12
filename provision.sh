#!/bin/bash
export DEBIAN_FRONTEND=noninteractive

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable edge"
sudo apt-get update
# sudo apt-get install linux-image-extra-$(uname -r) linux-image-extra-virtual -y
sudo apt-get install docker-ce --force-yes -y
sudo printf '{\n\t"experimental": true\n}' > /etc/docker/daemon.json
sudo usermod -aG docker ubuntu
sudo service docker restart
docker version
