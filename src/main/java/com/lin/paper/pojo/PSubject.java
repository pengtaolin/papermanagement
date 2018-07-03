package com.lin.paper.pojo;

import java.util.Date;

public class PSubject {
    private String subjectid;

    private String teachid;

    private String subjectname;

    private String subjecttype;
    
    /**
     * 0：创建
     * 1：申请（预设）
     * 2：指导老师通过
     * 3：系未通过
     * 4：系通过
     * 5：指导老师未通过
     * 6：选题中
     */
    private Integer subjectstate;

    private String createuser;

    private Date createtime;

    private Date updatetime;

    private String subjectcontent;

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid == null ? null : subjectid.trim();
    }

    public String getTeachid() {
        return teachid;
    }

    public void setTeachid(String teachid) {
        this.teachid = teachid == null ? null : teachid.trim();
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname == null ? null : subjectname.trim();
    }

    public String getSubjecttype() {
        return subjecttype;
    }

    public void setSubjecttype(String subjecttype) {
        this.subjecttype = subjecttype == null ? null : subjecttype.trim();
    }

    public Integer getSubjectstate() {
        return subjectstate;
    }

    public void setSubjectstate(Integer subjectstate) {
        this.subjectstate = subjectstate;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
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

    public String getSubjectcontent() {
        return subjectcontent;
    }

    public void setSubjectcontent(String subjectcontent) {
        this.subjectcontent = subjectcontent == null ? null : subjectcontent.trim();
    }
}