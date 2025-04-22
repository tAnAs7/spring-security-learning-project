package dev.tts.learning.spring_security.controller;

import dev.tts.learning.spring_security.model.dto.LoginRequest;
import dev.tts.learning.spring_security.model.dto.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActionController {

    private final AuthController authController;

    public ActionController(AuthController authController) {
        this.authController = authController;
    }

    @PostMapping("/signup")
    public String handleSignup(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String retype_password,
            Model model
    ) {
        if (!password.equals(retype_password)) {
            model.addAttribute("error", "Mật khẩu không khớp");
            return "signup";
        }

        SignupRequest request = new SignupRequest(username, password);
        ResponseEntity<?> response = authController.signup(request);

        if (!response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("error", response.getBody());
            return "signup";
        }

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        LoginRequest request = new LoginRequest(username, password);
        ResponseEntity<?> response = authController.login(request);

        if (!response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("error", response.getBody());
            return "login";
        }
        return null;
    }
}

