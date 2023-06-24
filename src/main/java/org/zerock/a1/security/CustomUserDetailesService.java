package org.zerock.a1.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomUserDetailesService implements UserDetailsService{@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        log.info("loadUserByUsername : " + username);

        UserDetails user = User.builder()
        .username(username)
        .password("$2a$10$1UpErhUVvVFv6sAbQaBLS.JfQE94.JCXk1/UfyXj7aWrSlmIazNNG") // 1111이 인코딩 되어서 암호화 된 값
        .authorities("ROLE_USER", "ROLE_G1") // 권한을 부여 (uesrname에 USER,G1이라는 권한을 줌)
        .build();

        return user;
    }
    
}
