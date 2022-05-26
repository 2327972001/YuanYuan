package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ZymGoodsMapper;
import com.ruoyi.system.domain.ZymGoods;
import com.ruoyi.system.service.IZymGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
@Service
public class ZymGoodsServiceImpl implements IZymGoodsService 
{
    @Autowired
    private ZymGoodsMapper zymGoodsMapper;

    /**
     * 查询商品列表
     * 
     * @param goodsId 商品列表主键
     * @return 商品列表
     */
    @Override
    public ZymGoods selectZymGoodsByGoodsId(Integer goodsId)
    {
        return zymGoodsMapper.selectZymGoodsByGoodsId(goodsId);
    }

    /**
     * 查询商品列表列表
     * 
     * @param zymGoods 商品列表
     * @return 商品列表
     */
    @Override
    public List<ZymGoods> selectZymGoodsList(ZymGoods zymGoods)
    {
        return zymGoodsMapper.selectZymGoodsList(zymGoods);
    }

    /**
     * 新增商品列表
     * 
     * @param zymGoods 商品列表
     * @return 结果
     */
    @Override
    public int insertZymGoods(ZymGoods zymGoods)
    {
        return zymGoodsMapper.insertZymGoods(zymGoods);
    }

    /**
     * 修改商品列表
     * 
     * @param zymGoods 商品列表
     * @return 结果
     */
    @Override
    public int updateZymGoods(ZymGoods zymGoods)
    {
        return zymGoodsMapper.updateZymGoods(zymGoods);
    }

    /**
     * 批量删除商品列表
     * 
     * @param goodsIds 需要删除的商品列表主键
     * @return 结果
     */
    @Override
    public int deleteZymGoodsByGoodsIds(String goodsIds)
    {
        return zymGoodsMapper.deleteZymGoodsByGoodsIds(Convert.toStrArray(goodsIds));
    }

    /**
     * 删除商品列表信息
     * 
     * @param goodsId 商品列表主键
     * @return 结果
     */
    @Override
    public int deleteZymGoodsByGoodsId(Integer goodsId)
    {
        return zymGoodsMapper.deleteZymGoodsByGoodsId(goodsId);
    }
}
