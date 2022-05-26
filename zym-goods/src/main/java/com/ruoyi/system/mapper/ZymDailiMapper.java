package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ZymDaili;

/**
 * 代理费率Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
public interface ZymDailiMapper 
{
    /**
     * 查询代理费率
     * 
     * @param id 代理费率主键
     * @return 代理费率
     */
    public ZymDaili selectZymDailiById(Integer id);

    /**
     * 查询代理费率列表
     * 
     * @param zymDaili 代理费率
     * @return 代理费率集合
     */
    public List<ZymDaili> selectZymDailiList(ZymDaili zymDaili);

    /**
     * 新增代理费率
     * 
     * @param zymDaili 代理费率
     * @return 结果
     */
    public int insertZymDaili(ZymDaili zymDaili);

    /**
     * 修改代理费率
     * 
     * @param zymDaili 代理费率
     * @return 结果
     */
    public int updateZymDaili(ZymDaili zymDaili);

    /**
     * 删除代理费率
     * 
     * @param id 代理费率主键
     * @return 结果
     */
    public int deleteZymDailiById(Integer id);

    /**
     * 批量删除代理费率
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZymDailiByIds(String[] ids);
}
