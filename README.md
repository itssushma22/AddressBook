
# Spring Boot Address API

### Prerequisites
	* JDK 1.8
	* Maven
	* h2 database
	* Spring Boot
	
### Acceptance Criteria
        * Address book will hold name and phone numbers of contact entires
	* Create Rest API which will have endpoints as follow
	    1. Users should be able to add a new contact entitird 
	    2. Users should be able to remove existing contact entities
	    3. Users should be able to print all contacts in an address book
	    4. Users should be able to maintain multiple address book 
	    5. Users should be able to print a unqiue set of all contacts across multiple address books.
	    
### Assumptions
          * In this Api development, user roles and permissions are full and not checked.
          * Each address book has a unique mobile number.   
	  * Considering merely a single individual as a contact, the organization is out of the this API development.
	    
### API Spec
         * Swagger
	   http://localhost:8080/swagger-ui.html

### Containerise
         * Docker 
	
## Run
	* Download/Clone the project on to your local machine
	* Run the project on your machine
	* Send a request to http://localhost:8080/
