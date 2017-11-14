package com.lxl.ordering.web.controller;

import com.lxl.ordering.business.domain.Menu;
import com.lxl.ordering.business.domain.Tree;
import com.lxl.ordering.business.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>首页</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/9/29
 * @since 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("index")
    public String index(Model model) {
        List<Tree<Menu>> menus = menuService.getMenuTreeListByUserNumberAndAppKey("776364", "UPMS_SYSTEM_001");
        model.addAttribute("menus", menus);
        model.addAttribute("username", "776364-李晓亮");
        return "index";
    }

    @RequestMapping("main")
    public String main() {
        return "main";
    }
}
