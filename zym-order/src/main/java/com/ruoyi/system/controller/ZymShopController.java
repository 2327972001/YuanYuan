package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ZymGoods;
import com.ruoyi.system.domain.ZymOrder;
import com.ruoyi.system.service.IZymGoodsService;
import com.ruoyi.system.service.IZymOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ZouYangMing
 * @date 2020-05-28
 * @description 下单页面
 */
@Controller
@RequestMapping("/order/shop")
public class ZymShopController extends BaseController {
    private String prefix = "order/management";

    @Autowired
    private IZymOrderService zymOrderService;

    @Autowired
    private IZymGoodsService zymGoodsService;

    @RequiresPermissions("order:shop:view")
    @GetMapping()
    public String management(ModelMap mmap)
    {
        mmap.put("GoodsList",zymGoodsService.selectZymGoodsList(new ZymGoods()));
        return prefix + "/shop";
    }

    /**
     * 新增订单
     */
    @RequiresPermissions("order:shop:add")
    @Log(title = "提交订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZymOrder zymOrder)
    {
        System.out.println("提交订单");
        System.out.println(zymOrder);
        return toAjax(1);//toAjax(zymOrderService.insertZymOrder(zymOrder));
    }

}
