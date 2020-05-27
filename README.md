<h3>Requirements</h3>
Java - 1.8.x

Maven - 3.x.x

Mysql - 5.x.x

elasticsearch - 7.x.x

<h3>Steps to Setup</h3>

1. Clone the application locally

    git clone (https://github.com/stutirastogi/bookStoreApp.git)

2. Use script.sql file to create the necessary database and tables

3. Change mysql username and password as per your installation

    open src/main/resources/application.properties

    change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Open powershell in the root directory. You can now bring up the entire application with just one command:

    $ docker-compose up

  This will start the elasticsearch server and mysql service. Application will start running at http://localhost:8080.

<h3>Explore Rest APIs</h3>

The documentation for rest apis can be found at http://localhost:8080/swagger-ui.html
