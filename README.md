# Drawn Together (Backend)

### NOTE:
*This is a Springboot backend for my 'Drawn Together' project and requires access to the [Frontend](https://github.com/TimBroderick44/Drawn-Together-Frontend) and the [Websocket Server](https://github.com/TimBroderick44/Drawn-Together-Websocket-Server).

This is a simple backend that allows for authentication (logging in existing users and registering new users) in the 'Drawn Together' project. Currently, it only handles authentication; however, in future implementations, it will handle game logic, retrieving user stats and game stats and other game-related tasks.

## Build Steps

To run this locally, you will need to do the following:

1. Required software and dependencies:
     - [ ] Java Development Kit: https://www.oracle.com/au/java/technologies/downloads/
     - [ ] Apache Maven: https://maven.apache.org/download.cgi
     - [ ] MySQL: https://dev.mysql.com/downloads/installer/

2. Clone to repository to your local machine and run the following commands:

```bash
git clone https://github.com/TimBroderick44/Drawn-Together-Backend.git
```

```bash
cd Drawn-Together-Backend
```

3. Set up access to your database:
   - Using the mySQL CLI (or the mySQL workbench) to login to your account:

```bash
mysql -u root -p
```

4. Create a new database for use with the app:

```sql
CREATE DATABASE your_database_name;
```

5. Configure the application properties:

- In the src/main/resources directory, create 'application.properties' and add the following:

```java
spring.application.name=drawn-together-backend
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.sql.init.mode=always
```

6. Build (the 'clean' keyword ensures that it is built from scratch):

```bash
mvn clean install
```

7. Using postman, go to 'Authorization' and change the type to 'Basic Auth'. 

  ```
  Test with:

  username : JudasJefferson
  password : DrawnTogether2024
  ```

8. You should get the following response:
```   
{
    "jwt": "XXXXXXX",
    "name": "Mumford Munglebean",
    "email": "user2@example.com"
}
```
9. Follow the steps [here](https://github.com/TimBroderick44/Drawn-Together-Frontend) to set up the frontend and then [here](https://github.com/TimBroderick44/Drawn-Together-Websocket-Server) to set up the websocket server. 

## What did I use to create it?

This project uses:

-   SpringBoot
-   Java
-   mySQL 

## Features of the Project:

-  Implements authentication
-  Hashes passwords and does not expose them. 
-  Allows for user registration

<h1 style="font-weight: 900"> Here are some of the lessons I learnt:</h1>

### Authentication:

-  This was my third time implementing authentication in a project and I was able to do it with a lot more confidence. I was able to recycle a lot of the code I had previously written and implement it in a way that was more efficient and effective.In addition, I was able to allow for new users to be registered and for their details to be stored in the database.
  
### User Registration:
- This was the first time I had implemented user registration in a project. I was able to use the same code that I had used for authentication and modify it to allow for new users to be registered. I was able to store the new user's details in the database and hash their password before storing it.
  
## What I still need to do:

-   [ ] Implement game logic and implement the game version of the project 
-   [ ] Implement user stats and game stats
-   [ ] Implement a way for users to reset or change their details.

## Thank You!

Thank you for taking the time to look at this project. I really hope you enjoy it.
Feel free to reach out and ask any questions.

[Tim Broderick]
