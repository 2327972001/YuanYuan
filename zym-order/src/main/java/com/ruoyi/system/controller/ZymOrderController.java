package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
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
import com.ruoyi.system.domain.ZymOrder;
import com.ruoyi.system.service.IZymOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单列表Controller
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@Controller
@RequestMapping("/order/management")
public class ZymOrderController extends BaseController
{
    private String prefix = "order/management";

    @Autowired
    private IZymOrderService zymOrderService;

    @RequiresPermissions("order:management:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询订单列表列表
     */
    @RequiresPermissions("order:management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZymOrder zymOrder)
    {
        SysUser sysUser = getSysUser();
        //判断是否为超级管理员
        if(!sysUser.getUserName().equals("admin") || sysUser.getRoles().get(0).getRoleId() != 1){
            PageDomain pageDomain = TableSupport.buildPageRequest();
            Integer pageNum = pageDomain.getPageNum();
            Integer pageSize = pageDomain.getPageSize();
            //过滤数据
            List<ZymOrder> list = zymOrderService.selectZymOrderList(zymOrder);
            List<ZymOrder> list1 = new ArrayList<>();
            for (ZymOrder zymOrder1 : list) {
                if(zymOrder1.getUserId().equals(sysUser.getUserId())){
                    list1.add(zymOrder1);
                }
            }
            //获取处理好的list集合
            int num = list1.size();
            list1 = list1.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            return getDataTableList(list1,num);
        }else{
            startPage();
            List<ZymOrder> list = zymOrderService.selectZymOrderList(zymOrder);
            return getDataTable(list);
        }
    }

    /**
     * 导出订单列表列表
     */
    @RequiresPermissions("order:management:export")
    @Log(title = "订单列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZymOrder zymOrder)
    {
        List<ZymOrder> list = zymOrderService.selectZymOrderList(zymOrder);
        ExcelUtil<ZymOrder> util = new ExcelUtil<ZymOrder>(ZymOrder.class);
        return util.exportExcel(list, "订单列表数据");
    }

    /**
     * 新增订单列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单列表
     */
    @RequiresPermissions("order:management:add")
    @Log(title = "订单列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZymOrder zymOrder)
    {
        return toAjax(zymOrderService.insertZymOrder(zymOrder));
    }

    /**
     * 修改订单列表
     */
    @RequiresPermissions("order:management:edit")
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Integer orderId, ModelMap mmap)
    {
        ZymOrder zymOrder = zymOrderService.selectZymOrderByOrderId(orderId);
        mmap.put("zymOrder", zymOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单列表
     */
    @RequiresPermissions("order:management:edit")
    @Log(title = "订单列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZymOrder zymOrder)
    {
        return toAjax(zymOrderService.updateZymOrder(zymOrder));
    }

    /**
     * 删除订单列表
     */
    @RequiresPermissions("order:management:remove")
    @Log(title = "订单列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zymOrderService.deleteZymOrderByOrderIds(ids));
    }
}
