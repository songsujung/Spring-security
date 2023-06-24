package org.zerock.a1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableMethodSecurity // 컨트롤러에서 preAutorize를 사용하게끔 해주는 어노테이션
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http)throws Exception {
        log.info("-----------------------configuration---------------------");

        http.formLogin(Customizer.withDefaults()); // 로그인 폼을 만들어 줌

        // // Login이 안되면 페이지 못넘어가게 막고 다시 Login창으로 보내는 코드 (@EnableMethodSecurity로 더 쉽게 사용 가능)
        // http.authorizeHttpRequests(requests -> {

        // requests.anyRequest().authenticated();

        // });

        return http.build();
    }

    @Bean // 이 메소드의 결과를 Bean으로 등록하겠다!
    public PasswordEncoder passwordEncoder(){

        // 비밀번호를 암호화 하는데 사용하는 메소드를 가진 클래스
        return new BCryptPasswordEncoder();
    }
    
}
