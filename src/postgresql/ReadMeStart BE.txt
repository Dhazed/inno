#Principali comandi per l'esecuzione in locale 

#con il seguente comando eseguito in questa directory 
# si creano e/o si startano il db postgres e il BE container
# sulle porte 
#    Quarkus     -> 8080
#    Postgres    -> 5432
# gli schema e i dati vengono persistiti sull'host nella direcory ./pgdata

docker-compose -f docker-compose.yml up

