package com.springdemo.main.DTO;


public class Job {

    private Long id;

    private String companyName;
    private String status;
    private  long studid;

    public Job() {
    }

    public Job(String companyName, String status, long studid) {
        this.companyName = companyName;
        this.status = status;
        this.studid = studid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStudid() {
        return studid;
    }

    public void setStudid(Long studid) {
        this.studid = studid;
    }
}
