#!/bin/bash

AWSCOMMAND="aws --profile yamaza"
APPLICATIONNAME="PlayDeployApp"
GROUPNAME="PlayDeployAppGroup"
BUCKETNAME="circleci-sample-bucket"
REGION="ap-northeast-1"
DIR="/path/to/your/deploy/dir/"
ZIPNAME="api-1.0.0.zip"

ETAG="efa37560756ee73917680ef3c0ebce86"

# S3にzipをpushする
#S3INFO=`${AWSCOMMAND} deploy push \
#          --application-name ${APPLICATIONNAME} \
#          --s3-location s3://${BUCKETNAME}/${ZIPNAME} \
#          --source ${DIR} \
#          --region ${REGION} | grep eTag`
#ETAG=`expr "${S3INFO}" : '.*eTag="\(.*\)"'`

echo ${S3INFO}
echo
echo ${ETAG}

# zipをEC2にデプロイする
${AWSCOMMAND} deploy create-deployment \
   --application-name ${APPLICATIONNAME} \
   --s3-location bucket=${BUCKETNAME},key=${ZIPNAME},bundleType=zip,eTag=${ETAG} \
   --deployment-group-name ${GROUPNAME} \
   --region ${REGION}
