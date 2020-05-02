package com.example.springdata1thymeleaf.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.springdata1thymeleaf.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class MyRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person domain = new Person();
            domain.setID(rs.getInt("ID"));
            domain.setName(rs.getString("name"));
            domain.setAddress(rs.getString("address"));

            return domain;
        }
    }

    public List<Person> findAll(){
        return jdbcTemplate.query("select * from person", new MyRowMapper());
    }

    public Optional < Person > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from person where ID=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Person > (Person.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from person where ID=?", new Object[] {
            id
        });
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (ID, name, address) " + "values(?, ?, ?)",
            new Object[] {
                person.getID(), person.getName(), person.getAddress()
            });
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person " + " set name = ?, address = ? " + " where ID = ?",
            new Object[] {
                person.getName(), person.getAddress(), person.getID()
            });
    }

}