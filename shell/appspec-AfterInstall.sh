#!/bin/bash
echo "appspec AfterInstall"

# rename
mv /var/play/api-* /var/play/api
chown -R rl_app:wheel /var/play/
