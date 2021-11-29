# Set up 
## CI/CD Flow
![CI/CD Flow](docs/cicd-flow.png)

## Cud-api
```
cd <project root>
docker image ls 
docker image rm cud-api:0.1 # if exists
mvn clean install
docker build -t cud-api:0.1 ./cud-api/
```
### Run
#### Development environment
```
docker compose -f cud-api/docker-compose.yml up
docker compose -f cud-api/docker-compose.yml down
```
URL 
* http://localhost:9100/locations - GET
* http://localhost:9100/brands - GET
* http://localhost:9100/brands - POST
```json
{
    "name" :  "Avis",
    "code" : "AVS"
}
```
#### Test environment
```
docker compose -f cud-api-test/src/test/resources/docker-compose.yaml up
docker compose -f cud-api-test/src/test/resources/docker-compose.yaml down
```
## GraphQL
```
cd <project root>
docker image ls
docker image rm graphql:0.1 # if exists
mvn clean install
docker build -t graphql:0.1 ./graphql/
```
### Run
#### Test environment
```
docker compose -f graphql-test/docker-compose.yml up
docker compose -f graphql-test/docker-compose.yml down
```

## Sample All Environment
### Start kafka, zookeeper, postgres, pgadmin
```
docker compose up
```
To check kafka - go to bin folder of kafka installation
```
./kafka-topics.sh --bootstrap-server localhost:19092 --list
```
To check postgres and pgadmin Go to http://localhost:5050/
* **User :** admin@admin.com
* **Password :** root








































```
Go to http://localhost:5050/
* **User :** admin@admin.com
* **Password :** root
* http://localhost:9200/graphiql
* http://localhost:9200/voyager
