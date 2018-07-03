package com.lin.paper.pojo;

import java.util.Date;

public class PColumn {
    private String columnid;

    private String columnname;

    private String parentcolumn;

    private Integer columnstate;

    private Integer type;

    private String url;

    private Integer orderby;

    private Integer isparent;

    private Date createtime;

    private Date updatetime;

    public String getColumnid() {
        return columnid;
    }

    public void setColumnid(String columnid) {
        this.columnid = columnid == null ? null : columnid.trim();
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname == null ? null : columnname.trim();
    }

    public String getParentcolumn() {
        return parentcolumn;
    }

    public void setParentcolumn(String parentcolumn) {
        this.parentcolumn = parentcolumn == null ? null : parentcolumn.trim();
    }

    public Integer getColumnstate() {
        return columnstate;
    }

    public void setColumnstate(Integer columnstate) {
        this.columnstate = columnstate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
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