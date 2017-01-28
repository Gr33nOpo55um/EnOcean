#!/usr/bin/env bash

sudo systemctl enable cronie

sudo systemctl start cronie


ssh-keygen
ssh-copy-id -i ~/.ssh/id_rsa.pub logger@192.168.1.45
ssh logger@192.168.1.45


rsync -a /opt/enoca/logs/telegrams.log logger@192.168.1.45:/var/log/enoca

(crontab -l 2>/dev/null; echo "* * * * * rsync -a /opt/enoca/logs/telegrams.log logger@192.168.1.45:/var/log/enoca/$HOSTNAME/ >/dev/null 2>&1")| crontab -
