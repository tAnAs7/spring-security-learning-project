package dev.tts.learning.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfigLoader {
    public static DbConfig load() {
        Properties props = new Properties();
        try (InputStream input = DbConfigLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("❌ Cannot find application.properties in classpath");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load DB config: " + e.getMessage(), e);
        }

        String url = props.getProperty("spring.datasource.url");
        String username = props.getProperty("spring.datasource.username");
        String password = props.getProperty("spring.datasource.password");

        if (url == null || username == null || password == null) {
            throw new RuntimeException("❌ Missing spring.datasource.* properties");
        }

        // Parse DB info
        // Format expected: jdbc:postgresql://host:port/dbName
        String[] parts = url.replace("jdbc:postgresql://", "").split("/");
        String[] hostPort = parts[0].split(":");

        return new DbConfig(
                hostPort[0],
                hostPort.length > 1 ? hostPort[1] : "5432",
                parts[1],
                username,
                password
        );
    }
}