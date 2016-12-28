**rx-streaming** is a project which demonstrates the use of SseEmitter from Spring to emit the data whenever it is available with the server.

This project uses -
* Spring Boot
* rx-java
* AngularJS

In order to emit events, SseEmitter is used which sends the events as and when they are available. Events are emitted in a separate thread using @Async annotation from Spring.

AngularJS uses EventSource to establish a connection with the server and registers a listener on message event to handle message events which are emitted.

By default, asynchronous requests timeout in 30 seconds in Tomcat and as a part of this project 100 products are emitted with a delay of 1 second for each product, so asynchronous timeout was increased to 100 seconds in *StreamingConfig.java*
