# TweetAPI-V1
Ratnakar Sahoo
Basic Tweeting and Commenting System in Java Spring Boot
•	I have successfully developed the “Basic Tweeting and Commenting System”. Where users can create, read, update and delete their post. 
•	I used MVC architecture to developed this backend. 
•	I used technology Core Java, Spring Boot, Hibernate, JPA repository, Lombok, MySQL and Apache Tomcat server to develop this Rest-Ful API.
•	Tool, used InteliJIdea for writing the code, MySQL Workbench for data integration, postman for testing purpose.
Used Architecture to develop this API (Backend Code):
I used MVC architecture to develop this API.
First from the client side (View) when user will post the tweet in the form of JSON object, that JSON object will go to the controller layer, from controller layer that object will be converted into DTO (Data Transfer Object), from the controller it will go to service layer where business logic of the operations has been developed, in service layer that DTO object will convert into Entity and then that entity will store inside the repository through JPA repository and vice versa.

View---------- Controller---------- Service---------Database
