package com.example.universitytask.configs.singleton;

import com.example.universitytask.configs.db.ConnectionPool;
import com.example.universitytask.configs.db.DbConnector;

public class EagerDbConnector {

    private static final EagerDbConnector INSTANCE = new EagerDbConnector();

    private final DbConnector dbConnector;

    private EagerDbConnector() {
        dbConnector = new DbConnector("", "", "", "",
                new ConnectionPool(0, 0, 0));
    }

    public static EagerDbConnector getInstant() {
        return INSTANCE;
    }

    public void insert() {
        System.out.println("Inserting object to Db.....");
    }

    public void delete() {
        System.out.println("Deleting Object from table.....");
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}

