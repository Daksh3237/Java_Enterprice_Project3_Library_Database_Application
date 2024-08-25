# Library Database Application

This is a Spring Boot project for managing a library database. The application allows users to register, log in, view books, and add reviews. Admin users have the additional capability to add new books to the database.

## Table of Contents

- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Demo](#demo)
- [License](#license)

## Project Description

This application is designed to manage a library's collection of books and user reviews. It includes features for user authentication, role management (admin and user), and book review submission. Admin users can add new books to the database.

## Features

- User Registration and Login
- Role-Based Access Control (Admin and User)
- Add New Books (Admin only)
- View Book Details and Reviews
- Add Reviews to Books
- Secure Password Storage with BCrypt
- User-Friendly Interface

## Technologies Used

- **Spring Boot** - Framework for building the backend
- **Spring Security** - For authentication and authorization
- **Thymeleaf** - Templating engine for rendering HTML pages
- **H2 Database** - In-memory database for development and testing
- **BCrypt** - For password encryption
- **Lombok** - To reduce boilerplate code
- **JDBC Template** - For interacting with the database

## Setup Instructions

To set up the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/library-database.git
   cd library-database
   
2. **Import the project**:

- Import the project into your favorite IDE as a Maven project.
  
3. **Run the application**:

- Ensure that your IDE is set up to run Spring Boot applications.
- Run the application by executing the BookController class or using the Spring Boot Dashboard.

4. **Access the application**:

- Open your web browser and go to http://localhost:8080/.

## Usage
**User Roles**
- **Admin User**: Can add books and view all available books and their reviews.
- **Standard User**: Can view books, view reviews, and add reviews.
- 
**Endpoints**
- '/' - Main page listing all books.
- '/login' - Login page.
- '/register' - User registration page.
- '/addBook' - (Admin only) Add a new book.
- '/ReviewsById/{id}' - View details and reviews for a specific book.
- '/addReviewById/{id}' - Add a review for a specific book.
  
**Admin Credentials**
- Email: `padakshc@sheridancollege.ca`
- Password: `1234`

**User Credentials**
- Email: `shressud@sheridancollege.ca`
Password: `1111`

**Demo**
Here is a video demonstrating the application's features:



Click the image above to watch the demo video on YouTube.

**License**
This project is licensed under the MIT License - see the LICENSE file for details.
