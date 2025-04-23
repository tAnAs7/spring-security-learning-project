Here is the Vietnamese version of this README: [README-VN.md]()

---

# 🔐 Spring Security Learning Project

This Spring Boot project focuses on essential aspects of **Spring Security**, organized into separate branches. Each branch covers a core feature to help understand and apply security in real-world systems.

## 📌 **Main Objectives**
> **Objective:** Authenticate users using **JSON Web Tokens (JWT)**.
- Generate and sign JWT tokens for authentication.
- Secure REST APIs using JWT.
- Implement JWT refresh token mechanism.

## 🚀 **Getting Started**
```bash
git checkout jwt-authentication
```

## 📁 Project Structure
```
jwt-authentication/
└── src/
    ├── main/
    │   ├── java/dev/tts/learning/
    │   │       ├── bootstrap/                                      # Database configuration and initialization setup
    │   │       │   ├── DatabaseInitializer.java
    │   │       │   ├── DbConfig.java
    │   │       │   └── DbConfigLoader.java
    │   │       └── spring_security/                                 
    │   │           ├── config/                                     # Spring Security configuration and custom security handlers
    │   │           │   ├── CustomAuthenticationSuccessHandler.java
    │   │           │   └── SecurityConfig.java
    │   │           ├── controller/                                 # REST controllers handling user authentication and role-based endpoints
    │   │           │   ├── ActionController.java
    │   │           │   ├── AdminController.java
    │   │           │   ├── AuthController.java
    │   │           │   ├── HelloController.java
    │   │           │   ├── RedirectController.java
    │   │           │   └── UserController.java
    │   │           ├── model/                                      # Domain models, DTOs, enums, and entities
    │   │           │   ├── dto/
    │   │           │   │   ├── LoginRequest.java
    │   │           │   │   └── SignupRequest.java
    │   │           │   ├── enums/
    │   │           │   │   ├── EntityStatus.java
    │   │           │   │   ├── Role.java
    │   │           │   │   └── TokenStatus.java
    │   │           │   ├── RefreshToken.java
    │   │           │   ├── UserEntity.java
    │   │           │   └── UserInfoEntity.java
    │   │           ├── repository/                                 # JPA repositories for data persistence
    │   │           │   ├── RefreshTokenRepository.java
    │   │           │   ├── UserInfoRepository.java
    │   │           │   └── UserRepository.java
    │   │           ├── security/                                   # JWT utility and security filters
    │   │           │   ├── JwtAuthenticationFilter.java
    │   │           │   └── JwtUtil.java
    │   │           ├── service/                                    # Service interfaces and business logic implementations
    │   │           │   ├── impl/
    │   │           │   │   ├── AuthServiceImpl.java
    │   │           │   │   └── RefreshTokenServiceImpl.java
    │   │           │   ├── AuthService.java
    │   │           │   ├── CustomUserDetails.java
    │   │           │   ├── CustomUserDetailsService.java
    │   │           │   └── RefreshTokenService.java
    │   │           └── JwtAuthenticationApplication.java
    │   ├── resources/                                              # Application configuration files and static/template directories
    │   │   ├── static/                                             # Static assets like CSS, JS, images
    │   │   │   └── style.css
    │   │   ├── templates/                                          # Thymeleaf HTML templates for UI views
    │   │   │   ├── admin_dashboard.html
    │   │   │   ├── login.html
    │   │   │   ├── signup.html
    │   │   │   └── user_profile.html
    │   │   └── application.properties
    │── .gitignore
    │── pom.xml
    ├── README.md
    └── README-VN.md
```