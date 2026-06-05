# ============================================================
# Dockerfile — Smart University Portal
# Author: Tanisha Jain | Reg: 2314513802
# Project: Smart University Portal with Real-Time Tracking System
# ============================================================

# Base image — Java 17 (same version used in development)
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Add metadata labels
LABEL maintainer="Tanisha Jain <2314513802@muj.manipal.edu>"
LABEL project="Smart University Portal with Real-Time Tracking System"
LABEL version="1.0"
LABEL description="BCA Final Year Project - Manipal University Jaipur"

# Copy the compiled JAR file into container
# (Build the project in NetBeans first — dist/ folder mein JAR banta hai)
COPY dist/SmartUniversityPortal.jar /app/SmartUniversityPortal.jar

# Copy database SQL script
COPY database/university_portal.sql /app/university_portal.sql

# Copy Python analytics scripts
COPY python/ /app/python/

# Environment variables for database connection
# These will be overridden by docker-compose.yml
ENV DB_HOST=mysql-db
ENV DB_PORT=3306
ENV DB_NAME=university_portal
ENV DB_USER=root
ENV DB_PASSWORD=root123

# Expose port (for future web version)
EXPOSE 8080

# Wait for MySQL to be ready, then run the application
# Note: Swing GUI requires display — use with X11 forwarding or VNC
CMD ["java", "-jar", "/app/SmartUniversityPortal.jar"]
