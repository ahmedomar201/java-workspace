package com.example.universitytask.configs.db;


public record ConnectionPool(int maxOpenConnections,
                             int maxIdleConnections,
                             int timeout) {

}
