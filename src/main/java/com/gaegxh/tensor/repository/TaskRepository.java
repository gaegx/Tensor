package com.gaegxh.tensor.repository;

import com.gaegxh.tensor.model.Task;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TaskRepository {
    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
    private final RowMapper<Task> taskMapper = (rs, rowNum) ->
            new Task(
                    rs.getLong("id"),  // Извлекаем значение для поля 'id'
                    rs.getString("name"),  // Извлекаем значение для поля 'name'
                    rs.getString("description"),  // Извлекаем значение для поля 'description'
                    rs.getString("status")  // Извлекаем значение для поля 'status'
            );

    @PostConstruct
    public void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "description TEXT," +
                "status VARCHAR(50) NOT NULL," +
                "createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

        jdbcTemplate.execute(sql);
    }

    public List<Task> FindAll() {
        String sql = "SELECT * FROM task";
        return jdbcTemplate.query(sql,taskMapper);
    }

    public Task findById(long id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, taskMapper, id);
    }




}
