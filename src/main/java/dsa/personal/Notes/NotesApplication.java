package dsa.personal.Notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class NotesApplication {
	private static final Logger logger = LoggerFactory.getLogger(NotesApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

}
