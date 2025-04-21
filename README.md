Here is the Vietnamese version of this README: [README-VN.md](https://github.com/tAnAs7/spring-security-learning-project/blob/95cf9aeff388d5ffd8efaf4a775248a730cdfbc2/README-VN.md)

---

# 🔐 Spring Security Learning Project

This Spring Boot project focuses on essential aspects of **Spring Security**, organized into separate branches. Each branch covers a core feature to help understand and apply security in real-world systems.

## 📌 **Branch List and Main Objectives**

### 1️⃣ `basic-security-setup`
> **Objective:** Set up basic Spring Security configuration.
- Enable Spring Security.
- Authenticate users using HTTP Basic Authentication.
- Understand how Spring Security handles requests.

### 2️⃣ `form-login-authentication`
> **Objective:** Authenticate users via form-based login.
- Create a custom login page.
- Authenticate users with username and password.
- Use session management for login state.

### 3️⃣ `role-based-authorization`
> **Objective:** Implement user authorization using **Role-Based Access Control (RBAC)**.
- Define roles (`ADMIN`, `USER`).
- Control access using `@PreAuthorize` and `@Secured`.
- Protect endpoints based on user roles.

### 4️⃣ `jwt-authentication`
> **Objective:** Authenticate users using **JSON Web Tokens (JWT)**.
- Generate and sign JWT tokens for authentication.
- Secure REST APIs using JWT.
- Implement JWT refresh token mechanism.

### 5️⃣ `oauth2-authentication`
> **Objective:** Integrate OAuth2 authentication with external providers.
- Authenticate using Google, Facebook.
- Handle tokens from OAuth2 providers.
- Secure applications with OAuth2 Authorization Server.

### 6️⃣ `custom-user-details`
> **Objective:** Manage users using a database.
- Use **UserDetailsService** to retrieve user data.
- Integrate MySQL/PostgreSQL with Spring Security.
- Secure user data within the system.

### 7️⃣ `two-factor-authentication`
> **Objective:** Implement **Two-Factor Authentication (2FA)** for enhanced security.
- Generate and send OTP codes via email or SMS.
- Validate OTP codes before login is successful.
- Integrate 2FA authentication libraries.

### 8️⃣ `csrf-protection`
> **Objective:** Understand and protect against **Cross-Site Request Forgery (CSRF)**.
- Enable CSRF protection in Spring Security.
- Use CSRF tokens in stateful requests.
- Explain practical CSRF control in real-world applications.

### 9️⃣ `session-management`
> **Objective:** Manage user login sessions.
- Limit concurrent sessions per user.
- Log out from all devices.
- Control session timeout for user protection.

### 🔟 `spring-security-reactive`
> **Objective:** Apply Spring Security to **Reactive systems (WebFlux)**.
- Asynchronous user authentication.
- Secure APIs using JWT and OAuth2 in **WebFlux**.
- Integrate security in non-blocking environments.

## 🎯 **Branch `final-production`**
After completing the above branches, all security features will be consolidated into the **`final-production`** branch. This will include a **Microservices architecture with an API Gateway** for a fully secure system.

## 📌 **Usage Guide**
- Select the branch you want to study and check it out (`git checkout <branch-name>`).
- Read the documentation within each branch for implementation details.
- Run the application and test the integrated security features.

## ⚙️ **Prerequisites**
Before starting, make sure you have the following tools and libraries:
- **Java 17+** (*OpenJDK 17 or higher recommended*)
- **Maven** (*dependency management*)
- **Spring Boot 3.x** (*project structure based on latest version*)
- **IntelliJ IDEA**
- **Docker** (*optional, for running databases or authentication services in containers*)
- **PostgreSQL** (*optional if using a database for UserDetailsService*)
- **Postman** (*to test API security*)

## 🚀 **Getting Started**
```bash
git clone https://github.com/tAnAs7/spring-security-learning-project.git
cd spring-security-learning-project
```

💡 **Start with the `basic-security-setup` branch and progressively build more complex features.**

```bash
git checkout basic-security-setup
```

---

🚀 **Start learning Spring Security today!**
