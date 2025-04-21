package dev.tts.learning.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "Bạn đã truy cập vào endpoint được bảo vệ!";
    }
}
