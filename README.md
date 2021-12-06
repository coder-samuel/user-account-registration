#  API | Keeggo

[Access the cloud application through this link](https://git.heroku.com/user-account-registration.git)
<br>

# Technologies:
![tecnologias](https://user-images.githubusercontent.com/80654468/144280772-8415db84-f6ba-4643-a796-99d10ce20112.png)

<br>

## About this project 
<br>
This is a simple API that aims to manage users, courses and enrollments.

Technologies are used: 
- Java 
- Maven 3+ 
- Spring Boot 
- Spring Web 
- Bean Validation 
- Spring Data JPA 
- PostgresSQL, the relational BD
<br>

### What is already implemented?
The following endpoints are implemented:
- `GET /users/{username}` gets a user's details
- `POST /users` adds a new user 
- `GET /address` lists addresses already registered 
- `POST /address` adds a new address 
- `GET /address/{id}` gets the details of a address

SpringBoot project for managing the registration of customerqusers in a rest system.

This article will walk you through building an application called user-account-registration.

Follow each step to build an app from scratch, or skip to the end get the source for this article. You can also use almost any existing Maven webapp project.

## Pre requisites

* Basic Java knowledge, including an installed version of the JVM and Maven.
* Basic Git knowledge, including an installed version of Git.

### How Does user-account-registration?

When using Webapp Runner you'll launch your application locally and on Heroku with a command like this:
    
    :::term
    $ java -jar user-account-registration.jar application.war
    INFO: Starting ProtocolHandler ["http-8080"]

user-account-registration will then launch a Tomcat instance with the given war deployed to it. This takes advantage of Tomcat's embedded APIs and is similar to an option that Jetty offers: [Jetty Runner](http://blogs.webtide.com/janb/entry/jetty_runner).

## Run your Application

To build your application simply run:

    :::term
    $ mvn package

And then run your app using the java command:

    :::term
    $ java -jar target/user-account-registration.jar target/*.war

That's it. Your application should start up on port 8080.

Congratulations! Your web app should now be up and running on Heroku. Open it in your browser with:

## Clone the source

If you want to skip the creation steps you can clone the finished sample (without memcache backed session):

    $ git clone git@github.com:coder-samuel/user-account-registration.git


# 1. Steps taken in the project

1. Definition of Requirements

2. Documentation of Project

3. Implementation and development

4. Coverage and tests: not applied to the project

5. Availability in production
