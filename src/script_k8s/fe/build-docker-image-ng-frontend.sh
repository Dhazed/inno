#!/bin/sh
#
set -e

versiontag="0.19"
echo "start building frontend angular"
cd ../../demoportal_fe
docker build -t demoportal-fe:$versiontag . --platform linux/amd64


# Paolo
# After the build completes, tag your image so you can push the image to this repository
docker tag demoportal-fe:$versiontag 444170698423.dkr.ecr.eu-west-1.amazonaws.com/demoportal-fe:$versiontag
docker push 444170698423.dkr.ecr.eu-west-1.amazonaws.com/demoportal-fe:$versiontag
echo "pushed demoportal angular fe"

echo "end Building"

