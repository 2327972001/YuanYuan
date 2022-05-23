package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单列表对象 zym_order
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public class ZymOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private Integer orderId;

    /** 平台 */
    @Excel(name = "平台")
    private String orderPlatform;

    /** 学校账号密码 */
    @Excel(name = "学校账号密码")
    private String orderUser;

    /** 课程名 */
    @Excel(name = "课程名")
    private String orderCourse;

    /** 金额 */
    @Excel(name = "金额")
    private Double orderMoney;

    /** 状态 */
    @Excel(name = "状态")
    private String orderState;

    /** 进度 */
    @Excel(name = "进度")
    private String orderEnter;

    /** 备注 */
    @Excel(name = "备注")
    private String orderText;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setOrderId(Integer orderId) 
    {
        this.orderId = orderId;
    }

    public Integer getOrderId() 
    {
        return orderId;
    }
    public void setOrderPlatform(String orderPlatform) 
    {
        this.orderPlatform = orderPlatform;
    }

    public String getOrderPlatform() 
    {
        return orderPlatform;
    }
    public void setOrderUser(String orderUser) 
    {
        this.orderUser = orderUser;
    }

    public String getOrderUser() 
    {
        return orderUser;
    }
    public void setOrderCourse(String orderCourse) 
    {
        this.orderCourse = orderCourse;
    }

    public String getOrderCourse() 
    {
        return orderCourse;
    }
    public void setOrderMoney(Double orderMoney) 
    {
        this.orderMoney = orderMoney;
    }

    public Double getOrderMoney() 
    {
        return orderMoney;
    }
    public void setOrderState(String orderState) 
    {
        this.orderState = orderState;
    }

    public String getOrderState() 
    {
        return orderState;
    }
    public void setOrderEnter(String orderEnter) 
    {
        this.orderEnter = orderEnter;
    }

    public String getOrderEnter() 
    {
        return orderEnter;
    }
    public void setOrderText(String orderText) 
    {
        this.orderText = orderText;
    }

    public String getOrderText() 
    {
        return orderText;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderPlatform", getOrderPlatform())
            .append("orderUser", getOrderUser())
            .append("orderCourse", getOrderCourse())
            .append("orderMoney", getOrderMoney())
            .append("orderState", getOrderState())
            .append("orderEnter", getOrderEnter())
            .append("orderText", getOrderText())
            .append("orderTime", getOrderTime())
            .append("userId", getUserId())
            .toString();
    }
}
