#!/usr/bin/env bash

  systemctl enable cronie

sudo systemctl start cronie


ssh-keygen
ssh-copy-id -i ~/.ssh/id_rsa.pub logger@192.168.1.45
ssh logger@192.168.1.45


rsync /opt/enoca/logs/telegrams.log logger@192.168.1.45:/var/log/enoca

(crontab -l 2>/dev/null; echo "* * * * * rsync /opt/enoca/logs/telegrams.log logger@192.168.1.45:/var/log/enoca/$HOSTNAME/ >/dev/null 2>&1")| crontab -
