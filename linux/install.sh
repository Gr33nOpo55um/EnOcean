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

 pacman -Syu --noconfirm htop base-devel java-rxtx yajl jre8-openjdk vim wget sudo rsync

  echo '%wheel      ALL=(ALL) ALL' >> /etc/sudoers
  echo 'Defaults:alarm      !authenticate' >> /etc/sudoers

  gpasswd --add alarm wheel

  su alarm &&  mkdir -p ~/temp/AUR/ && cd ~/temp/AUR/
  wget https://aur.archlinux.org/cgit/aur.git/snapshot/package-query.tar.gz  # download source tarbal
  tar xfz package-query.tar.gz  # unpack tarball

  cd package-query  &&  makepkg  # cd and create package from source

  sudo pacman -U --noconfirm package-query*.pkg.tar.xz  # install package - need root privileges


  cd ..

  wget https://aur.archlinux.org/cgit/aur.git/snapshot/yaourt.tar.gz
  tar xzf yaourt.tar.gz
  cd yaourt  &&  makepkg
  sudo pacman -U yaourt*.pkg.tar.xz



  sudo mkdir -p /opt/enoca

  sudo chown -R alarm /opt/enoca

  cd /home/alarm/linux

  cp configFiles/EnOcean.jar /opt/enoca/

  sudo cp configFiles/enoca.service  /usr/lib/systemd/system/enoca.service

  sudo systemctl daemon-reload
  sudo systemctl start enoca.service
  sudo systemctl enable enoca.service


fi


echo "Installation successful";
exit 0
