package com.vennygo.config;

import com.vennygo.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                /* 커스텀 로그인 페이지를 설정합니다. "/login" 페이지는 누구나 접근할 수 있도록 허용합니다.
                    .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )*/
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/favicon.ico",
                                "/sign-in/**", "/api/sign-in/**", "/sign-up/**"
                                ,"/about/**").permitAll()
                        /*.requestMatchers("/about/**").hasRole(Role.USER.name())*/
                        .requestMatchers("/api/hello/**").hasRole(Role.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}