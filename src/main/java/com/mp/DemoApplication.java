package com.mp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mp.database.article.Article;
import com.mp.database.article.ArticleRepo;
import com.mp.database.message.Message;
import com.mp.database.message.MessageRepo;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner databaseTest(ArticleRepo repo) {
		return (args) -> {
			repo.save(new Article("Sample Article 1","This is a sample article."));
			repo.save(new Article("Sample Article 2","This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article. This is a sample article."));
			log.warn("The article is being saved. ");
			log.warn("There are " + repo.count() + " articles in the DB.");
		};
	}
	
	@Bean
	public CommandLineRunner messageTest(MessageRepo repo) {
		ArrayList<Message> testBatch = new ArrayList<Message>();
		for(int i = 0; i < 25; i++) {
			testBatch.add(new Message("markp", "foobar", (new Date()), "Hello, this is a message."));
			testBatch.add(new Message("foobar", "markp", (new Date()), "Hello, this is a message."));
		}
		return (args) -> {
			repo.save(testBatch);
			List<Message> myMsg = repo.findBySenderUid("markp");
			log.warn("There are " + myMsg.size() + " messages for you");
		};
	}
	
}
