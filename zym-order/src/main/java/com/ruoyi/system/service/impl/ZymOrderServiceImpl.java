package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ZymOrderMapper;
import com.ruoyi.system.domain.ZymOrder;
import com.ruoyi.system.service.IZymOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@Service
public class ZymOrderServiceImpl implements IZymOrderService 
{
    @Autowired
    private ZymOrderMapper zymOrderMapper;

    /**
     * 查询订单列表
     * 
     * @param orderId 订单列表主键
     * @return 订单列表
     */
    @Override
    public ZymOrder selectZymOrderByOrderId(Integer orderId)
    {
        return zymOrderMapper.selectZymOrderByOrderId(orderId);
    }

    /**
     * 查询订单列表列表
     * 
     * @param zymOrder 订单列表
     * @return 订单列表
     */
    @Override
    public List<ZymOrder> selectZymOrderList(ZymOrder zymOrder)
    {
        return zymOrderMapper.selectZymOrderList(zymOrder);
    }

    /**
     * 新增订单列表
     * 
     * @param zymOrder 订单列表
     * @return 结果
     */
    @Override
    public int insertZymOrder(ZymOrder zymOrder)
    {
        return zymOrderMapper.insertZymOrder(zymOrder);
    }

    /**
     * 修改订单列表
     * 
     * @param zymOrder 订单列表
     * @return 结果
     */
    @Override
    public int updateZymOrder(ZymOrder zymOrder)
    {
        return zymOrderMapper.updateZymOrder(zymOrder);
    }

    /**
     * 批量删除订单列表
     * 
     * @param orderIds 需要删除的订单列表主键
     * @return 结果
     */
    @Override
    public int deleteZymOrderByOrderIds(String orderIds)
    {
        return zymOrderMapper.deleteZymOrderByOrderIds(Convert.toStrArray(orderIds));
    }

    /**
     * 删除订单列表信息
     * 
     * @param orderId 订单列表主键
     * @return 结果
     */
    @Override
    public int deleteZymOrderByOrderId(Integer orderId)
    {
        return zymOrderMapper.deleteZymOrderByOrderId(orderId);
    }
}
