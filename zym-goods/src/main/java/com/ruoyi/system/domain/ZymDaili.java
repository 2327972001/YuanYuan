package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理费率对象 zym_daili
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
public class ZymDaili extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 代理id */
    private Integer id;

    /** 代理标识 */
    @Excel(name = "代理标识")
    private String daili;

    /** 代理费率 */
    @Excel(name = "代理费率")
    private Double money;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setDaili(String daili) 
    {
        this.daili = daili;
    }

    public String getDaili() 
    {
        return daili;
    }
    public void setMoney(Double money) 
    {
        this.money = money;
    }

    public Double getMoney() 
    {
        return money;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("daili", getDaili())
            .append("money", getMoney())
            .toString();
    }
}
