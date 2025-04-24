package dev.tts.learning.spring_security.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SignatureException;
import java.util.Collections;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        // Kiểm tra xem header có hợp lệ và chứa token không
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Lấy token từ header

            try {
                // Kiểm tra tính hợp lệ của token
                Claims claims = JwtUtil.validateToken(token); // Chắc chắn validateToken trả về Claims hợp lệ
                String username = claims.getSubject();
                String role = claims.get("role", String.class);

                // Tạo đối tượng UserDetails từ thông tin trong token
                UserDetails userDetails = new User(username, "", Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role)));

                // Tạo đối tượng Authentication từ UserDetails
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Đặt Authentication vào SecurityContext
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (ExpiredJwtException e) {
                // Token hết hạn
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expired");
                return;
            } catch (MalformedJwtException e) {
                // Token không hợp lệ
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Malformed token");
                return;
            } catch (Exception e) {
                // Các lỗi chung khác
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                return;
            }
        }

        // Tiếp tục chuỗi filter nếu token hợp lệ hoặc không có token
        chain.doFilter(request, response);
    }

}
