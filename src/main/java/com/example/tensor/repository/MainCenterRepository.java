package com.example.tensor.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MainCenterRepository {
    private final JdbcTemplate jdbcTemplate;

    public MainCenterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostConstruct
    public void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS main_center (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50))";
        jdbcTemplate.update(sql);

    }

}
