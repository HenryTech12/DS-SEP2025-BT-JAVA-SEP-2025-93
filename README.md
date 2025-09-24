# Trip Management System (Spring Boot + Hibernate)

A Spring Boot application for managing trips with full CRUD operations, filtering, pagination, validation, exception handling, and API documentation.

---

## 📌 Features
- CRUD operations for trips  
- Search trips by destination  
- Filter trips by status  
- Get trips within a date range  
- Trip summary (total trips, min/max/average price)  
- Pagination & sorting support  
- Custom validations  
- Global exception handling  
- DTOs for clean API responses  
- Swagger API documentation  
- Unit testing with JUnit & Mockito  

---

## 🗄️ Tech Stack
- **Backend:** Spring Boot (2.x/3.x)  
- **ORM:** Hibernate (Spring Data JPA)  
- **Database:** MySQL  
- **API Docs:** Swagger (OpenAPI)  
- **Build Tool:** Maven / Gradle  
- **Testing:** JUnit + Mockito  

---

## 🚀 Getting Started

### 1. Clone Repository
```bash
git clone https://github.com/your-username/DS-SEP-2025-<RegistrationNumber>.git
cd DS-SEP-2025-<RegistrationNumber>
```

### 2. Configure Database
Create a database named `tripdb` in MySQL and update your `application.properties` (or `application.yml`) with:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tripdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run Application
```bash
mvn spring-boot:run
```
The app will be available at:  
```
http://localhost:8080
```

---

## 📚 API Endpoints

### 1. Create Trip  
**POST** `/api/trips`  
```json
{
  "destination": "Paris",
  "startDate": "2025-09-10",
  "endDate": "2025-09-20",
  "price": 1500.00,
  "status": "PLANNED"
}
```

### 2. Get All Trips (with Pagination & Sorting)  
**GET** `/api/trips?page=0&size=5&sort=startDate,asc`

### 3. Get Trip by ID  
**GET** `/api/trips/{id}`

### 4. Update Trip by ID  
**PUT** `/api/trips/{id}`  
```json
{
  "destination": "London",
  "startDate": "2025-09-15",
  "endDate": "2025-09-25",
  "price": 1800.00,
  "status": "ONGOING"
}
```

### 5. Delete Trip by ID  
**DELETE** `/api/trips/{id}`

### 6. Search Trips by Destination  
**GET** `/api/trips/search?destination=Paris`

### 7. Filter Trips by Status  
**GET** `/api/trips/filter?status=PLANNED`

### 8. Get Trips Between Dates  
**GET** `/api/trips/daterange?start=2025-09-01&end=2025-09-30`

### 9. Trip Summary  
**GET** `/api/trips/summary`  
Response:
```json
{
  "totalTrips": 50,
  "minPrice": 500.0,
  "maxPrice": 4500.0,
  "averagePrice": 2200.0
}
```

### 10. Swagger Documentation  
Access at:  
```
http://localhost:8080/swagger-ui.html
```

---

## 📂 Deliverables
- Complete Spring Boot project on GitHub  
- `README.md` with setup & API documentation  
- Postman Collection (`Trip-API.postman_collection.json`)  
- Database Script (`tripdb.sql`)  

---

## 🧪 Testing
Run tests with:
```bash
mvn test
```

---

## 📧 Contact
Badkul Technology Pvt Ltd  
🌐 [www.badkultechnology.com](http://www.badkultechnology.com)  
✉ connect@badkultech.com  
