/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository.jdbcImpl;

import com.lab.webapplab5.model.Answer;
import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.repository.QuestionRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author b.radomirovic
 */

@Repository
public class QuestionRepositoryJdbcImpl implements QuestionRepository{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    @Override
    public Question findById(Long id) {
        QuestionRowCallbackHandler questionRowCallbackHandler = new QuestionRowCallbackHandler();
        jdbcTemplate.query("select * from question q join category c on q.category_id=c.id join answer a on a.question_id=q.id where q.id=?", questionRowCallbackHandler, id);
        return questionRowCallbackHandler.getQuestions().get(0);
    }

    @Override
    public List<Question> findAll() {
        QuestionRowCallbackHandler questionRowCallbackHandler = new QuestionRowCallbackHandler();
        jdbcTemplate.query("SELECT * FROM question q JOIN category c ON q.category_id=c.id JOIN answer a ON a.question_id=q.id", questionRowCallbackHandler);
        return questionRowCallbackHandler.getQuestions();
    }

    @Override
    public Question save(Question e) {
        jdbcTemplate.update("replace into question (content,category_id) values (?,?)",e.getContent(),e.getCategory().getId());
        return e;
    }

    @Override
    public void remove(Question e) throws IllegalArgumentException {
        jdbcTemplate.update("delete from question where id=?",e.getId());
    }

 
    private static final class QuestionRowCallbackHandler implements RowCallbackHandler{
        List<Question> questions=new ArrayList<>();
        Question currentQuestion;
        Answer currentAnswer;
        Category category;
        
        public List<Question> getQuestions() {
            return questions;
        }
      
        @Override
        public void processRow(ResultSet rs) throws SQLException {
            if(currentQuestion==null || currentQuestion.getId()!=rs.getLong("q.id"))
            {
                currentQuestion=new Question();
                currentQuestion.setContent(rs.getString("q.content"));
                currentQuestion.setId(rs.getLong("q.id"));
                currentQuestion.setAnswers(new ArrayList<Answer>());
            }
            if(category==null || category.getId()!=rs.getLong("c.id"))
            {
                category=new Category(rs.getString("c.name"),new ArrayList<Question>());
                category.setId(rs.getLong("c.id"));
                currentQuestion.setCategory(category);
            }
            if(currentAnswer==null || currentAnswer.getId()!=rs.getLong("a.id"))
            {
                currentAnswer=new Answer(rs.getString("a.content"), rs.getBoolean("a.correct"), currentQuestion);
                
            }
            
            currentQuestion.setCategory(category);
            
            if(!questions.contains(currentQuestion))
            {
                currentQuestion.getAnswers().add(currentAnswer);
                questions.add(currentQuestion);
            }else {
                for (Question question : questions) {
                    if(question.getId()==currentQuestion.getId())
                    {
                        question.getAnswers().add(currentAnswer);
                    }
                }
            }
            
        }
    }
    
}
