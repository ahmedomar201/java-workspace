package com.example.universitytask.configs.singleton;

import com.example.universitytask.configs.db.ConnectionPool;
import com.example.universitytask.configs.db.DbConnector;

public class DoubleCheckLookingDbConnector {

    private static DoubleCheckLookingDbConnector INSTANCE;

    private final DbConnector dbConnector;

    private DoubleCheckLookingDbConnector() {
        dbConnector = new DbConnector("", "", "", "",
                new ConnectionPool(0, 0, 0));
    }

    public static DoubleCheckLookingDbConnector getInstant() {

        //if Singleton not found create it

        if (INSTANCE == null) {
            synchronized (DoubleCheckLookingDbConnector.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLookingDbConnector();
                }
            }
        }
        //in any situation return instance
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

