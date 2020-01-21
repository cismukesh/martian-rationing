# The Martian - Rationing System

Project is based on jsp and java-spring boot.

Martian-Rationing System is based on some conditions, in which due to some unfortunate circumstances involving a dust storm, you got stranded on Mars alone with no communication to your team or Earth’s command center.
Your surface habitat ("Hab") on Mars contains a limited inventory of food supplies. Each of these supplies is in the form of a packet containing either Food or Water. The food items have details of the content, expiry date and calories they provide. The water packet contains only the details of the quantity in liters and doesn’t expire.

#### Basic feature of the application should include:

```bash
i) Add Ration : Record the details of the supply packet to a storage mechanism.
ii) View Inventory : Retrieve the details of all the supply packets in the inventory
iii) Delete Ration : Ability to delete a supply packet from the inventory that has been consumed or needs update.
iv) Create Schedule : Ability to create schedule based on available inventory in the storage mechanism.
v) View Schedule : Retrieve the details of scheduled inventory in the storage mechanism.
```

## Usage 

The martian - rationing system based on inventory of food supplies system.
1. In this system Click Add-Food to add food with packet-Id,packet-Content,packet-Type,expiry-Date.
2. In this system Click Add-Water to add water with packet-Id,packet-Content and quantity in liter's.
3. Click inventory to show the ration present in inventory, and also update and delete Food and Water detail's. 
4. Click Create-Schedule to dynamically create Schedule of available inventory ration.
5. Click on View-Schedule to show scheduled inventory list.
 

#### Note :
At a time add all food and water details in inventory, then Click on Create-Schedule to create inventory schedule and at last Click on View-Schedule.The food and water once scheduled can not be deleted from Schedule list.


## Installation

   i. Eclipse - IDE.

   ii. You just need to have Java 8 installed on your machine.

   iii. Use spring starter maven project for esealy import in (import existing maven project) in eclipse.
 
   iv. Also there some dependencies, Install all the dependencies of pom.xml. 
  
   v. For database java ORM tool hibernate create database and tables automatically.

   vi. All the details related to Database is in application.property, change if needed.


## Running the application locally

There are several ways to run a Spring Boot application on your local machine.One way is you just need to run application to import existing maven project from any IDE like eclipse or Intellij, and run as a spring boot app.

The application will run on 

```bash
http://127.0.0.1:9090/load/rationing-system
```
