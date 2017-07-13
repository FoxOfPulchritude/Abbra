package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DatabaseLoader implements CommandLineRunner{
	
	private final AccountRepository MASTER;
	
	@Autowired
	public DatabaseLoader(AccountRepository master) {
		this.MASTER = master;
	}
	
	@Override
	public void run(String...strings) {
		this.MASTER.save(new Account("admin","mark","ADMIN"));
	}
}
