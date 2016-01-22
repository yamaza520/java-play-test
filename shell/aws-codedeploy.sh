#!/bin/bash
echo "deploy start api"

BUILD=`grep  _version ../project/Build.scala`
VERSION=`expr "${BUILD}" : '.*_version = "\([0-9\.]*\)"'`
ZIPNAME="api-${VERSION}.zip"
echo "version=${VERSION}"

AWSCOMMAND="aws --profile yamaza"
APPLICATIONNAME="PlayDeployApp"
GROUPNAME="PlayDeployAppGroup"
BUCKETNAME="circleci-sample-bucket"
REGION="ap-northeast-1"
DIR="/path/to/your/deploy/dir/"

# get s3 file etag
S3INFO=`${AWSCOMMAND} s3api head-object \
           --bucket ${BUCKETNAME} \
           --key ${ZIPNAME}`
ETAG=`expr "${S3INFO}" : '.*"ETag": "."\(.*\)."",'`
echo "get S3 info"
echo ${S3INFO}

# deploy EC2 (call CodeDeploy)
echo ""
echo "start deploy"
${AWSCOMMAND} deploy create-deployment \
   --application-name ${APPLICATIONNAME} \
   --s3-location bucket=${BUCKETNAME},key=${ZIPNAME},bundleType=zip,eTag=${ETAG} \
   --deployment-group-name ${GROUPNAME} \
   --region ${REGION}
