package com.lxl.ordering.web.controller;

import com.lxl.ordering.business.domain.*;
import com.lxl.ordering.business.service.AppService;
import com.lxl.ordering.business.service.MenuService;
import com.lxl.ordering.business.service.RoleService;
import com.lxl.ordering.frame.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
@RequestMapping("role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private AppService appService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("role")
    public String role() {
        return "role/role";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageUtils searchAllList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Role> roleList = roleService.getRoleAll(query);
        int count = roleService.getRoleAllCount(query);
        return new PageUtils(roleList, count);
    }

    @RequestMapping("add")
    public String addRole(Model model) {
        List<Application> applicationList = appService.getApplicationEnableList();
        model.addAttribute("applicationList", applicationList);
        return "role/add";
    }


    @RequestMapping("save")
    @ResponseBody
    public ResultVo saveRole(Role role) {
        try {
            Boolean flag = roleService.saveRole(role);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("edit/{id}")
    public String editRole(@PathVariable("id") Integer id, Model model) {
        Role role = roleService.getRoleByRoleId(id);
        model.addAttribute("role", role);
        List<Application> applicationList = appService.getApplicationEnableList();
        model.addAttribute("applicationList", applicationList);
        return "role/edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultVo updateRole(Role role) {
        try {
            Boolean flag = roleService.updateRole(role);
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
            Role role = roleService.getRoleByRoleId(id);
            if (role == null) return ResultVo.error(1, "要删除的菜单不存在");
            Boolean flag = roleService.deleteRole(id);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("batchRemove")
    @ResponseBody
    public ResultVo batchRemove(@RequestParam("ids[]") Integer[] roleIds) {
        try {
            List<Integer> roleIdList = Arrays.asList(roleIds);
            Boolean flag = roleService.batchDeleteRole(roleIdList);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("permis/{roleId}/{appId}")
    public String permis(@PathVariable("roleId") Integer roleId, @PathVariable("appId") Integer appId, Model model) {
        Role role = roleService.getRoleByRoleId(roleId);
        Application application = appService.getApplicationByAppId(appId);
        model.addAttribute("role", role);
        model.addAttribute("app", application);
        return "role/permis";
    }

    @RequestMapping("setPermis")
    @ResponseBody
    public ResultVo setPermis(RoleMenu roleMenu, @RequestParam("menuIds") List<Integer> menuIds){

        List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();

        for (Integer menuId : menuIds) {
            if (menuId == -1) continue;
            RoleMenu roleMenuChild = new RoleMenu();
            roleMenuChild.setAppId(roleMenu.getAppId());
            roleMenuChild.setRoleId(roleMenu.getRoleId());
            roleMenuChild.setCreateTime(DateUtil.getCurrentTimespan());
            roleMenuChild.setMenuId(menuId);
            roleMenuList.add(roleMenuChild);
        }

        try {

            roleService.deleteRoleMenu(roleMenu.getRoleId(), roleMenu.getAppId());

            Boolean f = roleService.saveRoleMenu(roleMenuList);

            if (f) {
                return ResultVo.ok();
            } else {
                return ResultVo.error(1, "保存失败");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ResultVo.error();
    }

    @RequestMapping("roleTree")
    @ResponseBody
    public Tree<RoleTree> getRoleTree(){
        return  roleService.getRoleTree();
    }
}
