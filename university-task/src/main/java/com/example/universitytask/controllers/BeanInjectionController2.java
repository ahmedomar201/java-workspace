package com.example.universitytask.controllers;

import com.example.universitytask.configs.db.DbConnector;
import com.example.universitytask.configs.singleton.LazyDbConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("controller2")
public class BeanInjectionController2 {

    // Di (Field)
    @Autowired
    private  DbConnector dbConnector;

    @GetMapping("dbConnector")
    public DbConnector getDbConnector() {

        return dbConnector;
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
        this.dbConnector.setUsername(dbConnector.getUsername());
        this.dbConnector.setPassword(dbConnector.getPassword());
        this.dbConnector.setDatabase(dbConnector.getDatabase());
        this.dbConnector.setUrl(dbConnector.getUrl());
        this.dbConnector.setConnectionPool(dbConnector.getConnectionPool());
    }

}
//@RestController
//@RequestMapping("controller2")
//public class BeanInjectionController2 {
//
//
//    private final DbConnector dbConnector;
//
//    // Di (Constructor)
//    //don't need Autowired to make injection
//    @Autowired
//    public BeanInjectionController2(DbConnector dbConnector) {
//        this.dbConnector = dbConnector;
//    }
//
//    @GetMapping("dbConnector")
//    public DbConnector getDbConnector() {
//
//        return dbConnector;
//    }
//
//    @PutMapping("update")
//    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
//        this.dbConnector.setUsername(dbConnector.getUsername());
//        this.dbConnector.setPassword(dbConnector.getPassword());
//        this.dbConnector.setDatabase(dbConnector.getDatabase());
//        this.dbConnector.setUrl(dbConnector.getUrl());
//        this.dbConnector.setConnectionPool(dbConnector.getConnectionPool());
//    }
//
//}