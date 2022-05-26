package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ZymDailiMapper;
import com.ruoyi.system.domain.ZymDaili;
import com.ruoyi.system.service.IZymDailiService;
import com.ruoyi.common.core.text.Convert;

/**
 * 代理费率Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
@Service
public class ZymDailiServiceImpl implements IZymDailiService 
{
    @Autowired
    private ZymDailiMapper zymDailiMapper;

    /**
     * 查询代理费率
     * 
     * @param id 代理费率主键
     * @return 代理费率
     */
    @Override
    public ZymDaili selectZymDailiById(Integer id)
    {
        return zymDailiMapper.selectZymDailiById(id);
    }

    /**
     * 查询代理费率列表
     * 
     * @param zymDaili 代理费率
     * @return 代理费率
     */
    @Override
    public List<ZymDaili> selectZymDailiList(ZymDaili zymDaili)
    {
        return zymDailiMapper.selectZymDailiList(zymDaili);
    }

    /**
     * 新增代理费率
     * 
     * @param zymDaili 代理费率
     * @return 结果
     */
    @Override
    public int insertZymDaili(ZymDaili zymDaili)
    {
        return zymDailiMapper.insertZymDaili(zymDaili);
    }

    /**
     * 修改代理费率
     * 
     * @param zymDaili 代理费率
     * @return 结果
     */
    @Override
    public int updateZymDaili(ZymDaili zymDaili)
    {
        return zymDailiMapper.updateZymDaili(zymDaili);
    }

    /**
     * 批量删除代理费率
     * 
     * @param ids 需要删除的代理费率主键
     * @return 结果
     */
    @Override
    public int deleteZymDailiByIds(String ids)
    {
        return zymDailiMapper.deleteZymDailiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除代理费率信息
     * 
     * @param id 代理费率主键
     * @return 结果
     */
    @Override
    public int deleteZymDailiById(Integer id)
    {
        return zymDailiMapper.deleteZymDailiById(id);
    }
}
