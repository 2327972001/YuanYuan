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
import com.ruoyi.system.domain.ZymGoods;
import com.ruoyi.system.service.IZymGoodsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品列表Controller
 * 
 * @author ruoyi
 * @date 2022-05-26
 */
@Controller
@RequestMapping("/goods/management")
public class ZymGoodsController extends BaseController
{
    private String prefix = "goods/management";

    @Autowired
    private IZymGoodsService zymGoodsService;

    @RequiresPermissions("goods:management:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询商品列表列表
     */
    @RequiresPermissions("goods:management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZymGoods zymGoods)
    {
        startPage();
        List<ZymGoods> list = zymGoodsService.selectZymGoodsList(zymGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品列表列表
     */
    @RequiresPermissions("goods:management:export")
    @Log(title = "商品列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZymGoods zymGoods)
    {
        List<ZymGoods> list = zymGoodsService.selectZymGoodsList(zymGoods);
        ExcelUtil<ZymGoods> util = new ExcelUtil<ZymGoods>(ZymGoods.class);
        return util.exportExcel(list, "商品列表数据");
    }

    /**
     * 新增商品列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品列表
     */
    @RequiresPermissions("goods:management:add")
    @Log(title = "商品列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZymGoods zymGoods)
    {
        return toAjax(zymGoodsService.insertZymGoods(zymGoods));
    }

    /**
     * 修改商品列表
     */
    @RequiresPermissions("goods:management:edit")
    @GetMapping("/edit/{goodsId}")
    public String edit(@PathVariable("goodsId") Integer goodsId, ModelMap mmap)
    {
        ZymGoods zymGoods = zymGoodsService.selectZymGoodsByGoodsId(goodsId);
        mmap.put("zymGoods", zymGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品列表
     */
    @RequiresPermissions("goods:management:edit")
    @Log(title = "商品列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZymGoods zymGoods)
    {
        return toAjax(zymGoodsService.updateZymGoods(zymGoods));
    }

    /**
     * 删除商品列表
     */
    @RequiresPermissions("goods:management:remove")
    @Log(title = "商品列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zymGoodsService.deleteZymGoodsByGoodsIds(ids));
    }
}
