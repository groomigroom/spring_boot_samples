package site_user_postman.demo.pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { // 클래스 이름을 SecurityConfig로 명확히 변경

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users").permitAll() // Postman 주소 허용
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
