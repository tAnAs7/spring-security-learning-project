package dev.tts.learning.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    @GetMapping("user/profile/{username}")
    public String userProfilePage(Model model, @PathVariable String username) {
//        return "Chào mừng USER! Đây là trang hồ sơ của bạn.";
        model.addAttribute("username", username);
        return "user_profile";
    }
}
