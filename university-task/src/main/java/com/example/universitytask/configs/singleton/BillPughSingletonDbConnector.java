package com.example.universitytask.configs.singleton;

import com.example.universitytask.configs.db.ConnectionPool;
import com.example.universitytask.configs.db.DbConnector;

public class BillPughSingletonDbConnector {

    private final DbConnector dbConnector;

    private BillPughSingletonDbConnector() {
        dbConnector = new DbConnector("", "", "", "",
                new ConnectionPool(0, 0, 0));
    }

    public static class  DbConnectorHolder{
        private static final BillPughSingletonDbConnector INSTANCE=new BillPughSingletonDbConnector();
    }

    public static BillPughSingletonDbConnector getInstant() {


        //in any situation return instance
        return DbConnectorHolder.INSTANCE;
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

