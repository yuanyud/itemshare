package com.ruoyi.itemshare.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交易管理对象 is_transaction
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
public class Transaction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 交易ID */
    private Long id;

    /** 物品ID */
    @Excel(name = "物品ID")
    private Long itemId;

    /** 承租人学生ID */
    @Excel(name = "承租人学生ID")
    private Long studentId;

    /** 出租人学生ID */
    @Excel(name = "出租人学生ID")
    private Long landlordId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 预计结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 实际归还时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际归还时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualReturnTime;

    /** 费用 */
    @Excel(name = "费用")
    private BigDecimal fee;

    /** 交易状态 */
    @Excel(name = "交易状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setLandlordId(Long landlordId) 
    {
        this.landlordId = landlordId;
    }

    public Long getLandlordId() 
    {
        return landlordId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setActualReturnTime(Date actualReturnTime) 
    {
        this.actualReturnTime = actualReturnTime;
    }

    public Date getActualReturnTime() 
    {
        return actualReturnTime;
    }
    public void setFee(BigDecimal fee) 
    {
        this.fee = fee;
    }

    public BigDecimal getFee() 
    {
        return fee;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("studentId", getStudentId())
            .append("landlordId", getLandlordId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("actualReturnTime", getActualReturnTime())
            .append("fee", getFee())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
