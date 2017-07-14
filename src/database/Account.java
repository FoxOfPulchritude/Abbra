package database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class Account {
	//Basic fields here
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private ArrayList<String> flags;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	//Fields not yet implemented
	private String IPAddress;
	private String lastLogin;
	
	public Account(String name, String password, String...flags) {
		this.username = name;
		this.password = password;
		for(String flag : flags)
			this.flags.add(flag);
	}
	
	
	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public ArrayList<String> getFlags() {
		return flags;
	}


	public int getId() {
		return id;
	}


	Account() {}
}
