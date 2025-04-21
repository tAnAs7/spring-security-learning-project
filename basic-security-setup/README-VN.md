# 🔐 Spring Security Learning Project

Dự án Spring Boot này tập trung vào các khía cạnh quan trọng của **Spring Security**, được chia thành nhiều branch riêng biệt. Mỗi branch chứa một trọng điểm chính cần triển khai để giúp hiểu rõ và ứng dụng bảo mật trong các hệ thống thực tế.

## 📌 **Mục tiêu chính**
> **Mục tiêu:** Thiết lập cấu hình cơ bản của Spring Security.
- Kích hoạt Spring Security.
- Xác thực người dùng bằng HTTP Basic Authentication.
- Hiểu cách Spring Security xử lý request.

## 🚀 **Bắt đầu**
```bash
git checkout basic-security-setup
```

## 🔐 Xác thực Basic Authentication

Spring Security sẽ yêu cầu xác thực bằng tên người dùng và mật khẩu khi bạn truy cập các tài nguyên được bảo vệ.

### 🔹 Kiểm tra bằng Postman
- Chọn một request GET: `http://localhost:8080/api/protected`
- Trong tab **Authorization**, chọn **Basic Auth**
- Nhập:
    - **Username:** `user`
    - **Password:** *(mật khẩu mặc định do Spring Security sinh ra)*

### 🔹 Kiểm tra bằng curl
```bash
curl -u user:password http://localhost:8080/api/protected
```

## 📁 Cấu trúc thư mục tiêu chuẩn
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