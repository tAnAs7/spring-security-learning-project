# 🔐 Spring Security Learning Project

Dự án Spring Boot này tập trung vào các khía cạnh quan trọng của **Spring Security**, được chia thành nhiều branch riêng biệt. Mỗi branch chứa một trọng điểm chính cần triển khai để giúp hiểu rõ và ứng dụng bảo mật trong các hệ thống thực tế.

## 📌 **Mục tiêu chính**
> **Mục tiêu:** Xác thực người dùng bằng giao diện form login.
- Tạo trang đăng nhập tùy chỉnh.
- Xác thực người dùng với username và password.
- Sử dụng session để quản lý trạng thái đăng nhập.

## 🚀 **Bắt đầu**
```bash
git checkout form-login-authentication
```

## 📁 Cấu trúc thư mục
```
basic-security-setup/
│── src/
│   ├── main/
│   │   ├── java/dev/tts/learning/spring_security
│   │   │   ├── config/                         # Cấu hình bảo mật
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/                     # Controllers xử lý request
│   │   │   │   └── HelloController.java
│   │   │   └── SpringSecurityApplication.java  # Entry point của ứng dụng
│   │   ├── resources/
│   │   │   └── application.properties          # Cấu hình ứng dụng
│── .gitignore                                  # Các file bị loại khỏi Git
│── pom.xml                                     # Khai báo dependencies (nếu dùng Maven)
│── README.md                                   # Tài liệu hướng dẫn branch `basic-security-setup`
└── README-VN.md                                # Tài liệu hướng dẫn bằng tiếng Việt cho branch `basic-security-setup`
```