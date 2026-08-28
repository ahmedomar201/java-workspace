package com.example.rest.models.db;

import java.util.Objects;

public class DbConnector {
    private String username;
    private String password;
    private String database;
    private String url;
    private ConnectionPool connectionPool;

    public DbConnector(String username, String password, String database, String url, ConnectionPool connectionPool) {
        this.username = username;
        this.password = password;
        this.database = database;
        this.url = url;
        this.connectionPool = connectionPool;
        connect(username, password, database, url, connectionPool);
    }

    public void connect(
            final String username,
            final String password,
            final String database,
            final String url,
            final ConnectionPool connectionPool
    ) {
        System.out.println("Connecting to database " + database + "with username " + username + "and url " + url);
        System.out.println("Successfully connected to database " + database + "with url " + url);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DbConnector that)) return false;
        return Objects.equals(username, that.username)
                && Objects.equals(password, that.password)
                && Objects.equals(database, that.database)
                && Objects.equals(url, that.url)
                && Objects.equals(connectionPool, that.connectionPool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, database, url, connectionPool);
    }
}
