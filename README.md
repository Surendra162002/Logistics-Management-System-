# Logistics Management System

## Scheduler

- Daily shipment summary: runs every day at 8:00 AM.
- Low-stock inventory check: runs every six hours and reports items with quantity 10 or lower.
- Source: `src/main/java/com/example/logistics/scheduler/LogisticsScheduler.java`

## Testing

The project includes beginner-friendly JUnit 5 and Mockito tests for:

- Customer service
- Warehouse service
- Inventory service
- Shipment service
- Tracking service
- Delivery service
- Scheduler

Run all tests:

```bash
mvn clean test
```

Test source is available under `src/test/java/com/example/logistics`.

Spring Boot REST API created from the uploaded Logistics API documentation.

## Technology
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Bean Validation
- MySQL
- Maven

## Setup
1. Install Java 17, MySQL and Maven.
2. Open `src/main/resources/application.properties`.
3. Change `spring.datasource.username` and `spring.datasource.password` to your MySQL credentials.
4. Run `database.sql`, or allow the application URL to create `logistics_db` automatically.
5. From the project folder run:
   ```bash
   mvn spring-boot:run
   ```
6. Base URL: `http://localhost:8080`

## Relationships
- Customer → many Shipments
- Warehouse → many Inventory items
- Shipment → many Tracking updates
- Shipment → one Delivery

## Recommended creation order
Customer → Warehouse → Inventory → Shipment → Tracking → Delivery

## JSON examples
### Customer: POST /api/customers
```json
{"name":"Surendra","email":"surendra@example.com","phone":"9876543210","address":"Hyderabad, Telangana"}
```
### Warehouse: POST /api/warehouses
```json
{"name":"Hyderabad Central Warehouse","location":"Hyderabad","capacity":5000}
```
### Inventory: POST /api/inventory
```json
{"itemName":"Laptop","sku":"LAP-1001","quantity":25,"unitPrice":55000.00,"warehouseId":1}
```
### Shipment: POST /api/shipments
```json
{"trackingNumber":"TRK-2026-0001","origin":"Hyderabad","destination":"Vijayawada","weight":3.5,"status":"CREATED","expectedDeliveryDate":"2026-07-25","customerId":1}
```
### Tracking: POST /api/tracking
```json
{"location":"Hyderabad Hub","status":"IN_TRANSIT","updatedAt":"2026-07-21T11:30:00","remarks":"Shipment left the origin hub","shipmentId":1}
```
### Delivery: POST /api/delivery
```json
{"deliveryDate":"2026-07-25T16:00:00","receivedBy":"Ravi","status":"DELIVERED","notes":"Delivered safely","shipmentId":1}
```

## Enum values
Shipment: `CREATED`, `PICKED_UP`, `IN_TRANSIT`, `OUT_FOR_DELIVERY`, `DELIVERED`, `CANCELLED`
Tracking: `PICKED_UP`, `IN_TRANSIT`, `ARRIVED_AT_WAREHOUSE`, `OUT_FOR_DELIVERY`, `DELIVERED`, `DELAYED`
Delivery: `PENDING`, `DELIVERED`, `FAILED`

Every module supports POST, GET all, GET by ID, PUT, and DELETE endpoints exactly as listed in the presentation.
