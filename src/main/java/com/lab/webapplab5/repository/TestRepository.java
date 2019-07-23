/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository;
import com.lab.webapplab5.model.Test;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author b.radomirovic
 */
@Repository
public interface TestRepository extends JpaRepository<Test,Long>{
//    @Query("select * from test")
//    List<Test> findForAll();
    
}
