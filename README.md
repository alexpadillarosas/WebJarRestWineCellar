# WebjarRestWineCellar
Website and Rest app bundled together using Webjars(Twitter Bootstrap and jQuery), jax-rs, Thorntail.
 
### Thanks to Christophe Coenraets @ccoenraets, for the original post
http://coenraets.org/blog/2011/12/restful-services-with-jquery-and-java-using-jax-rs-and-jersey/

Thorntail
-------
Will detect the fractions you need for the project.

Quick Build
-------
If you want build the app using Maven, you'll need:
- Java 1.8+
- Maven 3.0.5 or later

execute:
```
mvn clean install
```
will generate the .war application and also the fatjar (adding -thorntail) to the name of the app

Running the application
-------
### Running the fatjar (It contains all the dependencies needed to startup the app)
to run the fatjar:
```
java -jar webjarRestWineCellar-thorntail.jar
```
### Running Thorntail as a Java Application in Eclipse: (Use the same configuration for debugging inside of eclipse)
![screenshot](https://user-images.githubusercontent.com/4823319/49846691-a2e31600-fe20-11e8-99f3-824d7e205a03.png)

or
```
mvn thorntail:run   in the root of the application where the pom file is located.
```
Will allow you to code changes in your .js and .html files in real time withouth redeploying the application.
