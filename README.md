In this folder run 'docker compose up' which will use the docker-compose.yml file to start postgresDB as docker container.

Then just start the spring boot application by running the ViewTRansactionApplication main class.

See the resources.properties for important configuration parameters.
to connect to postgress run below command
psql -U postgres -d postgres -h localhost -p 5433
password: postgres
