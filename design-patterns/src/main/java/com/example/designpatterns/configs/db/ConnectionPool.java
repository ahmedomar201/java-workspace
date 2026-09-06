package com.example.designpatterns.configs.db;


public record ConnectionPool(int maxOpenConnections,
                             int maxIdleConnections,
                             int timeout) {

}
