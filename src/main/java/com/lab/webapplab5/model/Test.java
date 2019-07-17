/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author b.radomirovic
 */
public class Test extends AbstractEntity{
    private Date createDate;
    private String name;
    private String created_by;

    public Test() {
    }

    public Test(Date createDate, String name, String created_by) {
        this.createDate = createDate;
        this.name = name;
        this.created_by = created_by;
    }



    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
       
}
