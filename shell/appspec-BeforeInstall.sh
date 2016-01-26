#!/bin/bash
echo "appspec BeforeInstall"

# delete backup
if [ -e /var/play/before_api ]; then
    rm -rf /var/play/before_api
fi

# backup
if [ -e /var/play/api ]; then
    mv /var/play/api /var/play/before_api
fi
