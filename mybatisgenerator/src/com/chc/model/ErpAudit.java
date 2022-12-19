package com.chc.model;

import java.util.Date;

public class ErpAudit {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 审核人erp
     */
    private String erp;

    /**
     * 审核人名称
     */
    private String erpName;

    /**
     * 日期yyyyddmm
     */
    private Long eventDate;

    /**
     * 素材审核通过
     */
    private Long matterPass;

    /**
     * 素材审核驳回
     */
    private Long matterReject;

    /**
     * 素材二审驳回
     */
    private Long matterRejectTwo;

    /**
     * 上刊审核总量
     */
    private Long publishAudit;

    /**
     * 监播审核总量
     */
    private Long monitorAudit;

    /**
     * 0未删除，1删除
     */
    private Byte isDelete;

    /**
     * 记录创建人
     */
    private String createUser;

    /**
     * 记录更新人
     */
    private String updateUser;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 记录更新时间
     */
    private Date updateTime;

    /**
     * 由数据库自动维护，对应用程序透明
     */
    private Date ts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErp() {
        return erp;
    }

    public void setErp(String erp) {
        this.erp = erp == null ? null : erp.trim();
    }

    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName == null ? null : erpName.trim();
    }

    public Long getEventDate() {
        return eventDate;
    }

    public void setEventDate(Long eventDate) {
        this.eventDate = eventDate;
    }

    public Long getMatterPass() {
        return matterPass;
    }

    public void setMatterPass(Long matterPass) {
        this.matterPass = matterPass;
    }

    public Long getMatterReject() {
        return matterReject;
    }

    public void setMatterReject(Long matterReject) {
        this.matterReject = matterReject;
    }

    public Long getMatterRejectTwo() {
        return matterRejectTwo;
    }

    public void setMatterRejectTwo(Long matterRejectTwo) {
        this.matterRejectTwo = matterRejectTwo;
    }

    public Long getPublishAudit() {
        return publishAudit;
    }

    public void setPublishAudit(Long publishAudit) {
        this.publishAudit = publishAudit;
    }

    public Long getMonitorAudit() {
        return monitorAudit;
    }

    public void setMonitorAudit(Long monitorAudit) {
        this.monitorAudit = monitorAudit;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}