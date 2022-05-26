package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品列表对象 zym_goods
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
public class ZymGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Integer goodsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 售价 */
    @Excel(name = "售价")
    private BigDecimal goodsMoney;

    public void setGoodsId(Integer goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Integer getGoodsId() 
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setGoodsMoney(BigDecimal goodsMoney) 
    {
        this.goodsMoney = goodsMoney;
    }

    public BigDecimal getGoodsMoney() 
    {
        return goodsMoney;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsMoney", getGoodsMoney())
            .toString();
    }
}
