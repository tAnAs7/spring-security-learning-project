Here is the Vietnamese version of this README: [README-VN.md]()

---

# 🔐 Spring Security Learning Project

This Spring Boot project focuses on essential aspects of **Spring Security**, organized into separate branches. Each branch covers a core feature to help understand and apply security in real-world systems.

## 📌 **Main Objectives**
> **Objective:** Authenticate users via form-based login.
- Create a custom login page.
- Authenticate users with username and password.
- Use session management for login state.

## 🚀 **Getting Started**
```bash
git checkout form-login-authentication
```

## 📁 Project Structure
```
basic-security-setup/
│── src/
│   ├── main/
│   │   ├── java/dev/tts/learning/spring_security
│   │   │   ├── config/                         # Security configuration
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/                     # Controllers to handle requests
│   │   │   │   └── HelloController.java
│   │   │   └── SpringSecurityApplication.java  # Application entry point
│   │   ├── resources/
│   │   │   └── application.properties          # Application configuration
│── .gitignore                                  # Files to be ignored by Git
│── pom.xml                                     # Dependencies (if using Maven)
│── README.md                                   # Guide for the `basic-security-setup` branch
└── README-VN.md                                # Guide for the `basic-security-setup` branch in vietnamese
```