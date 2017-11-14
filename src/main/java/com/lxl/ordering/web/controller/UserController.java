package com.lxl.ordering.web.controller;

import com.lxl.ordering.business.domain.Role;
import com.lxl.ordering.business.domain.RoleCheckBox;
import com.lxl.ordering.business.domain.UserInfo;
import com.lxl.ordering.business.domain.UserRole;
import com.lxl.ordering.business.service.RoleService;
import com.lxl.ordering.business.service.UserService;
import com.lxl.ordering.frame.base.BusinessException;
import com.lxl.ordering.frame.utils.DateUtil;
import com.lxl.ordering.frame.utils.PageUtils;
import com.lxl.ordering.frame.utils.Query;
import com.lxl.ordering.frame.utils.ResultVo;
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
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("user")
    public String user() {
        return "user/user";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageUtils searchAllList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<UserInfo> userInfoList = userService.getUserInfoAll(query);
        int count = userService.getUserInfoAllCount(query);
        return new PageUtils(userInfoList, count);
    }

    @RequestMapping("add")
    public String addUser() {
        return "user/add";
    }


    @RequestMapping("save")
    @ResponseBody
    public ResultVo saveUserInfo(UserInfo userInfo) {
        try {
            Boolean flag = userService.saveUserInfo(userInfo);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("edit/{id}")
    public String editUserInfo(@PathVariable("id") Integer id, Model model) {
        UserInfo userInfo = userService.getUserInfoByUserInfoId(id);
        model.addAttribute("user", userInfo);
        return "user/edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultVo updateUserInfo(UserInfo userInfo) {
        try {
            Boolean flag = userService.updateUserInfo(userInfo);
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
            UserInfo userInfo = userService.getUserInfoByUserInfoId(id);
            if (userInfo == null) return ResultVo.error(1, "要删除的菜单不存在");
            Boolean flag = userService.deleteUserInfo(id);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("batchRemove")
    @ResponseBody
    public ResultVo batchRemove(@RequestParam("ids[]") Integer[] userIds) {
        try {
            List<Integer> userIdList = Arrays.asList(userIds);
            Boolean flag = userService.batchDeleteUserInfo(userIdList);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("exists")
    @ResponseBody
    public Boolean exists(String userNumber) {
        UserInfo userInfo = userService.getUserInfoByUserNumber(userNumber);
        return userInfo == null;
    }

    @RequestMapping("author/{id}")
    public String author(@PathVariable("id") Integer id, Model model) {
        UserInfo userInfo = userService.getUserInfoByUserInfoId(id);
        model.addAttribute("user", userInfo);
        Map<String, List<RoleCheckBox>> appToRoleListMap = roleService.getAppToRoleMap(id);
        model.addAttribute("appToRoleList", appToRoleListMap);
        return "user/author";
    }

    @RequestMapping("authorization")
    @ResponseBody
    public ResultVo authorization(UserInfo userInfo, @RequestParam("roleIds") List<Integer> roleIds) {

        List<UserRole> userRoleList = new ArrayList<UserRole>();

        List<Role> roleList = roleService.getRoloListByRoleIds(roleIds);

        for (Role role : roleList) {
            UserRole userRole = new UserRole();
            userRole.setAppId(role.getAppId());
            userRole.setCreateTime(DateUtil.getCurrentTimespan());
            userRole.setUserId(userInfo.getId());
            userRole.setRoleId(role.getId());
            userRoleList.add(userRole);
        }

        try {

            userService.deleteUserRoleByUserId(userInfo.getId());

            userService.batchSaveUserRole(userRoleList);

            return ResultVo.ok();
        } catch (BusinessException e) {

        }

        return ResultVo.error();

    }

}
