# Product Service

This is a Spring Boot application for managing products. It provides RESTful APIs to perform CRUD operations on products.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The Product Service application is designed to manage product information. It allows users to create, read, update, and delete product records through a set of RESTful APIs.

## Technologies Used

- Java
- Spring Boot
- Maven
- SQL
- H2 Database (for development and testing)

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/suryasolurgm/productservice24.git
   cd productservice24
2. Build the project using Maven:
   ```sh
   mvn clean install    
### Running the Application

1. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
2. The application will start on `http://localhost:8080`.

## API Endpoints

- `GET /products` - Retrieve a list of all products
- `GET /products/{id}` - Retrieve a product by its ID
- `POST /products` - Create a new product
- `PUT /products/{id}` - Update an existing product
- `DELETE /products/{id}` - Delete a product by its ID

## Database Schema

The application uses an H2 in-memory database for development and testing. The schema is automatically created based on the JPA entities.      