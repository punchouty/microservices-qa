# Set up 
## Environment 
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
