package com.example.universitytask.configs.singleton;

import com.example.universitytask.configs.db.ConnectionPool;
import com.example.universitytask.configs.db.DbConnector;

public class LazyDbConnector {

    private static LazyDbConnector INSTANCE;

    private final DbConnector dbConnector;

    private LazyDbConnector() {
        dbConnector = new DbConnector("", "", "", "",
                new ConnectionPool(0, 0, 0));
    }

    public static LazyDbConnector getInstant() {

        //if Singleton not found create it
        if(INSTANCE==null){
            INSTANCE=new LazyDbConnector();
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

