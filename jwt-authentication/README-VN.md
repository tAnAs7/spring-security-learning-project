# 🔐 Spring Security Learning Project

Dự án Spring Boot này tập trung vào các khía cạnh quan trọng của **Spring Security**, được chia thành nhiều branch riêng biệt. Mỗi branch chứa một trọng điểm chính cần triển khai để giúp hiểu rõ và ứng dụng bảo mật trong các hệ thống thực tế.

## 📌 **Mục tiêu chính**
> **Mục tiêu:** Xác thực người dùng bằng **JSON Web Token (JWT)**.
- Tạo và ký JWT token để xác thực.
- Bảo vệ API REST bằng JWT.
- Cơ chế làm mới (refresh token) JWT.

## 🚀 **Bắt đầu**
```bash
git checkout jwt-authentication
```

## 📁 Cấu trúc thư mục
```
jwt-authentication/
└── src/
    ├── main/
    │   ├── java/dev/tts/learning/
    │   │       ├── bootstrap/                                      # Cấu hình và khởi tạo cơ sở dữ liệu
    │   │       │   ├── DatabaseInitializer.java
    │   │       │   ├── DbConfig.java
    │   │       │   └── DbConfigLoader.java
    │   │       └── spring_security/                                 
    │   │           ├── config/                                     # Cấu hình Spring Security và xử lý bảo mật tùy chỉnh
    │   │           │   ├── CustomAuthenticationSuccessHandler.java
    │   │           │   └── SecurityConfig.java
    │   │           ├── controller/                                 # Các controller xử lý API xác thực và phân quyền
    │   │           │   ├── ActionController.java
    │   │           │   ├── AdminController.java
    │   │           │   ├── AuthController.java
    │   │           │   ├── HelloController.java
    │   │           │   ├── RedirectController.java
    │   │           │   └── UserController.java
    │   │           ├── model/                                      # Các model domain, DTO, enum và entity
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
    │   │           ├── repository/                                 # Các repository dùng để truy xuất dữ liệu
    │   │           │   ├── RefreshTokenRepository.java
    │   │           │   ├── UserInfoRepository.java
    │   │           │   └── UserRepository.java
    │   │           ├── security/                                   # Bộ lọc và tiện ích JWT
    │   │           │   ├── JwtAuthenticationFilter.java
    │   │           │   └── JwtUtil.java
    │   │           ├── service/                                    # Interface và logic nghiệp vụ của các dịch vụ
    │   │           │   ├── impl/
    │   │           │   │   ├── AuthServiceImpl.java
    │   │           │   │   └── RefreshTokenServiceImpl.java
    │   │           │   ├── AuthService.java
    │   │           │   ├── CustomUserDetails.java
    │   │           │   ├── CustomUserDetailsService.java
    │   │           │   └── RefreshTokenService.java
    │   │           └── JwtAuthenticationApplication.java
    │   ├── resources/                                              # Tệp cấu hình và thư mục tài nguyên của ứng dụng
    │   │   ├── static/                                             # Tài nguyên tĩnh như CSS, JS, hình ảnh
    │   │   │   └── style.css
    │   │   ├── templates/                                          # Các giao diện HTML sử dụng Thymeleaf
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