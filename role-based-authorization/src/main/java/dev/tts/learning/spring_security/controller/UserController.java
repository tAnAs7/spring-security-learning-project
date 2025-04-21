package dev.tts.learning.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("user/profile")
    public String userProfilePage() {
//        return "Chào mừng USER! Đây là trang hồ sơ của bạn.";
        return "user_profile";
    }
}
