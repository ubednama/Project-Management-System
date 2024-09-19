package com.ubednama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInitializationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initializeDatabase() {
        createDatabaseIfNotExists();
    }

    private void createDatabaseIfNotExists() {
        String createDatabaseSql = "CREATE DATABASE IF NOT EXISTS projectmanagementsystem";
        jdbcTemplate.execute(createDatabaseSql);
    }
}

