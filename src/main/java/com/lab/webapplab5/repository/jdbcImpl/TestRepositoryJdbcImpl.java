/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository.jdbcImpl;

import com.lab.webapplab5.model.Test;
import com.lab.webapplab5.repository.TestRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author b.radomirovic
 */
@Repository
public class TestRepositoryJdbcImpl implements TestRepository{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Test findById(Long id) {
        return jdbcTemplate.queryForObject("select * from test where id=?",new Object[]{id}, new TestMapper());
    }

    @Override
    public List<Test> findAll() {
        return jdbcTemplate.query("select * from test", new TestMapper());
    }

    @Override
    public Test save(Test e) {
        jdbcTemplate.update("replace into test (create_date,created_by,name) values (?,?,?)",e.getCreateDate(),e.getCreated_by(),e.getName());
        return e;
    }

    @Override
    public void remove(Test e) throws IllegalArgumentException {
        jdbcTemplate.update("delete from test where id=?",e.getId());
    }

    private static final class TestMapper implements RowMapper<Test> {

        @Override
        public Test mapRow(ResultSet rs, int i) throws SQLException {
            Test t=new Test(rs.getDate("create_date"), rs.getString("created_by"), rs.getString("name"));
            t.setId(rs.getLong("id"));
            return t;
        }

        
    }
    
    
}
