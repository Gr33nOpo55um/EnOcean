#!/bin/bash


# Follow this guide: https://archlinuxarm.org/platforms/armv8/broadcom/raspberry-pi-3


# install java,

#ExecStart=/usr/bin/java -jar /home/pruss/dev/ServerDeploy5-4.1/Server/resources/MyServer.jar

if [[ $EUID -ne 0 ]]; then
  echo "You must be a root user" 2>&1
  exit 1
else

  cat configFiles/yaourt >> /etc/pacman.conf


  pacman -Sy --noconfirm yaourt sudo vim


  echo '%wheel      ALL=(ALL) ALL' >> /etc/sudoers
  echo 'Defaults:alarm      !authenticate' >> /etc/sudoers

  gpasswd --add alarm wheel

  mkdir /opt/enoca
  cp configFiles/enoca.sh /opt/enoca/enoca.sh

  chmod u+x /opt/enoca/enoca.sh

  cp configFiles/enoca.service  /usr/lib/systemd/system/enoca.service

  systemctl daemon-reload
  systemctl start enoca.service
  systemctl enable enoca.service


fi

su alarm
yaourt -Syua --noconfirm jre

echo "Installation successful";
