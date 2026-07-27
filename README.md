Logistics Management System

A beginner-friendly Logistics Management REST API developed using Java, Spring Boot, Spring Data JPA, and MySQL.

This project manages customers, warehouses, inventory, shipments, tracking information, and deliveries.

Main Features
Add, view, update, and delete customers
Manage warehouse details
Manage warehouse inventory
Create and update shipments
Track shipment locations and status
Store delivery information
Validate request data
Handle errors using global exception handling
Store all data in MySQL
Test APIs using Postman
Technologies Used
Java 17
Spring Boot 3.3.5
Spring Web
Spring Data JPA
Hibernate
MySQL
Maven
Bean Validation
Postman
Project Modules
Customer
Warehouse
Inventory
Shipment
Tracking
Delivery
Relationships
One customer can have many shipments.
One warehouse can have many inventory items.
One shipment can have many tracking updates.
One shipment can have one delivery.
Requirements

Install the following software:

Java 17
MySQL Server
Maven
Eclipse, IntelliJ IDEA, or Spring Tool Suite
Postman
Database Setup

Open MySQL Workbench and run:

CREATE DATABASE logistics_db;

Open the application.properties file and enter your MySQL username and password:

spring.application.name=logistics-management-system
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/logistics_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

If your MySQL password is not root, replace it with your correct password.

How to Run the Project
Download or clone this repository.
Import the project into Eclipse as an Existing Maven Project.
Start MySQL Server.
Open LogisticsApplication.java.
Right-click and select Run As → Spring Boot App.
The application will start on port 8080.

Base URL:

http://localhost:8080
Recommended Creation Order

Create data in this order:

Customer → Warehouse → Inventory → Shipment → Tracking → Delivery
API Endpoints
Customer APIs
POST   /api/customers
GET    /api/customers
GET    /api/customers/{id}
PUT    /api/customers/{id}
DELETE /api/customers/{id}
Warehouse APIs
POST   /api/warehouses
GET    /api/warehouses
GET    /api/warehouses/{id}
PUT    /api/warehouses/{id}
DELETE /api/warehouses/{id}
Inventory APIs
POST   /api/inventory
GET    /api/inventory
GET    /api/inventory/{id}
PUT    /api/inventory/{id}
DELETE /api/inventory/{id}
Shipment APIs
POST   /api/shipments
GET    /api/shipments
GET    /api/shipments/{id}
PUT    /api/shipments/{id}
DELETE /api/shipments/{id}
Tracking APIs
POST   /api/tracking
GET    /api/tracking
GET    /api/tracking/{id}
PUT    /api/tracking/{id}
DELETE /api/tracking/{id}
Delivery APIs
POST   /api/delivery
GET    /api/delivery
GET    /api/delivery/{id}
PUT    /api/delivery/{id}
DELETE /api/delivery/{id}
Sample Customer JSON
{
  "name": "Surendra",
  "email": "surendra@example.com",
  "phone": "9876543210",
  "address": "Hyderabad, Telangana"
}
Sample Warehouse JSON
{
  "name": "Hyderabad Central Warehouse",
  "location": "Hyderabad",
  "capacity": 5000
}
Sample Inventory JSON
{
  "itemName": "Laptop",
  "sku": "LAP-1001",
  "quantity": 25,
  "unitPrice": 55000.00,
  "warehouseId": 1
}
Sample Shipment JSON
{
  "trackingNumber": "TRK-2026-0001",
  "origin": "Hyderabad",
  "destination": "Vijayawada",
  "weight": 3.5,
  "status": "CREATED",
  "expectedDeliveryDate": "2026-07-30",
  "customerId": 1
}
Sample Tracking JSON
{
  "location": "Hyderabad Hub",
  "status": "IN_TRANSIT",
  "updatedAt": "2026-07-27T11:30:00",
  "remarks": "Shipment left the origin hub",
  "shipmentId": 1
}
Sample Delivery JSON
{
  "deliveryDate": "2026-07-30T16:00:00",
  "receivedBy": "Ravi",
  "status": "DELIVERED",
  "notes": "Delivered safely",
  "shipmentId": 1
}
Postman Testing
Start the Spring Boot application.
Open Postman.
Click Import.
Select Logistics-API.postman_collection.json.
Select an API request.
Click Send.
Check the response and status code.
Author

Surendra
