/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository.jdbcImpl;

import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.model.Test;
import com.lab.webapplab5.model.TestQuestion;
import com.lab.webapplab5.repository.TestQuestionRepository;
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
public class TestQuestionRepositoryJdbcImpl implements TestQuestionRepository{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public TestQuestion findById(Long id) {
        return jdbcTemplate.queryForObject("select * from test_questions tq join question q on tq.questions_id=q.id join test t on t.id=tq.test_id where t.id=?", new Object[]{id},new TQMapper());
    }

    @Override
    public List<TestQuestion> findAll() {
        return jdbcTemplate.query("select * from test_questions tq join question q on tq.questions_id=q.id join test t on t.id=tq.test_id", new TQMapper());
    }

    @Override
    public TestQuestion save(TestQuestion e) {
        jdbcTemplate.update("replace into test_questions values (?,?)",e.getTest().getId(),e.getQuestion().getId());
        return e;
    }

    @Override
    public void remove(TestQuestion e) throws IllegalArgumentException {
        jdbcTemplate.update("delete from test_questions where questions_id=?",e.getQuestion().getId());
    }

    private static final class TQMapper implements RowMapper<TestQuestion> {

        @Override
        public TestQuestion mapRow(ResultSet rs, int i) throws SQLException {
            TestQuestion tq=new TestQuestion();
            Test t=new Test(rs.getDate("t.create_date"), rs.getString("t.created_by"), rs.getString("t.name"));
            t.setId(rs.getLong("t.id"));
            Question q=new Question(rs.getString("q.content"), null, null);
            
            tq.setQuestion(q);
            tq.setTest(t);
            
            return tq;
        }
         
    }
    
}
