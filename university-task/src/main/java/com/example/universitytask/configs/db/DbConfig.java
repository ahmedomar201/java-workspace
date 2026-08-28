package com.example.universitytask.configs.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DbProperties.class)
public class DbConfig {
    /*@Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.database}")
    private String database;
    @Value("${db.url}")
    private String url;
    @Value("${db.connectionPool.maxOpenConnections}")
    private int maxOpenConnections;
    @Value("${db.connectionPool.maxIdleConnections}")
    private int maxIdleConnections;*/
    private final DbProperties dbProperties;
//    private final ApplicationContext applicationContext;

    @Autowired
    public DbConfig(DbProperties dbProperties/*, ApplicationContext applicationContext*/) {
        this.dbProperties = dbProperties;
//        this.applicationContext = applicationContext;
    }

    @Bean
//    @Profile("prod")
//    @ConditionalOnProperty(name = "db.connection.flow", havingValue = "true")
//    @Conditional(PostgresCondition.class)
//    @ConditionalOnClass(name = "com.pioneers.rest.configs.Test")
//    @ConditionalOnBean(ConnectionPool.class)
//    @DependsOn("connectionPool")
    public DbConnector dbConnector() {
        System.out.println("Creating the DB connector bean!!");
        final ConnectionPool connectionPool = toConnectionPool(dbProperties.getConnectionPoolProperties());

        return new DbConnector(
                dbProperties.getUsername(),
                dbProperties.getPassword(),
                dbProperties.getDatabase(),
                dbProperties.getUrl(),
                connectionPool
        );
    }

//    @Bean
//    @Profile({"local", "test"})
//    public NewDbConnector newDbConnector(/*ApplicationContext applicationContext*//*final ConnectionPool connectionPool*/) {
//        System.out.println("Creating the New DB connector bean!!");
//        final ConnectionPool connectionPool = toConnectionPool(dbProperties.getConnectionPoolProperties());
//
//        return new NewDbConnector(
//                dbProperties.getUsername(),
//                dbProperties.getPassword(),
//                dbProperties.getDatabase(),
//                dbProperties.getUrl(),
//                connectionPool
//        );
//    }

    private static ConnectionPool toConnectionPool(
            final DbProperties.ConnectionPoolProperties connectionPoolProperties
    ) {
        return new ConnectionPool(
                connectionPoolProperties.getMaxOpenConnections(),
                connectionPoolProperties.getMaxIdleConnections(),
                connectionPoolProperties.getTimeout()
        );
    }

    /*@Bean
    public ConnectionPool connectionPool() {
        final DbProperties.ConnectionPoolProperties connectionPool = dbProperties.getConnectionPoolProperties();

        return new ConnectionPool(connectionPool.getMaxOpenConnections(), connectionPool.getMaxIdleConnections(), connectionPool.getTimeout());
    }*/
}
