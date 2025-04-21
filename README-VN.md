# 🔐 Spring Security Learning Project

Dự án Spring Boot này tập trung vào các khía cạnh quan trọng của **Spring Security**, được chia thành nhiều branch riêng biệt. Mỗi branch chứa một trọng điểm chính cần triển khai để giúp hiểu rõ và ứng dụng bảo mật trong các hệ thống thực tế.

## 📌 **Danh sách branch và mục tiêu chính**

### 1️⃣ `basic-security-setup`
> **Mục tiêu:** Thiết lập cấu hình cơ bản của Spring Security.
- Kích hoạt Spring Security.
- Xác thực người dùng bằng HTTP Basic Authentication.
- Hiểu cách Spring Security xử lý request.

### 2️⃣ `form-login-authentication`
> **Mục tiêu:** Xác thực người dùng bằng giao diện form login.
- Tạo trang đăng nhập tùy chỉnh.
- Xác thực người dùng với username và password.
- Sử dụng session để quản lý trạng thái đăng nhập.

### 3️⃣ `role-based-authorization`
> **Mục tiêu:** Phân quyền người dùng dựa trên **Role-Based Access Control (RBAC)**.
- Định nghĩa các role (`ADMIN`, `USER`).
- Kiểm soát quyền truy cập bằng `@PreAuthorize` và `@Secured`.
- Bảo vệ endpoint theo role của từng người dùng.

### 4️⃣ `jwt-authentication`
> **Mục tiêu:** Xác thực người dùng bằng **JSON Web Token (JWT)**.
- Tạo và ký JWT token để xác thực.
- Bảo vệ API REST bằng JWT.
- Cơ chế làm mới (refresh token) JWT.

### 5️⃣ `oauth2-authentication`
> **Mục tiêu:** Tích hợp xác thực OAuth2 với các nhà cung cấp bên ngoài.
- Xác thực qua Google, Facebook.
- Xử lý token từ OAuth2 provider.
- Bảo mật ứng dụng với OAuth2 Authorization Server.

### 6️⃣ `custom-user-details`
> **Mục tiêu:** Quản lý người dùng bằng cơ sở dữ liệu.
- Sử dụng **UserDetailsService** để truy xuất thông tin người dùng.
- Tích hợp MySQL/PostgreSQL với Spring Security.
- Bảo mật dữ liệu người dùng trong hệ thống.

### 7️⃣ `two-factor-authentication`
> **Mục tiêu:** Kết hợp xác thực **2 yếu tố (2FA)** để tăng cường bảo mật.
- Tạo và gửi mã OTP qua email hoặc SMS.
- Xác thực mã OTP trước khi đăng nhập thành công.
- Tích hợp thư viện xác thực hai yếu tố.

### 8️⃣ `csrf-protection`
> **Mục tiêu:** Hiểu và bảo vệ ứng dụng khỏi **Cross-Site Request Forgery (CSRF)**.
- Kích hoạt CSRF protection trong Spring Security.
- Sử dụng CSRF token trong các request có trạng thái (stateful).
- Giải thích cách kiểm soát CSRF trong ứng dụng thực tế.

### 9️⃣ `session-management`
> **Mục tiêu:** Quản lý phiên đăng nhập của người dùng.
- Giới hạn số phiên đăng nhập đồng thời.
- Đăng xuất khỏi tất cả thiết bị.
- Kiểm soát session timeout để bảo vệ người dùng.

### 🔟 `spring-security-reactive`
> **Mục tiêu:** Ứng dụng Spring Security vào hệ thống **Reactive (WebFlux)**.
- Xác thực người dùng không đồng bộ.
- Bảo vệ API sử dụng JWT và OAuth2 trong **WebFlux**.
- Tích hợp bảo mật trong môi trường không đồng bộ.

## 🎯 **Branch `final-production`**
Sau khi hoàn thành các branch trên, chúng ta sẽ tổng hợp toàn bộ tính năng bảo mật vào branch **`final-production`**, triển khai kiến trúc **Microservices với API Gateway** để có một hệ thống bảo mật hoàn chỉnh.

## 📌 **Hướng dẫn sử dụng**
- Chọn branch cần nghiên cứu và checkout (`git checkout <branch-name>`).
- Đọc tài liệu hướng dẫn trong mỗi branch để hiểu cách triển khai.
- Chạy ứng dụng và kiểm tra các tính năng bảo mật đã tích hợp.

## ⚙️ **Yêu cầu tiên quyết**
Trước khi bắt đầu, bạn cần chuẩn bị một số công cụ và thư viện sau:
- **Java 17+** (*khuyến nghị sử dụng OpenJDK 17 hoặc cao hơn*)
- **Maven** (*quản lý dependencies*)
- **Spring Boot 3.x** (*cấu trúc dự án dựa trên phiên bản mới nhất*)
- **IntelliJ IDEA**
- **Docker** (*nếu muốn chạy database hoặc dịch vụ authentication trong container*)
- **PostgreSQL** (*tùy chọn nếu dùng database cho UserDetailsService*)
- **Postman** (*để test API security*)

## 🚀 **Bắt đầu dự án**
```bash
git clone https://github.com/tAnAs7/spring-security-learning-project.git
cd spring-security-learning-project
```

💡 **Hãy bắt đầu với branch `basic-security-setup` và dần dần triển khai các tính năng phức tạp hơn.**

```bash
git checkout basic-security-setup
```
---

🚀 **Bắt đầu học Spring Security ngay hôm nay!**
