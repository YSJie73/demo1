package com.example.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Passengers)实体类
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
public class Passengers implements Serializable {
    private static final long serialVersionUID = 262816888017717989L;
    
    private Integer ordernumber;
    
    private String name;
    
    private String id;

    private String seat;
    
    private String degree;
    
    private String classnumber;


    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

}

