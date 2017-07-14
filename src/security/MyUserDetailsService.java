package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import database.Account;
import database.AccountRepository;

public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Account account = accountRepo.findByUsername(username);
		if (username==null) {
			throw new UsernameNotFoundException(username);
		}
		return new MyUserPrincipal(account);
	}
}
