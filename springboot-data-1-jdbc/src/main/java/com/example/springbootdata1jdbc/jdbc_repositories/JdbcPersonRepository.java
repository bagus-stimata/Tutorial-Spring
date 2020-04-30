package com.example.springbootdata1jdbc.jdbc_repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.springbootdata1jdbc.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPersonRepository implements PersonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM person", Integer.class);
    }

    // @Override
    // public int save(Person s) {
    //     return jdbcTemplate.update("INSERT INTO person(ID, name, address) values(?,?, ?)", s.getID(), s.getName(), s.getAddress());
    // }
    @Override
    public int save(Person s) {
        return 0;
    }

    @Override
    public int update(Person s) {
        return jdbcTemplate.update("UPDATE person SET name=?, address=? WHERE ID=?", s.getName(), s.getAddress(),
                s.getID());
    }

    @Override
    public int deleteByID(int ID) {
        return jdbcTemplate.update("DELETE FROM person WHERE ID=?", ID);
    }

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());

    }

    @Override
    public Person findByID(int ID) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE ID=?", 
            new Object[] { ID }, new PersonRowMapper() );
    }

}

class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setID(rs.getInt("ID"));
        person.setName(rs.getString("name"));
        person.setAddress(rs.getString("address"));

        return person;
    }

}