# rest-jdbc
For LvivIt

Write the project which will retrieve the data from REST requests and store it in some relational DB (H2 for example).
Application should have 3 layers: UI, Service and Data Persistence. Each layer has it's own data structure

UI (json)	
{ 
"name" : "string", 
  
"phones" : [ "string", "string", "string"] 
}

Service (domain model)	
public class Contacts{
String name;
String phones;
}

Data Persistence (row)	(id; name; phone)

So, in request body (json) all phones are stored in a list. 
In domain model in a single String ("phone1,phone2", ex.). 
But in database they are stored in a way, where for each phone there is a separate row. (id: 1; name: Oleg; phone: +38096...) (id: 2; name: Oleg; phone: +38050...; )

You application should process the requests (CRUD operations) and do the data structure transformation in both directions (API->Domain->Persistence and backward).

Also, keep in mind what step should be done if we going to switch UI layer from REST to JMS and Data storage from RDBSM to NoSQL. (this should NOT be done in the scope of current task).

Tech stack: Java 8, Spring 

Good Luck)
