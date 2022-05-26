package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ZymGoods;

/**
 * 商品列表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
public interface ZymGoodsMapper 
{
    /**
     * 查询商品列表
     * 
     * @param goodsId 商品列表主键
     * @return 商品列表
     */
    public ZymGoods selectZymGoodsByGoodsId(Integer goodsId);

    /**
     * 查询商品列表列表
     * 
     * @param zymGoods 商品列表
     * @return 商品列表集合
     */
    public List<ZymGoods> selectZymGoodsList(ZymGoods zymGoods);

    /**
     * 新增商品列表
     * 
     * @param zymGoods 商品列表
     * @return 结果
     */
    public int insertZymGoods(ZymGoods zymGoods);

    /**
     * 修改商品列表
     * 
     * @param zymGoods 商品列表
     * @return 结果
     */
    public int updateZymGoods(ZymGoods zymGoods);

    /**
     * 删除商品列表
     * 
     * @param goodsId 商品列表主键
     * @return 结果
     */
    public int deleteZymGoodsByGoodsId(Integer goodsId);

    /**
     * 批量删除商品列表
     * 
     * @param goodsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZymGoodsByGoodsIds(String[] goodsIds);
}
