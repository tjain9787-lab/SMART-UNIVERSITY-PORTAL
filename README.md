# Smart University Portal with Real-Time Tracking System

## Overview
The Smart University Portal with Real-Time Tracking System is a comprehensive university management application developed as a Bachelor of Computer Application (BCA) final year project.

The system is designed to automate and simplify university administrative and academic processes such as student management, faculty management, course management, attendance tracking, result management, fee management, and analytical reporting.
The project provides role-based access control for Administrators, Faculty Members, and Students.

## Features
### Authentication & Authorization
* Secure Login System
* Role-Based Access Control
* Separate Dashboards for Admin, Faculty, and Student

### Student Management
* Add Student
* Update Student
* Delete Student
* Search Student

### Faculty Management
* Add Faculty
* Update Faculty
* Delete Faculty

### Course Management
* Create Courses
* Assign Faculty
* Manage Credits and Semester Information

### Attendance Tracking
* Mark Attendance
* View Attendance Summary
* Attendance Percentage Calculation
* Attendance Threshold Monitoring

### Result Management
* Enter Marks
* Automatic Grade Calculation
* View Student Results

### Fee Management
* Track Fee Status
* Paid / Pending / Overdue Categories
* Payment History Management

### Reports & Analytics
* Attendance Reports
* Academic Performance Analysis
* Fee Collection Analytics
* Python-Based Data Visualization

  
## 💻 Technology Stack

| Technology | Purpose |
| :--- | :--- |
| **Java (JDK 17)** | Core Application Logic |
| **Java Swing** | Desktop Graphical User Interface (GUI) |
| **MySQL** | Relational Database Management |
| **JDBC** | Database Connectivity |
| **HTML5 & CSS3** | Web Frontend Interface (Supplementary/Student View) |
| **Python (Pandas, Matplotlib)** | Data Analysis & Analytics Graph Generation |
| **XAMPP** | Local Database Server (phpMyAdmin) |


## Installation & Setup

1. Install XAMPP and start Apache + MySQL
2. Import `database/university_portal.sql` in phpMyAdmin
3. Open project in NetBeans (JDK 17)
4. Add mysql-connector-j-9.7.0.jar to Libraries
5. Run `Login.java` to start application

**For Frontend:**
- Open `frontend/index.html` in browser with Live Server extension

**For Analytics:**
- Open `python/university_reports.ipynb` in Jupyter Notebook
- Run all cells to generate charts


## Test Credentials
| Role | Username | Password |
|------|----------|----------|
| Admin | admin | admin123 |
| Faculty | sharma | sharma123 |
| Student | tanisha | pass123 |

## 🧪 Testing
- Unit Tests: `src/smartuniversityportal/TestCases.java` (23 test cases)
- Behavioural Tests: `src/smartuniversityportal/BehaviouralTest.java` (8 scenarios)

## 🤖 AI Module
- Rule-based recommendation engine: `AIRecommendation.java`
- Features: Attendance analysis, risk assessment, grade prediction

## 🐳 Docker
docker-compose up --build


## Database Tables
* users
* students
* faculty
* courses
* attendance
* results
* fees


## 📁 Project Structure

```text
SmartUniversityPortal/
├── src/               # Java Source Code (Swing GUI & Logic)
├── database/          # MySQL Database Scripts (.sql files)
├── frontend/          # HTML/CSS Files for Web View
├── python/            # Jupyter Notebooks for Analytics & Charts
├── DOCS/              # ER Diagram, DFD, and Project Screenshots
└── README.md          # Project Documentation


## Repository
**GitHub:** https://github.com/tjain9787-lab/SMART-UNIVERSITY-PORTAL

  
## Developer
- Name: Tanisha Jain
- Course: BCA (Online) - Manipal University Jaipur
- Year: 3rd Year Final Project


## License
This is an academic project. No commercial use without permission.
