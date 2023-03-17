<p align="center">
<img src="images/blog-app.png">
<p>

Project description
-

### This application is based on Spring Boot frameworks. <br /> The app allows users to register and write an article . <br /> Blog-app supports authentication and authorization with JWT-token. <br /> CRUD operations are implemented in application

## API:

**Authorization you can:**
- Write an article
- Get all Users with age greater than some value
- Get all Users with Articles where color is some specific value from enum
- Get unique name from Users with more than 3 Articles

**Without authorization, you can:**
- Register
- Log in
- Get access to the database if you know the password :)

## Instructions for testing the application.
- At the start of the application, 5-10 random Users from Articles will be added to the database.
- To access them, you need to
  - Send a POST request to http://localhost:8080/register <br />
    with a JSON object, for example {"username": "User", "password": "1234"}
  - The next step is to log in. Send a POST request to http://localhost:8080/login <br />
    with the same JSON object, for example {"username": "User", "password": "1234"}
  - In response, you will receive a token that you need to place in Authorization -> Bearer Token.<br />
    After that, you can send GET requests.
- Get all Users whose age is greater than some value <br />
  http://localhost:8080/users/getAllByAgeAfter?age=33 (33 is the age, it can be changed)
- Get all Users with Articles in which color is a certain value from the enum <br />
  http://localhost:8080/users/getAllByArticleColor?color=BLUE (BLUE is the color, it can be changed)
- Get unique name from Users with more than 3 Articles <br />
  http://localhost:8080/users/getUsersWithUniqueName
- Add a new article, you need to send a POST request <br />
  http://localhost:8080/users/addArticle?userId=1&text=new-post&color=BLUE (User id, text and color, can be changed )
- Access to the database <br />
  http://localhost:8080/h2-console (password: sa - you can change it in application.properties)
- In addition to adding a User via a POST-request, you can use Postman 
  example JSON for this<br />
  { "name": "Nina", "age": 18, <br />
  "articles": <br />
  [ { "text": "Article 0", "color": "BLUE" }, <br />
  { "text": "Article 1", "color": "GREEN" }, <br />
  { "text": "Article 2", "color": "PURPLE" }, <br />
  { "text": "Article 3", "color": "PURPLE" }, <br />
  { "text": "Article 4", "color": "BLUE" } ] <br />
  } <br />
  http://localhost:8080/users/save

## Technologies
- Java 8
- Apache Maven 3.8.1
- h2 in memory database
- Spring 
    - Boot
    - Security
    - Web MVC
    - JWT
    - Test

