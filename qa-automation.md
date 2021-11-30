## Demo Steps
### Graph QL
1. Component Test - Graph QL
2. Test Case Development - Infra
3. Database & Initial Data Load
4. Database UI
5. Test Case Development - BDD

### Cud API
1. Component Test - Rest API (CUD)
2. Test Case Development - BDD
3. Test Case Execution
4. Graph QL

## Commands - Graph QL
### Start database, database ui and graph ql api
```
docker compose -f graphql-test/docker-compose.yml up
docker compose -f graphql-test/docker-compose.yml down
```
### Database access

http://localhost:5050/
* **User :** admin@admin.com
* **Password :** root

### Graph QL UI
http://localhost:9200/graphiql
```
query {
      brand {
        name
        code
      }
    }
```
## Commands - Cud API
### Start database, database ui and graph ql api
```
docker compose -f cud-api-test/docker-compose.yml up
docker compose -f cud-api-test/docker-compose.yml down
```