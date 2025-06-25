# 🧮 Dynamic Pricing API

A backend REST API for managing vendors and dynamically calculating product pricing based on inventory, demand, and vendor-specific strategies.

Built with **Java 17**, **Spring Boot**, **PostgreSQL**, and structured using **domain-driven design principles**. This application is container-ready with future integration planned for **Docker**, **Redis**, and deployment on **AWS EC2**.

---

## 🚀 Features

- ✅ Create and manage products and vendors
- ✅ Store vendor pricing strategies and multipliers
- ⏳ Calculate dynamic prices based on demand and stock levels *(in progress)*
- ⏳ Extendable rule engine for price factors *(in progress)*
- ⏳ Admin endpoints and authentication *(planned)*

---

## ⚙️ Tech Stack

| Layer             | Tools/Libraries                        |
|------------------|-----------------------------------------|
| **Language**     | Java 17                                 |
| **Framework**    | Spring Boot                             |
| **Database**     | PostgreSQL                              |
| **Build Tool**   | Maven                                   |
| **ORM/Mapper**   | Spring Data JPA, MyBatis *(learning)*   |
| **Testing**      | JUnit 5, Mockito *(coming soon)*        |
| **Deployment**   | AWS EC2 *(planned)*, Docker *(planned)* |

---

## 📦 Getting Started

### 📋 Prerequisites
- Java 17+
- Maven 3.8+
- PostgreSQL running locally or via Docker

### 🧪 Run Locally
```bash
git clone https://github.com/SheedyWonder/dynamic-pricing-api.git
cd dynamic-pricing-api
./mvnw spring-boot:run