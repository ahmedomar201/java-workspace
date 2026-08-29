package com.example.universitytask.configs.singleton;

import com.example.universitytask.configs.db.ConnectionPool;
import com.example.universitytask.configs.db.DbConnector;

public enum EnumSingletonDbConnector {
    INSTANCE;

    private final DbConnector dbConnector= new DbConnector("", "", "", "",
            new ConnectionPool(0, 0, 0));;


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

