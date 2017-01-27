#!/bin/bash


# Follow this guide: https://archlinuxarm.org/platforms/armv8/broadcom/raspberry-pi-3

# place the linux folder in alarm's home dir
# move current jar to linux/configFiles/
# chmod +x install.sh
# run this script as root


if [[ $EUID -ne 0 ]]; then
  echo "You must be a root user" 2>&1
  exit 1
else

timedatectl set-timezone Europe/Zurich

 pacman -Syu --noconfirm htop base-devel java-rxtx yajl jre8-openjdk vim wget sudo rsync cronie

  echo '%wheel      ALL=(ALL) ALL' >> /etc/sudoers
  echo 'Defaults:alarm      !authenticate' >> /etc/sudoers

  gpasswd --add alarm wheel




  mkdir -p /opt/enoca


  cd /home/alarm/linux

  cp configFiles/EnOcean.jar /opt/enoca/

  chown -R alarm /opt/enoca

  cp configFiles/enoca.service  /usr/lib/systemd/system/enoca.service

  systemctl daemon-reload
  systemctl enable enoca.service

  reboot

fi


echo "Installation successful";
exit 0
