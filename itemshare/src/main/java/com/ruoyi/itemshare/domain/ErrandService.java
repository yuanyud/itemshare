package com.ruoyi.itemshare.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 跑腿服务管理对象 is_errand_service
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
public class ErrandService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 服务ID */
    private Long id;

    /** 交易ID */
    @Excel(name = "交易ID")
    private Long transactionId;

    /** 跑腿人ID */
    @Excel(name = "跑腿人ID")
    private Long runnerId;

    /** 服务时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "服务时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date serviceTime;

    /** 服务费用 */
    @Excel(name = "服务费用")
    private BigDecimal serviceFee;

    /** 服务状态 */
    @Excel(name = "服务状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTransactionId(Long transactionId) 
    {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() 
    {
        return transactionId;
    }
    public void setRunnerId(Long runnerId) 
    {
        this.runnerId = runnerId;
    }

    public Long getRunnerId() 
    {
        return runnerId;
    }
    public void setServiceTime(Date serviceTime) 
    {
        this.serviceTime = serviceTime;
    }

    public Date getServiceTime() 
    {
        return serviceTime;
    }
    public void setServiceFee(BigDecimal serviceFee) 
    {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getServiceFee() 
    {
        return serviceFee;
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
            .append("transactionId", getTransactionId())
            .append("runnerId", getRunnerId())
            .append("serviceTime", getServiceTime())
            .append("serviceFee", getServiceFee())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
