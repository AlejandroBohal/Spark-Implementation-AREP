# SPARK FRAMEWORK IMPLEMENTATION  :rocket:
In this repository you will find a solution to the laboratory 3 of Enterprise Architectures

## Getting Started

In this repository you will find a solution to the laboratory 3 of Enterprise Architectures, in which it was asked to perform an implementation of a web server that allows reading all types of files both static and dynamic and perform database connection. The application has been deployed to heroku and has continuous integration with circleci.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://cryptic-cliffs-94626.herokuapp.com/)[![CircleCI](https://circleci.com/gh/AlejandroBohal/Spark-Implementation-AREP.svg?style=svg)](https://circleci.com/gh/AlejandroBohal/Spark-Implementation-AREP)

Application:

https://spark-implementation-alejandro.herokuapp.com/

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

- Java SE Development Kit 8
- Java SE Runtime Environment 8
- In order to use the program you will need Maven on your system to be able to build it.
- Git to be able to clone this repository. 
- Heroku cli if you want to deploy the app by yourself or use the local server.


### Installing

we will first clone the repository with the following command

```
Git clone https://github.com/AlejandroBohal/Spark-Implementation-AREP
cd Spark-Implementation-AREP
```

After this we will build the project with the next command or phase:
```
mvn package
```
Once the project is built, we can execute it with Maven in the following way:
```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.sparkframework.SparkAServer"
```
if you want to open a local test server you must document the following line in the /src/main/resources/js/script.js directory 

![](https://media.discordapp.net/attachments/352624122301513730/751393603255009290/unknown.png?width=1026&height=418)

then execute the following command your terminal (Remember you need the heroku toolbet installed in your computer).

```
mvn clean install
heroku local web
```

Test cases are automated with JUnit and can be executed with the following command:
```
mvn test
```
once you run the tests you'll get an output similar to this:

## ClassDiagram

In the following image we can see the structure of the project from the point of view of the class diagram, the most important class is the http server, which is responsible for finding both static and dynamic resources, can handle several non-concurrent requests. From the http server were made the get and post methods to read any type of file and insert it into a MongoDB test database.

![](https://media.discordapp.net/attachments/352624122301513730/751387956081721344/Package_arep.png?width=403&height=475)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

* CircleCI for CI [![CircleCI](https://circleci.com/gh/AlejandroBohal/Spark-Implementation-AREP.svg?style=svg)](https://circleci.com/gh/AlejandroBohal/Spark-Implementation-AREP)


* [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://cryptic-cliffs-94626.herokuapp.com/)

## Documentation

This repository contains a paper with documentation about the process carried out for the creation of the program, the following link will redirect you to it:

https://github.com/AlejandroBohal/Spark-Implementation-AREP/blob/master/Documentation.pdf

Documentation website:
https://alejandrobohal.github.io/Spark-Implementation-AREP/

If you need additional information about the program structure or about some functionality, you can generate the documentation with the following command
```
mvn javadoc:javadoc
```
In order to see the documentation we will generate a simple site that will allow us to see it properly with the following command:
```
mvn site
```
run the website with:
```
mvn site:run
```
in a web browser we enter the following address http://localhost:8080 
documentation will be in the reporting area of the site

![](https://media.discordapp.net/attachments/352624122301513730/751395373695893604/unknown.png)

## Versioning

We use Git for versioning

## Author

* **Sergio Alejandro Bohorquez Alzate** 
Student at the Colombian School of Engineering

## License

This project is licensed under the GNU v3.0 - see the [LICENSE.md](LICENSE.md) file for details

