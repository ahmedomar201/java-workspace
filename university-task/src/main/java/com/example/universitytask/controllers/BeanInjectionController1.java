package com.example.universitytask.controllers;

import com.example.universitytask.configs.db.DbConnector;
import com.example.universitytask.configs.singleton.EagerDbConnector;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("controller1")
public class BeanInjectionController1 {


    private final EagerDbConnector eagerDbConnector = EagerDbConnector.getInstant();

    @GetMapping("dbConnector")
    public DbConnector getDbConnector() {

        return eagerDbConnector.getDbConnector();
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
        this.eagerDbConnector.getDbConnector().setUsername(dbConnector.getUsername());
        this.eagerDbConnector.getDbConnector().setPassword(dbConnector.getPassword());
        this.eagerDbConnector.getDbConnector().setDatabase(dbConnector.getDatabase());
        this.eagerDbConnector.getDbConnector().setUrl(dbConnector.getUrl());
        this.eagerDbConnector.getDbConnector().setConnectionPool(dbConnector.getConnectionPool());
    }

}
