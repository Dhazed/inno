#!/bin/bash
echo "Executing build_script.sh demo portal project"
# compile quarkus backend
cd src/demoportal_be || exit 2
echo "start compile quarkus backend"
./mvnw package -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -B -V
cp -r target ../../containers/demoportal_be
#for the moment copied the precopiled version
echo "end compile backend"

## back to root
cd ../..
# compile angular frontend
echo "compile angular front end"
cd src/demoportal_fe || exit 5
yum -y install nodejs
yum -y install npm
npm install -g @angular/cli
npm update
ng update @angular/cli @angular/core --allow-dirty --force
ng build  --base-href /demoportal/ --deploy-url /demoportal/
echo "end angular front end"
cp -r dist ../../containers/demoportal_fe