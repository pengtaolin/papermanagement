package com.lin.paper.pojo;

import java.util.Date;

public class PPermission {
    private String permissionid;

    private String permissionname;

    /**
     * 进度状态：
     * 0：创建
     * 1：提交中
     * 2：已通过
     * 3：未通过
     *
     */
    private Integer permissionstate;

    private Date createtime;

    private Date updatetime;

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    public Integer getPermissionstate() {
        return permissionstate;
    }

    public void setPermissionstate(Integer permissionstate) {
        this.permissionstate = permissionstate;
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