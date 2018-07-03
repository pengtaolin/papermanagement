package com.lin.paper.pojo;

import java.util.Date;

public class PTask {
    private String taskid;

    private String taskname;

    private Date year;

    private Integer taskstate;

    private Date createtime;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getTaskstate() {
        return taskstate;
    }

    public void setTaskstate(Integer taskstate) {
        this.taskstate = taskstate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}