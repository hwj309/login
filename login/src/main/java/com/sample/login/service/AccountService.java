package com.sample.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sample.login.vo.Account;

import lombok.RequiredArgsConstructor;

/**
 * 로그인 페이지에서 로그인을 할때 url호출없이 service를 이용할수 있는 로직을 spring security에서 제공해줍니다
 */

/**
 * UserDetailsService 인터페이스를 상속받아 loadUserByUsername 메서드를 오버라이딩 하여 로그인시 로그인 체크를 할수 있도록 로직을 구현하였습니다
 */

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

//	private final UserDao userDao;
	private final BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = new Account();
		account.setId(username);
//		account = userDao.findUser(account);
		if(account != null) {
			List<GrantedAuthority> authorities = new ArrayList();
			return new User(account.getId(), account.getPasswd(), authorities);
		}
		return null;
	}
	
//	@Transactional
	public boolean join(String userId, String userPwd) {
		Account checkUser = new Account();
		checkUser.setId(userId);
		
//		if(userDao.findUser(checkUser) != null) {
//			return false;
//		}
		Account newUser = new Account();
		newUser.setId(userId);
		newUser.setPasswd(encoder.encode(userPwd));
//		userDao.save(newUser);
		return true;
	}
	
}
