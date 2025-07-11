# 🧩 Microservices Architecture with Spring Boot | Config Server | Eureka | API Gateway

This project demonstrates a complete **Microservices-based architecture** using Spring Boot, where different services (User, Hotel, Rating) communicate with each other via REST and are managed through **Eureka Service Registry**, **Spring Cloud Config**, and an **API Gateway** secured with **Okta OAuth2**.

---

## 🗂️ Project Structure

```bash
microservices-architecture/
├── config-server/
├── service-registry/
├── api-gateway/
├── user-service/
├── hotel-service/
└── rating-service/
🔁 Microservices Flow Overview
Client Request hits the API Gateway.

API Gateway routes the request to the appropriate microservice (User, Hotel, or Rating) via Eureka Service Registry.

Microservices fetch their configuration from Spring Cloud Config Server.

User Service communicates with both Hotel Service and Rating Service using RestTemplate and Feign client.

OAuth2 authentication is managed via Okta.

🧱 Microservices Overview
✅ User Service (Port: 8081)
Stores user information in a MySQL database.

Fetches user ratings from Rating Service.

For each rating, fetches hotel details from Hotel Service.

Implements CircuitBreaker, Retry, and RateLimiter using Resilience4J.

🏨 Hotel Service (Port: 8082)
Stores hotel data in a PostgreSQL database.

Exposes endpoints to fetch all or individual hotel data.

⭐ Rating Service (Port: 8083)
Stores user-hotel ratings in MongoDB.

Supports custom finders: findByUserId, findByHotelId.

🛡️ API Gateway (Port: 8084)
Uses Spring Cloud Gateway.

Secured with OAuth2 (Okta).

Routes requests to microservices using Eureka Discovery.

🗃️ Service Registry (Port: 8761)
Eureka Server for service registration and discovery.

⚙️ Config Server (Port: 8085)
Provides centralized configuration.

Reads config from GitHub:
https://github.com/Aashu1719/microsevice-config-1

🔧 Tech Stack Used
Component	Technology
Core Language	Java 21
Framework	Spring Boot, Spring Cloud
API Gateway	Spring Cloud Gateway
Config Management	Spring Cloud Config
Service Discovery	Eureka Server
Inter-Service Comm.	RestTemplate + Load Balancer
DBs Used	MySQL (User), PostgreSQL (Hotel), MongoDB (Rating)
Authentication	OAuth2 with Okta
Resilience	Resilience4j (Circuit Breaker, Retry, Rate Limiter)
Security	Spring Security + JWT (via Okta)
DevOps Ready	Docker support (optional)

⚙️ How to Run Locally
✅ Prerequisites
Java 21

Maven

MySQL, PostgreSQL, MongoDB installed & running

Git

Internet connection for Config Server

🔨 Steps
Clone the Repo

bash
Copy
Edit
git clone https://github.com/Aashu1719/spring-boot-microservice-devops-learning-series.git
cd spring-boot-microservice-devops-learning-series
Start the Config Server

bash
Copy
Edit
cd config-server
mvn spring-boot:run
Start the Eureka Server

bash
Copy
Edit
cd service-registry
mvn spring-boot:run
Start Microservices (in order):

bash
Copy
Edit
cd hotel-service
mvn spring-boot:run

cd ../rating-service
mvn spring-boot:run

cd ../user-service
mvn spring-boot:run
Start the API Gateway

bash
Copy
Edit
cd ../api-gateway
mvn spring-boot:run
📊 APIs Summary
🔹 User Service
bash
Copy
Edit
POST   /users
GET    /users
GET    /users/{id}
🔹 Hotel Service
bash
Copy
Edit
POST   /hotels
GET    /hotels
GET    /hotels/{id}
GET    /staffs
🔹 Rating Service
bash
Copy
Edit
POST   /ratings
GET    /ratings
GET    /ratings/users/{userId}
GET    /ratings/hotels/{hotelId}
🔒 Security & Fault Tolerance
OAuth2 Integration via Okta in API Gateway.

Circuit Breaker to handle service downtime.

Retry and Rate Limiting via Resilience4j annotations.