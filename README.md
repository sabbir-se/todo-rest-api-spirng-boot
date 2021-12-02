# Todo REST API By Using Spring Boot Framework
The following is simple TODO REST API using the Spring Boot Framework. The API allow you to add item to a to-do list, update, retrieve and remove from the list.

##  Concepts used in this Application


* [@RestController](https://spring.io/guides/gs/rest-service/)
* [@Service](https://spring.io/guides/gs/rest-service/)
* [@Entity](https://spring.io/guides/gs/rest-service/)
* [JpaRepository](https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html)


### Usage
* Make sure you have [java JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) and [Maven](https://maven.apache.org/) installed
* Make sure you have a Mysql server running.
* Create a database with the following name: assignment_todo, you can modify it in the application.properties file with this line:  spring.datasource.url=jdbc:mysql://localhost:3306/assignment_todo?characterEncoding=UTF-8 
* Modify the username and password in the file mention above with this line:  spring.datasource.username=testUsername spring.datasource.password=testPassword
* Run the application using your preferred IDE ([IntelliJ](https://www.jetbrains.com/idea/), [STS](https://spring.io/tools))


## Application Logic For Priority :

* 1 Means Low
* 2 Means Medium
* 3 Means High


##  Application Demo with [Postman](https://www.postman.com/):



### Todo list (Priority Wise) :

<img src="https://github.com/sabbir-se/todo-rest-api-spirng-boot/blob/main/readme/todoList.png?raw=true"  alt="Demo screen postman">


### Add  Item



### Update item



### Delete item

