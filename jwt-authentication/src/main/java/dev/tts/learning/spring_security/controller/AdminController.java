package dev.tts.learning.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {
    @GetMapping("admin/dashboard")
    public String adminDashboard() {
//        return "Chào mừng ADMIN! Đây là trang dashboard của bạn.";
        return "admin_dashboard";
    }
}
