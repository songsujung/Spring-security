package org.zerock.a1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class A1ApplicationTests {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void testEncode(){
		
		String pw = "1111"; // 서비스에서 builder로 pw로 지정한 값을 적어줌

		String enPw = passwordEncoder.encode(pw); // pw를 인코딩을 하여 암호화된 값을 enPw라는 변수에 저장

		log.info("---------------------");
		log.info(enPw);

		boolean result = passwordEncoder.matches("1111", enPw); // 1111이 비밀번호로 가능한지 판단
		
		log.info(result); // 가능하다면 true가 나옴

	}

}
