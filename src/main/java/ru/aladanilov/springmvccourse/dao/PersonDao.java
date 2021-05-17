package ru.aladanilov.springmvccourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.aladanilov.springmvccourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("select * from psn.person;", new PersonMapper());
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from psn.person where id = ?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        int id = jdbcTemplate.queryForObject("select max(id) + 1 id from psn.person;", Integer.class);
        person.setId(id);

        jdbcTemplate.update("insert into psn.person values (?, ?, ?, ?)", id, person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("update psn.person set name = ?, age = ?, email = ? where id = ?", person.getName(), person.getAge(), person.getEmail(), person.getId());
    }

    public void delete(int id) {
        Person tobeDeleted = show(id);
        if (tobeDeleted != null) {
            jdbcTemplate.update("delete from psn.person where id = ?", id);
        }
    }

}
