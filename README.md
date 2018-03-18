# YoCollection

A simple management application for your game collection.

## Software requirements

To install and run this application you need to have these installed:

* Maven (tested on 3.5.2 version)
* JDK (tested on 9.0.4 version)
* npm (tested on 5.7.1 version)
* H2 Database Engine (tested on 1.4.196 version)


## Installation

### Server

To run server you have to go to the folder containing application server (in this repo, server folder) and compile project using following command:
```
mvn clean package -DskipTests
```
Next, you need to run compiled application using Java. Make sure that you have set proper environmental variables (see JAVA_HOME). Run the following command:
```
java -jar target/app-0.0.1-SNAPSHOT.jar
```
Server is now running. To stop server application, use Ctrl+C.

### Client

To run client you have to install npm (or Yarn), go to the folder containing client application (in this repo, client folder), and run the following commands:
```
ng install
```

```
ng serve
```

To stop client application, use Ctrl+C.

### Database

On start, project will create its own H2 database, however without example database you will not be able to add any games to the list. To install example database, simply move file `test2.mv.db` to the path of H2 databases (default path is `C:/Users/[user_name]`).

### Application

To run the application, simply run both server and client, and go to `http://localhost:4200` address in your browser.



