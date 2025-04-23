package dev.tts.learning.bootstrap;

import java.sql.*;

public class DatabaseInitializer {

    public static void initDatabase(String host, String port, String dbName, String username, String password) {
        String adminUrl = String.format("jdbc:postgresql://%s:%s/postgres", host, port);
        try (Connection connection = DriverManager.getConnection(adminUrl, username, password)) {
            if (!databaseExists(connection, dbName)) {
                createDatabase(connection, dbName);
                System.out.println("✅ Created database: " + dbName);
            } else {
                System.out.println("ℹ️ Database already exists: " + dbName);
            }
        } catch (SQLException e) {
            System.err.println("❌ Database init failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean databaseExists(Connection conn, String dbName) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM pg_database WHERE datname = ?")) {
            stmt.setString(1, dbName);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private static void createDatabase(Connection conn, String dbName) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE \"" + dbName + "\"");
        }
    }
}
