package dev.tts.learning.spring_security.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String redirectUrl = "/login";

        // Lấy username từ authentication
        String username;
        if (authentication instanceof OAuth2AuthenticationToken) {
            username = ((OAuth2AuthenticationToken) authentication).getPrincipal().getAttribute("email");
            if (((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId().equals("google")) {
                if (authentication.getAuthorities().stream()
                        .anyMatch(authority -> authority.getAuthority().equals("OIDC_ADMIN"))) {
                    redirectUrl = "/admin/dashboard";
                } else {
                    redirectUrl = "/user/profile/" + username;
                }
            } else {
                if (authentication.getAuthorities().stream()
                        .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
                    redirectUrl = "/admin/dashboard";
                } else {
                    redirectUrl = "/user/profile/" + username;
                }
            }
        }

        response.sendRedirect(redirectUrl); // Điều hướng người dùng sau đăng nhập
    }
}