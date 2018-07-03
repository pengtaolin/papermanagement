package com.lin.paper.pojo;

import java.util.Date;

public class PProgress {
    private String progressid;

    private String progressname;

    private Date starttime;

    private Date endtime;

    private String paperid;

    private Integer progressstate;

    private String userid;

    private Date createtime;

    private Date updatetime;

    private String advice;

    public String getProgressid() {
        return progressid;
    }

    public void setProgressid(String progressid) {
        this.progressid = progressid == null ? null : progressid.trim();
    }

    public String getProgressname() {
        return progressname;
    }

    public void setProgressname(String progressname) {
        this.progressname = progressname == null ? null : progressname.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid == null ? null : paperid.trim();
    }

    public Integer getProgressstate() {
        return progressstate;
    }

    public void setProgressstate(Integer progressstate) {
        this.progressstate = progressstate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }
}