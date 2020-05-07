package com.caler.zkl.openpsd.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class ApplicationForm implements Serializable {
    private Long id;

    @ApiModelProperty(value = "单据号")
    private String formCode;

    @ApiModelProperty(value = "申请公司")
    private Long applyCompany;

    @ApiModelProperty(value = "申请状态")
    private Integer applyStatus;

    @ApiModelProperty(value = "申请人")
    private Long applyOn;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "批准人")
    private Long approver;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "修改人")
    private Long modifyOn;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;

    @ApiModelProperty(value = "描述")
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public Long getApplyCompany() {
        return applyCompany;
    }

    public void setApplyCompany(Long applyCompany) {
        this.applyCompany = applyCompany;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Long getApplyOn() {
        return applyOn;
    }

    public void setApplyOn(Long applyOn) {
        this.applyOn = applyOn;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getApprover() {
        return approver;
    }

    public void setApprover(Long approver) {
        this.approver = approver;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(Long modifyOn) {
        this.modifyOn = modifyOn;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", formCode=").append(formCode);
        sb.append(", applyCompany=").append(applyCompany);
        sb.append(", applyStatus=").append(applyStatus);
        sb.append(", applyOn=").append(applyOn);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", approver=").append(approver);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifyOn=").append(modifyOn);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}