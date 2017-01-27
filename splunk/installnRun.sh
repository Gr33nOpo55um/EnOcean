#!/usr/bin/env bash

# first you need a fully working docker environment

docker pull splunk/splunk

docker run -d -e "SPLUNK_START_ARGS=--accept-license" -e "SPLUNK_USER=root" -p "8000:8000" -v /var/log/enoca:/mnt/enoca splunk/splunk