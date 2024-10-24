# start BE with docker
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t demoportal_be_jvm .
docker run -i --rm -p 8080:8080 demoportal_be_jvm