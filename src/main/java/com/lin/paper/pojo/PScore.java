package com.lin.paper.pojo;

import java.util.Date;

public class PScore {
    private String scoreid;

    private String paperid;

    private String teachid;

    private Double scores;

    private Date createtime;

    private Date updatetime;

    public String getScoreid() {
        return scoreid;
    }

    public void setScoreid(String scoreid) {
        this.scoreid = scoreid == null ? null : scoreid.trim();
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid == null ? null : paperid.trim();
    }

    public String getTeachid() {
        return teachid;
    }

    public void setTeachid(String teachid) {
        this.teachid = teachid == null ? null : teachid.trim();
    }

    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
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