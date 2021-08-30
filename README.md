# Person Management
## Description

Kata to manage persons and their addresses

### Pre-requisites

- Java 11
- PostgreSQL launched
- Create database :
    - run on terminal "psql -U postgres -h localhost -W" (password : postgres)
    - "create database personmanagement;"
- Launch the "PersonManagementApplication" via your IDE

### Examples of use (with Postman)

- Create new person : POST http://localhost:8080/api/person with a JSON body like this : {
                                                                                       "firstName": "myFirstName",
                                                                                       "lastName": "myLastName"
                                                                                       }
- Count number of person : GET http://localhost:8080/api/person/count

- Create an address associated to the person of id = 1 : POST http://localhost:8080/api/address/1 with a JSON body : {
                                                                                                                     "street": "myStreet",
                                                                                                                     "city": "myCity",
                                                                                                                     "state": "myState",
                                                                                                                     "postalCode": "45875"
                                                                                                                     }

- Delete the address with id = 1 : DELETE http://localhost:8080/api/address/1