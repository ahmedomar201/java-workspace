package com.example.universitytask.controllers;

import com.example.universitytask.configs.db.DbConnector;
import com.example.universitytask.configs.singleton.EagerDbConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("controller1")
public class BeanInjectionController1 {

    private DbConnector dbConnector;

    // Di (Setter)
    // need Autowired to make injection
    @Autowired(required = false)
    public void setDbConnector(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

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
