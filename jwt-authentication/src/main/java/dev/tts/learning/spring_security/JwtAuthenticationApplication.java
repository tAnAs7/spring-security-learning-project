package dev.tts.learning.spring_security;

import dev.tts.learning.bootstrap.DatabaseInitializer;
import dev.tts.learning.bootstrap.DbConfig;
import dev.tts.learning.bootstrap.DbConfigLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthenticationApplication {

	public static void main(String[] args) {
		DbConfig config = DbConfigLoader.load();
		DatabaseInitializer.initDatabase(
				config.host, config.port, config.dbName, config.username, config.password
		);
		SpringApplication.run(JwtAuthenticationApplication.class, args);
	}

}
