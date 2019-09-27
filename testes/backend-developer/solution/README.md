# Project
This is a repository to make me a Click Bus Back End Developer

## Dependencies
This project uses Gradle to manage code dependencies.
 - Spring Boot
 - Spring Data
 - Hibernate
 - Mysql
 - Java 8
 - Docker (to use containers)
 - Docker Compose (to use containers)

## Running the project
Once the dependencies is installed, it is possible to run the project.

First, build the project with the following command in the root directory:

`./gradlew build`

This will generate the jar artifact inside `build/libs` directory.

Run the following command to start two docker containers, one for mysql database and another for the application:

`docker-compose up` 

The app should now be running at port 8080 and you can perform some http request.

## Tests 
@todo

## Models
### Place
Represents a place and have the following fields:

| Field     | Java Type     | JSON Type | Description                         |
|-----------|---------------|-----------|-------------------------------------|
| id        | Long          | Number    | Unique identifier and primary key   |
| name      | String        | String    | Name of the place                   |
| slug      | String        | String    | Place's slug (E.g. my-awsome-place) |
| city      | String        | String    | Place's city                        |
| state     | String        | String    | Place's state                       |
| createdAt | LocalDateTime | String    | Place's creation time               |
| updatedAt | LocalDateTime | String    | Place's last updated time           |

## Endpoints
The project follow the REST convention with all the requests and responses in JSON.

| Method    | Endpoint                  | Description                                                                                                                                    |
|-----------|---------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| GET       | /place[?query=nameFilter] | List all places. Accepts an optional `query` param with filters places by name                                                                 |
| GET       | /place/:id                | Returns a place by given :id. 404 response code is given when place not found                                                                  |
| POST      | /place                    | Create a place with given body json. E.g.: {     "name": "Click Bus",     "slug": "click-bus",     "city": "São paulo",     "state": "Sampa" } |
| PUT       | /place/:id                | Replace the existing place with new values provided in body.                                                                                   |
| DELETE    | /place/:id                | Delete a place by its :id                                                                                                                      |

## Architecture
This is a Spring Boot application with uses MySql database.
It is possible to identify some well known design patterns, like MVC and Repository.
Since REST convention was used, the http statuses on the responses has its meaning.

## Author
Renan Pallin \<renanpallin@gmail.com\>
