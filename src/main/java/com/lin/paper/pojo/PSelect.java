package com.lin.paper.pojo;

import java.util.Date;

public class PSelect {
    private String selectid;

    private String subjectid;

    private String stuid;

    private String progressid;

    private Double score;

    private Integer selectstate;

    private String taskid;

    private Date createtime;

    private Date updatetime;

    public String getSelectid() {
        return selectid;
    }

    public void setSelectid(String selectid) {
        this.selectid = selectid == null ? null : selectid.trim();
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid == null ? null : subjectid.trim();
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public String getProgressid() {
        return progressid;
    }

    public void setProgressid(String progressid) {
        this.progressid = progressid == null ? null : progressid.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getSelectstate() {
        return selectstate;
    }

    public void setSelectstate(Integer selectstate) {
        this.selectstate = selectstate;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}