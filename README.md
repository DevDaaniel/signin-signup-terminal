# **Terminal Sign Doc**

---

## **Signin Function**

> The `Signin` function is responsible for user authentication. It verifies the user's credentials by checking if they exist in the `users` table of the database. If the user exists, the login is approved; otherwise, it is rejected.

## **Signup Function**

> The `Signup` function is used to add new users to the database. It inserts user information (name and password) into the `users` table. If a user with the same name already exists, the signup fails.

## **Database Structure**

> The database includes a table named `users`. This table has the following columns:
- `id` (unique identifier) 
- `name` (varchar, user's name)
- `password` (varchar, user's password)

## **Main Program**


> The main program can be executed with JDK 20(Temurin) the following command:

```bash
cd src/main/java/org/srdaniel/sign/
javac Main
Main.java
```

# THE PROJECT ARCHITECTURE 

**The project's primary purpose is to provide user authentication, including both signin and signup functionality. It relies on a database table to store
user information, where users are authenticated based on their credentials (name and password) by comparing them to entries in the database. If the user
exists, they are allowed to sign in; otherwise, their signup request is rejected.**
