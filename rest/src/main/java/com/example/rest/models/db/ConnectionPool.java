package com.example.rest.models.db;

import java.util.Objects;

public class ConnectionPool {
    private int maxOpenConnections;
    private int maxIdleConnections;
    private int timeout;

    public ConnectionPool(int maxOpenConnections, int maxIdleConnections, int timeout) {
        this.maxOpenConnections = maxOpenConnections;
        this.maxIdleConnections = maxIdleConnections;
        this.timeout = timeout;
    }

    public int getMaxOpenConnections() {
        return maxOpenConnections;
    }

    public void setMaxOpenConnections(int maxOpenConnections) {
        this.maxOpenConnections = maxOpenConnections;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public void setMaxIdleConnections(int maxIdleConnections) {
        this.maxIdleConnections = maxIdleConnections;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConnectionPool that)) return false;
        return maxOpenConnections == that.maxOpenConnections
                && maxIdleConnections == that.maxIdleConnections
                && timeout == that.timeout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxOpenConnections, maxIdleConnections, timeout);
    }
}
