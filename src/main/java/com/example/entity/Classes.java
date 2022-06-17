package com.example.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Classes)实体类
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
public class Classes implements Serializable {
    private static final long serialVersionUID = -68877674252731760L;
    
    private String classnumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date departuredata;
    
    private String departureairport;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date arrivaldata;
    
    private String arrivalairport;
    
    private Integer aNumber;

    private Integer bNumber;
    
    private Integer aprice;
    
    private Integer bprice;
    
    private String flightnumber;

    @Override
    public String toString() {
        return "Classes{" +
                "classnumber='" + classnumber + '\'' +
                ", departuredata=" + departuredata +
                ", departureairport='" + departureairport + '\'' +
                ", arrivaldata=" + arrivaldata +
                ", arrivalairport='" + arrivalairport + '\'' +
                ", aNumber=" + aNumber +
                ", bNumber=" + bNumber +
                ", aprice=" + aprice +
                ", bprice=" + bprice +
                ", flightnumber='" + flightnumber + '\'' +
                '}';
    }

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    public Date getDeparturedata() {
        return departuredata;
    }

    public void setDeparturedata(Date departuredata) {
        this.departuredata = departuredata;
    }

    public String getDepartureairport() {
        return departureairport;
    }

    public void setDepartureairport(String departureairport) {
        this.departureairport = departureairport;
    }

    public Date getArrivaldata() {
        return arrivaldata;
    }

    public void setArrivaldata(Date arrivaldata) {
        this.arrivaldata = arrivaldata;
    }

    public String getArrivalairport() {
        return arrivalairport;
    }

    public void setArrivalairport(String arrivalairport) {
        this.arrivalairport = arrivalairport;
    }

    public Integer getANumber() {
        return aNumber;
    }

    public void setANumber(Integer aNumber) {
        this.aNumber = aNumber;
    }



    public Integer getBNumber() {
        return bNumber;
    }

    public void setBNumber(Integer bNumber) {
        this.bNumber = bNumber;
    }

    public Integer getAprice() {
        return aprice;
    }

    public void setAprice(Integer aprice) {
        this.aprice = aprice;
    }

    public Integer getBprice() {
        return bprice;
    }

    public void setBprice(Integer bprice) {
        this.bprice = bprice;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

}

