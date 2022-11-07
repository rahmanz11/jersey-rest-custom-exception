# REST-Exception-Handling

## Build the server
_____
    cd server
    mvn clean install

## Deploy the sever
____
    copy the war file from target/server.war to tomcat/webapps

## Run the server
    Run the tomcat, by default it runs at port 8080

## Target URL:
___
    Target url is: http://localhost:8080/server/api/rest/

## REST Endpoint:
___ / [@POST, @GET, @PUT, @DELETE]

## Build the REST Client
_____
    cd client
    mvn clean install

## Run the REST Client
    Run the RESTClient.java file