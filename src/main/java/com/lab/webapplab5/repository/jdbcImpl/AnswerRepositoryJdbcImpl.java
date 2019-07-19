/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository.jdbcImpl;

import com.lab.webapplab5.model.Answer;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.repository.AnswerRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AnswerRepositoryJdbcImpl implements AnswerRepository{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    @Override
    public Answer findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM answer a JOIN question q on a.question_id=q.id WHERE a.id=?", new Object[]{id},new AnswerMapper());
    }

    @Override
    public List<Answer> findAll() {
        return jdbcTemplate.query("SELECT * FROM answer a JOIN question q on a.question_id=q.id",new AnswerMapper());
    }

    @Override
    public Answer save(Answer e) {
        jdbcTemplate.update("replace into answer (content,correct,question_id) values (?,?,?)",e.getContent(),e.isCorrect(),e.getQuestion().getId());
        return e;
    }

    @Override
    public void remove(Answer e) throws IllegalArgumentException {
        jdbcTemplate.update("delete from answer where id=?",e.getId());
    }

    private static final class AnswerMapper implements RowMapper<Answer> {
        
        
        @Override
        public Answer mapRow(ResultSet rs, int i) throws SQLException {
            Question question=new Question(rs.getString("q.content"), null, new ArrayList<Answer>());
            Answer a=new Answer(rs.getString("content"), rs.getBoolean("correct"), question);
            return a;
        }
    }
    
}
