#!/bin/bash

echo "Executing build_script.sh demo portal project"

# compile quarkus backend

cd src/demoportal_be || exit 2
echo "compile quarkus backend"
./mvnw package
cp -r target/ ../../containers/demoportal_be/target

## back to root
cd ../..
# compile angular frontend
echo "compile angular front end"
cd src/demoportal_fe || exit 5
ng build  --base-href /demoportal/ --deploy-url /demoportal/
cp -r dist ../../containers/demoportal_fe