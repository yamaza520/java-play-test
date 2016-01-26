#!/bin/bash
echo "appspec BeforeInstall"

# delete backup
rm -rf /var/play/before_api

# backup
mv /var/play/api /var/play/before_api
mv /var/play/api-* /var/play/api
