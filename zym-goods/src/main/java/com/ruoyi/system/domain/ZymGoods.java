package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品列表对象 zym_goods
 * 
 * @author ruoyi
 * @date 2022-05-22
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
    private Double goodsMoney;

    /** 一级代理费率 */
    @Excel(name = "一级代理费率")
    private Double goodsDaili1;

    /** 二级代理费率 */
    @Excel(name = "二级代理费率")
    private Double goodsDaili2;

    /** 三级代理费率 */
    @Excel(name = "三级代理费率")
    private Double goodsDaili3;

    /** 四级代理费率 */
    @Excel(name = "四级代理费率")
    private Double goodsDaili4;

    /** 五级代理费率 */
    @Excel(name = "五级代理费率")
    private Double goodsDaili5;

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
    public void setGoodsMoney(Double goodsMoney) 
    {
        this.goodsMoney = goodsMoney;
    }

    public Double getGoodsMoney() 
    {
        return goodsMoney;
    }
    public void setGoodsDaili1(Double goodsDaili1) 
    {
        this.goodsDaili1 = goodsDaili1;
    }

    public Double getGoodsDaili1() 
    {
        return goodsDaili1;
    }
    public void setGoodsDaili2(Double goodsDaili2) 
    {
        this.goodsDaili2 = goodsDaili2;
    }

    public Double getGoodsDaili2() 
    {
        return goodsDaili2;
    }
    public void setGoodsDaili3(Double goodsDaili3) 
    {
        this.goodsDaili3 = goodsDaili3;
    }

    public Double getGoodsDaili3() 
    {
        return goodsDaili3;
    }
    public void setGoodsDaili4(Double goodsDaili4) 
    {
        this.goodsDaili4 = goodsDaili4;
    }

    public Double getGoodsDaili4() 
    {
        return goodsDaili4;
    }
    public void setGoodsDaili5(Double goodsDaili5) 
    {
        this.goodsDaili5 = goodsDaili5;
    }

    public Double getGoodsDaili5() 
    {
        return goodsDaili5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsMoney", getGoodsMoney())
            .append("goodsDaili1", getGoodsDaili1())
            .append("goodsDaili2", getGoodsDaili2())
            .append("goodsDaili3", getGoodsDaili3())
            .append("goodsDaili4", getGoodsDaili4())
            .append("goodsDaili5", getGoodsDaili5())
            .toString();
    }
}
