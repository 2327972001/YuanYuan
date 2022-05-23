package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ZymOrder;

/**
 * 订单列表Service接口
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public interface IZymOrderService 
{
    /**
     * 查询订单列表
     * 
     * @param orderId 订单列表主键
     * @return 订单列表
     */
    public ZymOrder selectZymOrderByOrderId(Integer orderId);

    /**
     * 查询订单列表列表
     * 
     * @param zymOrder 订单列表
     * @return 订单列表集合
     */
    public List<ZymOrder> selectZymOrderList(ZymOrder zymOrder);

    /**
     * 新增订单列表
     * 
     * @param zymOrder 订单列表
     * @return 结果
     */
    public int insertZymOrder(ZymOrder zymOrder);

    /**
     * 修改订单列表
     * 
     * @param zymOrder 订单列表
     * @return 结果
     */
    public int updateZymOrder(ZymOrder zymOrder);

    /**
     * 批量删除订单列表
     * 
     * @param orderIds 需要删除的订单列表主键集合
     * @return 结果
     */
    public int deleteZymOrderByOrderIds(String orderIds);

    /**
     * 删除订单列表信息
     * 
     * @param orderId 订单列表主键
     * @return 结果
     */
    public int deleteZymOrderByOrderId(Integer orderId);
}
