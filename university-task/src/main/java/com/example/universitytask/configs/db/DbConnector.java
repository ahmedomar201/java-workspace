package com.example.universitytask.configs.db;

import lombok.Data;
import lombok.ToString;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Data
@ToString(of = "")
public class DbConnector {
    private static final Logger log = LoggerFactory.getLogger(DbConnector.class);

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

        final String methodName="connect";
        Object[] args = {methodName,username, password, database, url, connectionPool.toString()};
        log.debug("[{}]Connecting to database with [{}] username [{}] and url [{}] ",args);
        args=new Object[]{methodName,username,url,connectionPool.toString()};
        log.debug("Successfully connected to database [{}] with url [{}] " ,args);
    }

}
