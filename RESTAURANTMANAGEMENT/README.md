# Restaurant Management REST API

This project runs as a Spring Boot REST API on Java 21. The API exposes restaurant branches, employees, menu items, orders and payments, reservations, and table availability under `/api`.

## Run

1. Create the MySQL database if it does not exist:

   ```sql
   CREATE DATABASE restaurantmanagement;
   ```

2. Configure the database connection. Defaults are `localhost:3306`, database `restaurantmanagement`, and user `root`. Set the password in your PowerShell session before starting the app:

   ```powershell
   $env:DB_USERNAME = "root"
   $env:DB_PASSWORD = "root@123"
   ```

   The password is supplied through the environment rather than stored in the application configuration.
3. Start the API:

   ```powershell
   mvn spring-boot:run
   ```

The API listens on `http://localhost:8080`. Spring initializes the tables and default branch seating counts from `src/main/resources/schema.sql`. Existing tables are retained by `CREATE TABLE IF NOT EXISTS`.

## Endpoints

| Method | Path | Purpose |
| --- | --- | --- |
| GET | `/api/branches` | List supported branches |
| GET, POST | `/api/employees` | List or add employees; filter with `?branch=Hyd` |
| PUT, DELETE | `/api/employees/{id}` | Update or remove an employee |
| GET, POST | `/api/menu` | List or add menu items; filter with `?branch=Blr` |
| PUT, DELETE | `/api/menu/{branch}/{dishId}` | Update or remove a menu item |
| GET, POST | `/api/orders` | List or add order items; filter with `?status=p` |
| PUT, DELETE | `/api/orders/{id}/items/{item}` | Update quantity or remove an order item |
| DELETE | `/api/orders/{id}` | Cancel an order |
| PATCH | `/api/orders/{id}/complete` | Mark an order complete |
| POST | `/api/orders/{id}/payment` | Calculate the bill and payment change |
| GET, POST | `/api/reservations` | List or make reservations |
| PATCH | `/api/reservations/{id}/occupy` | Occupy a reservation |
| DELETE | `/api/reservations/{id}` | Cancel a reservation |
| GET | `/api/seating` | List table availability |

Example request to add an order item:

```json
{
  "id": 501,
  "item": "VegBiryani",
  "quantity": 2
}
```

Employee, menu, and reservation payload fields are validated. Errors are returned as JSON with an appropriate HTTP status.
