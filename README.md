# Smart University Portal with Real-Time Tracking System

## 📌 Overview
The **Smart University Portal with Real-Time Tracking System** is a comprehensive desktop and analytics application developed as a Bachelor of Computer Applications (BCA) final year project. 

The system automates and simplifies university administrative and academic processes, including student management, faculty management, course management, attendance tracking, result management, fee management, and analytical reporting. The project features robust role-based access control for **Administrators, Faculty Members, and Students**.

---

## ✨ Features

### 🔐 Authentication & Authorization
* Secure Login System with encrypted validation.
* Role-Based Access Control (RBAC).
* Separate, interactive dashboards tailored for Admin, Faculty, and Student roles.

### 👥 Core Management Modules
* **Student Management:** Full CRUD operations (Add, Update, Delete, Search) for student profiles.
* **Faculty Management:** Complete profile management for university educators.
* **Course Management:** Tools to create courses, assign faculty, and manage credits/semester timelines.

### 📈 Attendance & Fee Tracking
* **Attendance Tracking:** Real-time attendance logging, automated percentage calculation, and strict 75% threshold monitoring.
* **Fee Management:** Classification of dues into Paid, Pending, and Overdue categories with payment history logging.

### 📊 Results & Predictive Analytics
* **Result Management:** Marks entry with automatic grade calculation and instant report card views.
* **Reports & Analytics:** Highly visual, Python-generated charts representing overall university statistics.

---

## 🤖 AI Module (Smart Insights)
The portal integrates an automated **Rule-Based Recommendation Engine** (`AIRecommendation.java`) that provides real-time proactive insights directly on the dashboard:
* **Attendance Analysis:** Evaluates student irregularities and triggers alert states.
* **Risk Assessment:** Flags students falling below academic or attendance benchmarks.
* **Performance Prediction:** Provides actionable recommendations based on past exam grades and trend analysis.

---

## 💻 Technology Stack

| Technology | Purpose |
| :--- | :--- |
| **Java (JDK 17 or higher)** | Core Application Logic & Object-Oriented Framework |
| **Java Swing** | Desktop Graphical User Interface (GUI) with Custom Rendering |
| **MySQL** | Relational Database Management System (RDBMS) |
| **JDBC** | Database Connectivity & Query Execution |
| **Python (Pandas, Matplotlib)** | Data Wrangling & Analytical Graph Generation |
| **HTML5 & CSS3** | Supplementary Web Frontend Interface (Student Portal View) |
| **XAMPP / Docker** | Local Database Server & Environment Management |

---

## 🧪 Testing Framework
To ensure system reliability and robust behavior, the project implements comprehensive testing paradigms:
* **Unit Testing (`TestCases.java`):** Includes **23 robust test cases** verifying individual backend components, database connectivity, and validation constraints.
* **Behavioural Testing (`BehaviouralTest.java`):** Features **8 user-scenario simulations** checking the end-to-end workflow of features like role switching, restriction checks, and negative login flows.

---

## 🐳 Docker Containerization
The entire application ecosystem—including the Java environment, Python runtime, and MySQL database—is completely containerized for instant, zero-configuration deployment.

### Steps to Run via Docker:
1. Ensure **Docker Desktop** is running on your machine.
2. Open your terminal in the project root directory.
3. Execute the following command:
   ```bash
   docker-compose up --build

## ⚙️ Manual Installation & Setup (Alternative)
1. Install XAMPP and start the Apache & MySQL services.
2. Import the database file located at database/university_portal.sql via phpMyAdmin.
3. Open the project folder in NetBeans IDE.
4. Add mysql-connector-j-9.7.0.jar to the project's Libraries tab.
5. Clean and Build the project, then run Login.java to start the application.
6. For Web View: Open frontend/index.html using the Live Server extension in your browser.
7. For Analytics Manual Run: Open python/university_reports.ipynb in Jupyter Notebook and execute all cells.

--
## 🔑 Test Credentials

| Role | Username | Password |
| :--- | :--- | :--- |
| **Admin** | `admin` | `admin123` |
| **Faculty** | `sharma` | `sharma123` |
| **Student** | `tanisha` | `pass123` |

---

## 📁 Project Structure

```text
SmartUniversityPortal/
├── src/               # Java Source Code (Swing GUI, Testing & Business Logic)
├── database/          # MySQL Database Scripts & .sql dumps
├── frontend/          # HTML/CSS/JS Files for Web View
├── python/            # Jupyter Notebooks & generated charts (.png)
├── DOCS/              # ER Diagrams, DFDs, and Project Screenshots
├── Dockerfile         # Docker configuration file for the Java runtime
├── docker-compose.yml # Service orchestration for Java, MySQL & Python
└── README.md          # Project Documentation

--

## 🧑‍💻 Developer
Name: Tanisha Jain
Registration ID: 2314513802
Course: Bachelor of Computer Applications (BCA)
University: Manipal University Jaipur (MUJ)
Academic Year: 3rd Year Final Project

## 📄 LicenseThis is an academic project developed solely for evaluation purposes.
