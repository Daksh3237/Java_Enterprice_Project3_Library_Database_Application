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
