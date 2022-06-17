package com.example.entity;

import java.io.Serializable;

/**
 * (Flight)实体类
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
public class Flight implements Serializable {
    private static final long serialVersionUID = 369704391383178521L;
    
    private String companyName;
    
    private String planetype;
    
    private String flightnumber;
    
    private String departurecity;
    
    private String arrivalcity;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPlanetype() {
        return planetype;
    }

    public void setPlanetype(String planetype) {
        this.planetype = planetype;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getDeparturecity() {
        return departurecity;
    }

    public void setDeparturecity(String departurecity) {
        this.departurecity = departurecity;
    }

    public String getArrivalcity() {
        return arrivalcity;
    }

    public void setArrivalcity(String arrivalcity) {
        this.arrivalcity = arrivalcity;
    }

}

