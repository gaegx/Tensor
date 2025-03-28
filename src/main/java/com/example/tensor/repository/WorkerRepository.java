package com.example.tensor.repository;

import com.example.tensor.model.Worker;
import jakarta.annotation.PostConstruct;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerRepository {
    private final JdbcTemplate jdbcTemplate;


    public WorkerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<Worker> workerMapper = (rs, rowNum) ->
            new Worker(rs.getLong("id"), rs.getString("name"));


    @PostConstruct
    public void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS workers (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "createdAt TIMESTAMPTZ DEFAULT now())";

        jdbcTemplate.execute(sql);
    }

    public List<Worker> FindAll() {
        String sql = "SELECT * FROM workers";
        return jdbcTemplate.query(sql,workerMapper);
    }

    public Worker findById(long id) {
        String sql = "SELECT * FROM workers WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, workerMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void save(Worker worker) {
        String sql = "INSERT INTO workers (name) VALUES (?)";
        jdbcTemplate.update(sql, worker.getName());
    }



}
