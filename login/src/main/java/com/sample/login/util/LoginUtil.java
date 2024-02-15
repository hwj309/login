package com.sample.login.util;

import org.springframework.security.core.context.SecurityContextHolder;


/**
 * 로그인 여부를 확인하기 위해 util파일을 만들어 주었습니다
 */
public class LoginUtil {

	public static boolean isLogin() {
		boolean result = true;
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof String) {
			result = false;
		}
		
		return result;
	}
	
}
