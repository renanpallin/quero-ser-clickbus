# Project
This is a repository to make me a Click Bus Back End Developer

## Running the project
@todo
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

## Dependencies
This project uses Gradle to manage code dependencies.
 - Spring Boot
 - Spring Data
 - Hibernate
 - Mysql
 - Docker (to use containers)
 - Docker Compose (to use containers)

## Author
Renan Pallin \<renanpallin@gmail.com\>
