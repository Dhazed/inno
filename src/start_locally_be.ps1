# Navigate to the postgresql directory
Set-Location -Path "./postgresql"

# Start PostgreSQL and Adminer using Docker Compose
Write-Output "start postgres on localhost:5432/demoportal_schema"
Write-Output "and adminer on http://localhost:9080"
docker-compose up -d
Write-Output "docker compose running up"

# Navigate to the demoportal_be directory
Set-Location -Path "../demoportal_be"

# Run the Maven command using the Windows environment
Start-Process -FilePath "./mvnw" -ArgumentList "compile quarkus:dev -DskipTests -Duser.timezone=UTC"