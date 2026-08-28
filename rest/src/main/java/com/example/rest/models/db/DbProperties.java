package com.example.rest.models.db;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@ConfigurationProperties(prefix = "db")
public class DbProperties {
    private final String username;
    private final String password;
    private final String database;
    private final String url;
    @Valid
    private final ConnectionPoolProperties connectionPoolProperties;

    public DbProperties(String username, String password, String database, String url,
                        ConnectionPoolProperties connectionPoolProperties) {
        this.username = username;
        this.password = password;
        this.database = database;
        this.url = url;
        this.connectionPoolProperties = connectionPoolProperties;
    }

    public static class ConnectionPoolProperties {
        private final int maxOpenConnections;
        private final int maxIdleConnections;
        @Min(value = 100, message = "Timeout must not not be below 100 ms")
        @Max(value = 2000, message = "Timeout must not exceeds 2000 ms")
        private final int timeout;

        public ConnectionPoolProperties(int maxOpenConnections, int maxIdleConnections, int timeout) {
            this.maxOpenConnections = maxOpenConnections;
            this.maxIdleConnections = maxIdleConnections;
            this.timeout = timeout;
        }

        public int getMaxOpenConnections() {
            return maxOpenConnections;
        }

        public int getMaxIdleConnections() {
            return maxIdleConnections;
        }

        public int getTimeout() {
            return timeout;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ConnectionPoolProperties that)) return false;
            return maxOpenConnections == that.maxOpenConnections
                    && maxIdleConnections == that.maxIdleConnections
                    && timeout == that.timeout;
        }

        @Override
        public int hashCode() {
            return Objects.hash(maxOpenConnections, maxIdleConnections, timeout);
        }
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

    public ConnectionPoolProperties getConnectionPoolProperties() {
        return connectionPoolProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DbProperties that)) return false;
        return Objects.equals(username, that.username)
                && Objects.equals(password, that.password)
                && Objects.equals(database, that.database)
                && Objects.equals(url, that.url)
                && Objects.equals(connectionPoolProperties, that.connectionPoolProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, database, url, connectionPoolProperties);
    }
}
