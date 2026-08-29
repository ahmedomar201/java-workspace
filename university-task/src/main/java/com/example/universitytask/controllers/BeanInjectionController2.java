package com.example.universitytask.controllers;
import com.example.universitytask.configs.db.DbConnector;
import com.example.universitytask.configs.singleton.LazyDbConnector;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("controller2")
public class BeanInjectionController2 {

    @GetMapping("dbConnector")
    public DbConnector getDbConnector() {

        return  LazyDbConnector.getInstant().getDbConnector();
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
         LazyDbConnector.getInstant().getDbConnector().setUsername(dbConnector.getUsername());
         LazyDbConnector.getInstant().getDbConnector().setPassword(dbConnector.getPassword());
         LazyDbConnector.getInstant().getDbConnector().setDatabase(dbConnector.getDatabase());
         LazyDbConnector.getInstant().getDbConnector().setUrl(dbConnector.getUrl());
         LazyDbConnector.getInstant().getDbConnector().setConnectionPool(dbConnector.getConnectionPool());
    }


}
