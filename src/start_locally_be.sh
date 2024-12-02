cd ./postgresql
echo "start postgres on localhost:5432/demoportal_schema"
echo "and adminer on http://localhost:9080" 
docker compose up -d 
echo " docker compose runnig up"
cd ../demoportal_be
./mvnw compile quarkus:dev -DskipTests