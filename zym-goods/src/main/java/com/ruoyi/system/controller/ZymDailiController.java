package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ZymDaili;
import com.ruoyi.system.service.IZymDailiService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 代理费率Controller
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
@Controller
@RequestMapping("/daili/manage")
public class ZymDailiController extends BaseController
{
    private String prefix = "daili/manage";

    @Autowired
    private IZymDailiService zymDailiService;

    @RequiresPermissions("daili:manage:view")
    @GetMapping()
    public String manage()
    {
        return prefix + "/manage";
    }

    /**
     * 查询代理费率列表
     */
    @RequiresPermissions("daili:manage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZymDaili zymDaili)
    {
        startPage();
        List<ZymDaili> list = zymDailiService.selectZymDailiList(zymDaili);
        return getDataTable(list);
    }

    /**
     * 导出代理费率列表
     */
    @RequiresPermissions("daili:manage:export")
    @Log(title = "代理费率", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZymDaili zymDaili)
    {
        List<ZymDaili> list = zymDailiService.selectZymDailiList(zymDaili);
        ExcelUtil<ZymDaili> util = new ExcelUtil<ZymDaili>(ZymDaili.class);
        return util.exportExcel(list, "代理费率数据");
    }

    /**
     * 新增代理费率
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存代理费率
     */
    @RequiresPermissions("daili:manage:add")
    @Log(title = "代理费率", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZymDaili zymDaili)
    {
        return toAjax(zymDailiService.insertZymDaili(zymDaili));
    }

    /**
     * 修改代理费率
     */
    @RequiresPermissions("daili:manage:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        ZymDaili zymDaili = zymDailiService.selectZymDailiById(id);
        mmap.put("zymDaili", zymDaili);
        return prefix + "/edit";
    }

    /**
     * 修改保存代理费率
     */
    @RequiresPermissions("daili:manage:edit")
    @Log(title = "代理费率", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZymDaili zymDaili)
    {
        return toAjax(zymDailiService.updateZymDaili(zymDaili));
    }

    /**
     * 删除代理费率
     */
    @RequiresPermissions("daili:manage:remove")
    @Log(title = "代理费率", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zymDailiService.deleteZymDailiByIds(ids));
    }
}
