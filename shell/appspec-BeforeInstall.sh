#!/bin/bash
echo "appspec BeforeInstall"

mv /var/play/api /var/play/before_api
mv /var/play/api-* /var/play/api

