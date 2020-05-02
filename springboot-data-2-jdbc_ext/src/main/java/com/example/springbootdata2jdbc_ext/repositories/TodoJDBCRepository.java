package com.example.springbootdata2jdbc_ext.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.springbootdata2jdbc_ext.model.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TodoJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class MyRowMapper implements RowMapper<Todo> {

        @Override
        public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Todo domain = new Todo();
            domain.setID(rs.getInt("ID"));
            domain.setDescription(rs.getString("description"));
            System.out.println("######### " + rs.getDate("date_from"));
            if (rs.getDate("date_from") !=null)
                domain.setDateFrom( (rs.getDate("date_from").toLocalDate()) );
            if (rs.getDate("date_to") !=null)
                domain.setDateTo( (rs.getDate("date_to").toLocalDate()) );

            //Kedua cara tidak efektif
            // domain.setDateFrom( LocalDate.ofInstant(rs.getDate("date_from").toInstant(), ZoneId.systemDefault())  );
            // if (rs.getDate("date_to") !=null)
            //     domain.setDateTo( rs.getDate("date_to").toInstant().atZone(ZoneId.systemDefault()).toLocalDate() );

            return domain;
        }
    }

    public List<Todo> findAll(){
        return jdbcTemplate.query("select * from todo", new MyRowMapper());
    }

    public Optional < Todo > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from todo where ID=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Todo > (Todo.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from todo where ID=?", new Object[] {
            id
        });
    }

    public int insert(Todo todo) {
        return jdbcTemplate.update("insert into Todo (ID, description, date_from, date_to) " + "values(?, ?, ?, ?)",
            new Object[] {
                todo.getID(), todo.getDescription(), todo.getDateFrom(), todo.getDateTo()
            });
    }

    public int update(Todo todo) {
        return jdbcTemplate.update("update Todo " + " set description = ?, date_from = ? , date_to = ? " + " where ID = ?",
            new Object[] {
                todo.getDescription(), todo.getDateFrom(), todo.getDateTo(), todo.getID()
            });
    }

}