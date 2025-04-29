In this folder run 'docker compose up' which will use the docker-compose.yml file to start postgresDB as docker container.

Then just start the spring boot application by running the ViewTRansactionApplication main class.

See the resources.properties for important configuration parameters.
to connect to postgress run below command
psql -U postgres -d postgres -h localhost -p 5433
password: postgres

mysql -h 127.0.0.1 -P 3306 -u root -p
password: tmsroot

show databases
USE mysql_tms_ti;

SHOW TABLES;
show databases;
DESCRIBE transaction;

`docker build -t viewTRansaction:4 .``
`docker tag viewTRansaction:4 bikashhasmobile/view_transaction:2.0.0`
`docker push bikashhasmobile/view_transaction:3.0.0`
