#!/bin/bash


# Follow this guide: https://archlinuxarm.org/platforms/armv8/broadcom/raspberry-pi-3


# install java,

#ExecStart=/usr/bin/java -jar /home/pruss/dev/ServerDeploy5-4.1/Server/resources/MyServer.jar

chmod u+x /home/yourscript.sh

systemctl daemon-reload
systemctl start enoca.service
systemctl enable enoca.service
