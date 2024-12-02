#!/bin/sh
#
set -e

versiontag="0.4"
echo "start building backend quarkus"
cd ../../demoportal_be

./mvnw package -Dquarkus.package.type=legacy-jar -DskipTests

# build the image with tag
docker build -f src/main/docker/Dockerfile.legacy-jar -t demoportal-be:$versiontag . --platform linux/amd64

# Paolo
# After the build completes, tag your image so you can push the image to this repository
docker tag demoportal-be:$versiontag 444170698423.dkr.ecr.eu-west-1.amazonaws.com/demoportal-be:$versiontag
docker push 444170698423.dkr.ecr.eu-west-1.amazonaws.com/demoportal-be:$versiontag
echo "pushed demoportal backend on ECR AWS"

echo "end Building"

