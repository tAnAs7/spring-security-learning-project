package dev.tts.learning.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/protected").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(); // 'httpBasic()' is deprecated and marked for removal*/

        /*http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/protected").authenticated()
                        .anyRequest().permitAll()
                )
                .apply(new HttpBasicConfigurer<>()); // 'apply(C)' is deprecated and marked for removal */

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/protected").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults()); // Modern replacement for deprecated httpBasic()
        return http.build();
    }
}
