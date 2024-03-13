Instructions
Open the project with Intellij
create a database and configure the name in the application.properties

run mvn clean install to install the maven dependencies

Run the project using intellij


Create a user using the below apis:

UserController
This controller handles all operations related to User entities.

POST /register
Registers a new user.

Request Body: A User object.

JSON

{
"username": "string",
"password": "string"
}


Response: The registered User object.

POST /login
Logs in a user.

Request Body: A User object.

JSON

{
"username": "string",
"password": "string"
}


Response: The logged in User object.

GET /{id}
Retrieves a user by their ID.

Path Variable: id - The ID of the user to retrieve.

Response: The User object with the specified ID.

PUT /{id}
Updates an existing user.

Path Variable: id - The ID of the user to update.

Request Body: A User object with the updated information.

JSON

{
"username": "string",
"password": "string"
}

Response: The updated User object.

DELETE /{id}
Deletes a user by their ID.

Path Variable: id - The ID of the user to delete.

Response: No content.

Create and Manage an Event using the below APIs



POST /api/events/
Creates a new event.

Request Body: An Event object.

JSON

{
"title": "string",
"description": "string",
"date": "yyyy-mm-dd",
"time": "hh:mm:ss",
"user": {
"id": long
}
}

Response: The created Event object.

GET /api/events/{id}
Retrieves an event by its ID.

Path Variable: id - The ID of the event to retrieve.

Response: The Event object with the specified ID.

PUT /api/events/{id}
Updates an existing event.

Path Variable: id - The ID of the event to update.

Request Body: An Event object with the updated information.

JSON

{
"title": "string",
"description": "string",
"date": "yyyy-mm-dd",
"time": "hh:mm:ss",
"user": {
"id": long
}
}

Response: The updated Event object.

DELETE /api/events/{id}
Deletes an event by its ID.

Path Variable: id - The ID of the event to delete.

Response: No content.
