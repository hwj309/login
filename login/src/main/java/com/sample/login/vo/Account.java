package com.sample.login.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

/**
 * 사용자 VO에 UserDetails 인터페이스를 상속받으면 html에서 뿐아니라 백앤드단에서도 로그인되어있을때 자유롭게 로그인 체크나 로그인 데이터를 가져와서 체크를 할수 있습니다
 */

@Getter
@Setter
public class Account implements UserDetails {
	private String id;
	private String passwd;
	private String authority;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.passwd;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
