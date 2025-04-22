Settingscores REST API
This project is a RESTful API built using Spring Boot, designed to manage and manipulate a score object. The application provides endpoints for performing CRUD (Create, Read, Update, Delete) operations on the score object, as well as additional utility endpoints for specific use cases. It is a lightweight and scalable solution that does not rely on a database, instead using an in-memory static object to store the score data.


Features
Spring Boot Framework: Utilizes Spring Boot for rapid development and deployment of RESTful services.
RESTful Endpoints: Provides a variety of HTTP methods (GET, POST, PUT, PATCH, DELETE) to interact with the score object.
Cross-Origin Resource Sharing (CORS): Enabled to allow cross-origin requests.
Dynamic Path Variables: Supports dynamic retrieval and updates of specific fields (e.g., wins, losses, ties) using path variables.
Client Information Retrieval: Includes an endpoint to fetch client details such as IP address and session information.
Health Check Endpoint: A simple endpoint to verify the application is running.
Technologies Used
Java: The primary programming language for the application.
Spring Boot: A framework for building RESTful APIs with minimal configuration.
Maven: Used for dependency management and project build.
Jakarta Servlet API: For handling HTTP requests and sessions.
Endpoints Overview
GET /score: Retrieve the current score object.
PUT /score: Replace the entire score object with a new one.
DELETE /score: Delete the current score object (sets it to null).
PATCH /score/wins: Update the wins field using a query parameter.
GET /score/{winslossesties}: Retrieve the value of wins, losses, or ties dynamically.
POST /score/{increase}: Increment the value of wins, losses, or ties.
GET /info: Retrieve client information such as IP address and session details.
GET /: A health check endpoint to confirm the application is running.
How to Run
Clone the repository to your local machine.
Ensure you have Java 17 or higher and Maven installed.
Navigate to the project directory and run the following command to start the application:
mvn spring-boot:run
The application will start on http://localhost:8080.
Example Usage
Retrieve the current score:
curl -X GET http://localhost:8080/score
Update the wins field:
curl -X PATCH "http://localhost:8080/score/wins?new-value=50"
Increment the ties field:
curl -X POST http://localhost:8080/score/ties
