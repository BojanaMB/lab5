/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository.jdbcImpl;

import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.repository.CategoryRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author b.radomirovic
 */

@Repository
public class CategoryRepositoryJdbcImpl implements CategoryRepository{
    
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }
    
    
    @Override
    public Category findById(Long id) {      
       return this.jdbcTemplate.queryForObject("select * from category where id=?",new Object[] { id }, new CategoryMapper());
    }

    @Override
    public List<Category> findAll() {
        return this.jdbcTemplate.query( "select id,name from category", new CategoryMapper());
    }

    @Override
    public Category save(Category e) {
        jdbcTemplate.update("replace into category (name) values (?)", e.getName());
        //Category cat=jdbcTemplate.find
        return e;
    }

    @Override
    public void remove(Category e) throws IllegalArgumentException {
        jdbcTemplate.update("delete from category where id=?",e.getId());
    }

    private static final class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category=new Category(rs.getString("name"), new ArrayList<Question>());
            category.setId(rs.getLong("id"));
            return category;
        }
    }
    
}
