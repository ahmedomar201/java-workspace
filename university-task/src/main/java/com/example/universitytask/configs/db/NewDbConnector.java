package com.example.universitytask.configs.db;

import java.util.Objects;

public class NewDbConnector {
    private final String username;
    private final String password;
    private final String database;
    private final String url;
    private final ConnectionPool connectionPool;

    public NewDbConnector(String username, String password, String database, String url, ConnectionPool connectionPool) {
        this.username = username;
        this.password = password;
        this.database = database;
        this.url = url;
        this.connectionPool = connectionPool;
        connect(username, password, database, url, connectionPool);
    }

    private void connect(
            final String username,
            final String password,
            final String database,
            final String url,
            final ConnectionPool connectionPool
    ) {
        System.out.println("New Connecting to database " + database + "with username " + username + "and url " + url);
        System.out.println("New Successfully connected to database " + database + "with url " + url);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getUrl() {
        return url;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NewDbConnector that)) return false;
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
