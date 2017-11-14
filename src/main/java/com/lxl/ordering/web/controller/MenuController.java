package com.lxl.ordering.web.controller;

import com.lxl.ordering.business.domain.Application;
import com.lxl.ordering.business.domain.Menu;
import com.lxl.ordering.business.domain.Tree;
import com.lxl.ordering.business.service.AppService;
import com.lxl.ordering.business.service.MenuService;
import com.lxl.ordering.frame.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>功能描述信息</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/9/30
 * @since 1.0
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private AppService appService;

    @RequestMapping("menu")
    public String menu() {
        return "menu/menu";
    }

//    @RequestMapping("list")
//    @ResponseBody
//    public PageUtils searchAllList(@RequestParam Map<String, Object> params) {
//        Query query = new Query(params);
//        List<Menu> menuList = menuService.getMenuAll(query);
//        int count = menuService.getMenuAllCount(query);
//        return new PageUtils(menuList, count);
//    }

    @RequestMapping("list")
    @ResponseBody
    public List<Menu> searchAllList() {
        List<Menu> menuList = menuService.getMenuAllList();
        return menuList;
    }

    @GetMapping("/add/{pId}")
    public String addMenu(Model model, @PathVariable("pId") Integer pId) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            Menu menu = menuService.getMenuByMenuId(pId);
            model.addAttribute("pName", menu.getName());
            model.addAttribute("appId", menu.getAppId());
            model.addAttribute("type", menu.getType());
        }
        List<Application> applicationList = appService.getApplicationEnableList();
        model.addAttribute("applicationList", applicationList);
        return "menu/add";
    }


    @RequestMapping("save")
    @ResponseBody
    public ResultVo saveMenu(Menu menu) {
        try {
            Boolean flag = menuService.saveMenu(menu);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("edit/{id}")
    public String editMenu(@PathVariable("id") Integer id, Model model) {
        Menu menu = menuService.getMenuByMenuId(id);
        model.addAttribute("menu", menu);
        if (menu.getParentId() != null && menu.getParentId() != 0) {
            Menu parentMenu = menuService.getMenuByMenuId(menu.getParentId());
            model.addAttribute("pName", parentMenu.getName());
            model.addAttribute("type", parentMenu.getType());
        }
        List<Application> applicationList = appService.getApplicationEnableList();
        model.addAttribute("applicationList", applicationList);
        return "menu/edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultVo updateMenu(Menu menu) {
        try {
            Boolean flag = menuService.updateMenu(menu);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("remove")
    @ResponseBody
    public ResultVo remove(Integer id) {
        try {
            Menu menu = menuService.getMenuByMenuId(id);
            if (menu == null) return ResultVo.error(1, "要删除的菜单不存在");
            List<Menu> menuList = menuService.getMenuListByParentId(id);
            if (!CollectionUtils.isEmpty(menuList)) return ResultVo.error(1, "请先删除子项菜单");
            Boolean flag = menuService.deleteMenu(id);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("batchRemove")
    @ResponseBody
    public ResultVo batchRemove(@RequestParam("ids[]") Integer[] menuIds) {
        try {
            List<Integer> menuIdList = Arrays.asList(menuIds);
            Boolean flag = menuService.batchDeleteMenu(menuIdList);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("isButtonLevel/{pId}")
    @ResponseBody
    public Boolean isButtonLevel(@PathVariable("pId") Integer pId){
        if (pId == null || pId == 0) return false;
        Menu menu = menuService.getMenuByMenuId(pId);
        if (menu.getType() == 3) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("tree/{appId}")
    @ResponseBody
    public Tree<Menu> getMenuTree(@PathVariable("appId") Integer appId) {
        return menuService.getMenuTreeByAppId(appId);
    }

    @RequestMapping("tree/{appId}/{roleId}")
    @ResponseBody
    public Tree<Menu> getMenuTree(@PathVariable("appId") Integer appId, @PathVariable("roleId") Integer roleId) {
        return menuService.getMenuTree(roleId, appId);
    }


}
