package com.ubednama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private DatabaseInitializationService databaseInitializationService;

    @Override
    public void run(String... args) throws Exception {
        databaseInitializationService.initializeDatabase();
    }
}
