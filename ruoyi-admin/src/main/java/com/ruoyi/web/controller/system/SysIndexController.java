package com.ruoyi.web.controller.system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysLogininfor;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.ZymDaili;
import com.ruoyi.system.domain.ZymOrder;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.ShiroConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.CookieUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private ISysNoticeService noticeService;

    @Autowired
    private IZymOrderService zymOrderService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private IZymDailiService dailiService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysLogininforService logininforService;


    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
        mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
        Boolean footer = Convert.toBool(configService.selectConfigByKey("sys.index.footer"), true);
        Boolean tagsView = Convert.toBool(configService.selectConfigByKey("sys.index.tagsView"), true);
        mmap.put("footer", footer);
        mmap.put("tagsView", tagsView);
        mmap.put("mainClass", contentMainClass(footer, tagsView));
        mmap.put("copyrightYear", RuoYiConfig.getCopyrightYear());
        mmap.put("demoEnabled", RuoYiConfig.isDemoEnabled());
        mmap.put("isDefaultModifyPwd", initPasswordIsModify(user.getPwdUpdateDate()));
        mmap.put("isPasswordExpired", passwordIsExpiration(user.getPwdUpdateDate()));
        mmap.put("isMobile", ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")));

        // 菜单导航显示风格
        String menuStyle = configService.selectConfigByKey("sys.index.menuStyle");
        // 移动端，默认使左侧导航菜单，否则取默认配置
        String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index" : menuStyle;

        // 优先Cookie配置导航菜单
        Cookie[] cookies = ServletUtils.getRequest().getCookies();
        for (Cookie cookie : cookies)
        {
            if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName()))
            {
                indexStyle = cookie.getValue();
                break;
            }
        }
        String webIndex = "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
        return webIndex;
    }

    // 锁定屏幕
    @GetMapping("/lockscreen")
    public String lockscreen(ModelMap mmap)
    {
        mmap.put("user", getSysUser());
        ServletUtils.getSession().setAttribute(ShiroConstants.LOCK_SCREEN, true);
        return "lock";
    }

    // 解锁屏幕
    @PostMapping("/unlockscreen")
    @ResponseBody
    public AjaxResult unlockscreen(String password)
    {
        SysUser user = getSysUser();
        if (StringUtils.isNull(user))
        {
            return AjaxResult.error("服务器超时，请重新登录");
        }
        if (passwordService.matches(user, password))
        {
            ServletUtils.getSession().removeAttribute(ShiroConstants.LOCK_SCREEN);
            return AjaxResult.success();
        }
        return AjaxResult.error("密码不正确，请重新输入。");
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin()
    {
        return "skin";
    }

    // 切换菜单
    @GetMapping("/system/menuStyle/{style}")
    public void menuStyle(@PathVariable String style, HttpServletResponse response)
    {
        CookieUtils.setCookie(response, "nav-style", style);
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        SysUser user = getSysUser();
        mmap.put("version", RuoYiConfig.getVersion());
        mmap.put("user", user);

        //获取公告
        List<SysNotice> noticeList = noticeService.selectNoticeList(new SysNotice());
        List<SysNotice> noticeList1 = new ArrayList<>();
        for (int i = 0; i < noticeList.size(); i++) {
            if(noticeList.get(i).getNoticeType().equals("2") && noticeList.get(i).getStatus().equals("0")){
                noticeList1.add(noticeList.get(i));
            }
        }
        //转化时间格式
        for (int i = 0; i < noticeList1.size(); i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String date = sdf.format(noticeList1.get(i).getCreateTime());
            noticeList1.get(i).setTime(date);
        }
        mmap.put("noticeList", noticeList1);

        //获取订单总数量
        List<ZymOrder> orderList = zymOrderService.selectZymOrderList(new ZymOrder());
        mmap.put("orderSize", orderList.size());

        //获取用户费率
        List<ZymDaili> dailis = dailiService.selectZymDailiList(new ZymDaili());
        for (int i = 0; i < dailis.size(); i++) {
            if(dailis.get(i).getDaili().equals(deptService.selectDeptById(user.getDeptId()).getDeptName())){
                mmap.put("daili_money",dailis.get(i).getMoney()+"%");
            }
        }
        if(mmap.get("daili_money")==null){
            mmap.put("daili_money","无");
        }

        //获取代理总数
        List<SysUser> users = userService.selectUserList(new SysUser());
        int dailisize = 0;
        for (int i = 0; i < users.size(); i++) {
            if(!deptService.selectDeptById(users.get(i).getDeptId()).getDeptName().equals("管理部门") && !deptService.selectDeptById(users.get(i).getDeptId()).getDeptName().equals("普通部门")){
                dailisize++;
            };
        }
        mmap.put("daili_size",dailisize);

        //判断今天注册的用户数量
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date zero = calendar.getTime();
        List<SysUser> users1 = userService.selectUserList(new SysUser());
        int zhuce = 0;
        for (int i = 0; i < users1.size(); i++) {
            if(users1.get(i).getCreateTime().getTime()>=zero.getTime()){
                zhuce++;
            }
        }
        mmap.put("zhuce",zhuce);

        //判断今天登录的用户数量
        List<SysLogininfor> loginLogs = logininforService.selectLogininforList(new SysLogininfor());
        List<String> userNames = new ArrayList<>();
        for (int i = 0; i < loginLogs.size(); i++) {
            if(loginLogs.get(i).getLoginTime().getTime()>=zero.getTime()){
                userNames.add(loginLogs.get(i).getLoginName());
            }
        }
        List<String> userNames1 = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            if(!userNames1.contains(userNames.get(i))){
                userNames1.add(userNames.get(i));
            }
        }
        mmap.put("denglu",userNames1.size());


        return "zym_main";
    }

    // content-main class
    public String contentMainClass(Boolean footer, Boolean tagsView)
    {
        if (!footer && !tagsView)
        {
            return "tagsview-footer-hide";
        }
        else if (!footer)
        {
            return "footer-hide";
        }
        else if (!tagsView)
        {
            return "tagsview-hide";
        }
        return StringUtils.EMPTY;
    }

    // 检查初始密码是否提醒修改
    public boolean initPasswordIsModify(Date pwdUpdateDate)
    {
        Integer initPasswordModify = Convert.toInt(configService.selectConfigByKey("sys.account.initPasswordModify"));
        return initPasswordModify != null && initPasswordModify == 1 && pwdUpdateDate == null;
    }

    // 检查密码是否过期
    public boolean passwordIsExpiration(Date pwdUpdateDate)
    {
        Integer passwordValidateDays = Convert.toInt(configService.selectConfigByKey("sys.account.passwordValidateDays"));
        if (passwordValidateDays != null && passwordValidateDays > 0)
        {
            if (StringUtils.isNull(pwdUpdateDate))
            {
                // 如果从未修改过初始密码，直接提醒过期
                return true;
            }
            Date nowDate = DateUtils.getNowDate();
            return DateUtils.differentDaysByMillisecond(nowDate, pwdUpdateDate) > passwordValidateDays;
        }
        return false;
    }
}
