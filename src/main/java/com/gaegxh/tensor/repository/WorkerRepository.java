package com.gaegxh.tensor.repository;

import com.gaegxh.tensor.model.Worker;
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
                "active BOOLEAN NOT NULL," +
                "cpu_usage FLOAT NOT NULL," +
                "ram_usage FLOAT NOT NULL," +
                "disk_usage FLOAT NOT NULL," +
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

    public void update(Worker worker) {
        String sql = "UPDATE workers SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, worker.getName(), worker.getId());
    }

    public void delete(Worker worker) {
        String sql = "DELETE FROM workers WHERE id = ?";
        jdbcTemplate.update(sql, worker.getId());
    }

    public List<Worker> findByName(String name) {
        String sql = "SELECT * FROM workers WHERE name = ?";
        try {
            return jdbcTemplate.query(sql, workerMapper, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
