package com.sample.login.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig{
	
	/** [bCryptPasswordEncoder]
	 * BCryptPasswordEncoder : password 암호화를 위해 BCryptPasswordEncoder클래스를 생성하여 빈에 등록
	 */
	@Bean
	public static BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/** [webSecurityCustomizer]
	 * WebSecurityCustomizer : resouces를 접근할수 있도록 빈 추가
	 */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring()
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
	
	/** [securityFilterChain]
	 * ● csrf : 로컬에서 확인을 위해 csrf를 비활성화
	 * ● authorizeHttpRequests : /(홈), /login(로그인 페이지), /join(회원가입 페이지)는 로그인 없이 접근하도록 세팅
	 * ● formLogin : /login 페이지를 커스터마이징 하여 로그인 체크를 할때 해당 url을 타도록 셋팅하고 로그인 성공시 /로 페이지 이동하도록 설정
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(requests -> requests
						.requestMatchers("/", "/login", "/join").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/", true)
						.permitAll()
				)
				.logout(logout -> logout
						.permitAll()
				);
		
		return http.build();
	}
	
}
