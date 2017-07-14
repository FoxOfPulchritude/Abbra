package security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import database.Account;

public class MyUserPrincipal implements UserDetails {
	private Account account;
	
	public MyUserPrincipal(Account account) {
		this.account=account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getGrantedAuthorities();
	}
	
	private List<GrantedAuthority> getGrantedAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : account.getFlags())
			authorities.add(new SimpleGrantedAuthority(privilege));
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}