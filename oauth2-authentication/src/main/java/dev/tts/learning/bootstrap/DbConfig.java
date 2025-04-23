package dev.tts.learning.bootstrap;

public class DbConfig {
    public final String host;
    public final String port;
    public final String dbName;
    public final String username;
    public final String password;

    public DbConfig(String host, String port, String dbName, String username, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }
}
