# Medical Shop Management System

A Java full-stack academic project starter based on the uploaded internship report. It uses Java 17, Spring Boot, Spring Data JPA, MySQL, HTML, CSS, JavaScript, and Bootstrap.

## Features implemented in this starter
- Responsive inventory dashboard
- Medicine search by name/category
- Create, read, update, and delete medicine records through REST APIs
- Medicine price, stock, manufacturer, category, and expiry-date fields
- Prescription request record submission and status workflow (`PENDING`, `VERIFIED`, `REJECTED`)
- MySQL persistence using Spring Data JPA

## Not implemented yet
This repository does **not** currently implement real user authentication/role security, prescription file upload, cart/order checkout, payment gateway integration, or sales reports. The report describes these as system goals, but they should not be represented as working features until implemented and tested. No real payment is taken and this is not a production pharmacy system.

## Requirements
- JDK 17 or newer
- Maven 3.8+
- MySQL 8+

## Run locally (Windows CMD)
1. Install JDK 17, Maven, and MySQL.
2. Start MySQL and create the database (optional because the JDBC URL can create it automatically):
   ```sql
   CREATE DATABASE medical_shop;
   ```
3. Open `src/main/resources/application.properties`. Set the MySQL username/password, or set environment variables `DB_USERNAME` and `DB_PASSWORD`.
4. In CMD, navigate to the project folder and run:
   ```cmd
   mvn spring-boot:run
   ```
5. Open http://localhost:8080

If the database password is not blank, set it before running, for example in CMD:
```cmd
set DB_USERNAME=root
set DB_PASSWORD=your_mysql_password
mvn spring-boot:run
```

## REST API
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/medicines` | List medicines |
| GET | `/api/medicines?search=para` | Search name/category |
| GET | `/api/medicines/{id}` | Get one medicine |
| POST | `/api/medicines` | Add medicine JSON |
| PUT | `/api/medicines/{id}` | Update medicine JSON |
| DELETE | `/api/medicines/{id}` | Delete medicine |
| GET | `/api/prescriptions` | List prescription request records |
| POST | `/api/prescriptions` | Submit a request record |
| PATCH | `/api/prescriptions/{id}/status?value=VERIFIED` | Update review status |

Example medicine JSON:
```json
{
  "name": "Paracetamol 500 mg",
  "category": "Pain relief",
  "manufacturer": "Sample Pharma",
  "price": 25.50,
  "stock": 100,
  "expiryDate": "2027-12-31"
}
```

## GitHub upload
Create a new GitHub repository named `medical-shop-management-system`. Extract this ZIP, open the extracted folder in a terminal, then run:
```cmd
git init
git add .
git commit -m "Initial medical shop management system project"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/medical-shop-management-system.git
git push -u origin main
```
Replace `YOUR-USERNAME` with your GitHub username. Do not upload passwords, API keys, customer data, or real prescriptions.

## Project structure
```text
medical-shop-management-system/
├── docs/schema.sql
├── src/main/java/com/example/medicalshop/
│   ├── MedicalShopApplication.java
│   ├── controller/
│   ├── model/
│   └── repository/
├── src/main/resources/
│   ├── application.properties
│   └── static/ (HTML, CSS, JavaScript)
├── pom.xml
└── README.md
```
