# Development tips

## Build and debug 
Go to src/demoportal_fe folder.
You can start your project by running the command: 

npm start 


Run mvn quarkus:dev command to start live coding and debug


# Deploy in local pc kube environment
Mandatory requirements:
- k3s or minikube installed
- helm installed

Please follow these steps (see paragraphs for more information):
- Build local helm artifact
- Generate docker image locally
- Install as helm chart

## Build local helm artifact
To compile locally please run this command "from the git repo root"

### Linux/Mac
docker run --rm -e ARTIFACTORY_MAVEN_M2_FILE=/root/.m2/settings.xml -v $(pwd):/src -v ~/.m2:/root/.m2 --entrypoint bash -w /src integrazione.mgmt.infocert.it/docker-remote/maven:3.6.3-openjdk-11-slim -c ./build_script.sh
### Windows
TODO (same command as linux but $(pwd)=??? and ~=???)

The command creates locally to you (in the containers/dp_quarkus_api folder) the java artifacts.

## Generate docker image locally
After the build, please run:

docker build containers/dp-quarkus-be -f containers/dp-quarkus-be/Dockerfile -t dp-quarkus-be:0.1.0

docker build containers/dp-angular-ui -f containers/dp-angular-ui/Dockerfile -t dp-angular-ui:0.1.0

## Install as helm chart
helm install dp_quarkus_api infrastructure/helm --values infrastructure/helm/values/local.yaml

## Clean local java target
### Linux/Mac
docker run --rm -v $(pwd):/src -v ~/.m2:/root/.m2 --entrypoint bash -w /src integrazione.mgmt.infocert.it/docker-remote/maven:3.6.3-openjdk-11-slim -c "cd src/preenrollmentsvc;mvn clean"
### Windows
TODO (same command as linux but $(pwd)=??? and ~=???)

## Clean local artifacts
### Linux/Mac
rm -rf containers/dp_quarkus_api/app

rm -rf containers/dp_quarkus_api/lib

rm -rf containers/dp_quarkus_api/quarkus

rm -rf containers/dp_quarkus_api/quarkus-run.jar
### Linux/Mac
rmdir /s /Q containers/dp_quarkus_api/app

rmdir /s /Q containers/dp_quarkus_api/lib

rmdir /s /Q containers/dp_quarkus_api/quarkus

del /f containers/dp_quarkus_api/quarkus-run.jar