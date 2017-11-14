package com.lxl.ordering.business.service.impl;

import com.lxl.ordering.business.dao.ApplicationMapper;
import com.lxl.ordering.business.dao.MenuMapper;
import com.lxl.ordering.business.dao.RoleMenuMapper;
import com.lxl.ordering.business.domain.Application;
import com.lxl.ordering.business.domain.Menu;
import com.lxl.ordering.business.domain.Tree;
import com.lxl.ordering.business.service.MenuService;
import com.lxl.ordering.frame.utils.BuildTree;
import com.lxl.ordering.frame.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
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
@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Menu> getMenuAll(Query query) {
        return menuMapper.selectAllList(query);
    }

    @Override
    public List<Menu> getMenuAllList() {
        return menuMapper.selectAll();
    }

    @Override
    public int getMenuAllCount(Query query) {
        return menuMapper.selectAllCount(query);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveMenu(Menu menu) {
        int count = menuMapper.insertSelective(menu);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateMenu(Menu menu) {
        int count = menuMapper.updateByPrimaryKeySelective(menu);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteMenu(Integer id) {
        int count = menuMapper.deleteById(id);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean batchDeleteMenu(List<Integer> menuIds) {
        return null;
    }

    @Override
    public Menu getMenuByMenuId(Integer menuId) {
        return menuMapper.selectMenuById(menuId);
    }

    @Override
    public List<Menu> getMenuListByAppId(Integer appId) {
        return menuMapper.selectMenuListByAppId(appId);
    }

    @Override
    public List<Menu> getMenuListByParentId(Integer menuId) {
        return menuMapper.selectMenuListByParentId(menuId);
    }

    @Override
    public Tree<Menu> getMenuTreeByAppId(Integer appId) {

        Application application = applicationMapper.selectByAppId(appId);

        List<Tree<Menu>> menuTreeList = new ArrayList<Tree<Menu>>();

        List<Menu> menuList = menuMapper.selectMenuListByAppId(appId);

        convertMenuToTree(menuTreeList, menuList);

        return BuildTree.build(menuTreeList, application.getTitle());

    }

    /**
     * 根据菜单转换成树结构
     * @param menuTreeList
     * @param menuList
     */
    private void convertMenuToTree(List<Tree<Menu>> menuTreeList, List<Menu> menuList) {
        for (Menu menu : menuList) {
            Tree<Menu> menuTree = new Tree<Menu>();
            menuTree.setId(menu.getId().toString());
            menuTree.setParentId(menu.getParentId().toString());
            menuTree.setText(menu.getName());
            Map<String, Object> attributes = new HashMap<String, Object>();
            attributes.put("url", menu.getUrl());
            menuTree.setAttributes(attributes);
            menuTreeList.add(menuTree);
        }
    }

    @Override
    public Tree<Menu> getMenuTree(Integer roleId, Integer appId) {
        Application application = applicationMapper.selectByAppId(appId);

        List<Tree<Menu>> menuTreeList = new ArrayList<Tree<Menu>>();

        List<Menu> menuList = menuMapper.selectMenuListByAppId(appId);

        List<Integer> menuIds = roleMenuMapper.selectMenuIdList(appId, roleId);

        for (Menu menu : menuList) {
            Tree<Menu> menuTree = new Tree<Menu>();
            menuTree.setId(menu.getId().toString());
            menuTree.setParentId(menu.getParentId().toString());
            menuTree.setText(menu.getName());
            Map<String, Object> state = new HashMap<String, Object>();
            if (menuIds.contains(menu.getId())) {
                state.put("selected", true);
            } else {
                state.put("selected", false);
            }
            menuTree.setState(state);
            menuTreeList.add(menuTree);
        }

        return BuildTree.build(menuTreeList, application.getTitle());
    }

    @Override
    public List<Tree<Menu>> getMenuTreeListByUserNumberAndAppKey(String userNumber, String appKey) {
        List<Tree<Menu>> trees = new ArrayList<Tree<Menu>>();
        final List<Menu> menuList = menuMapper.selectMenuListByUserNumberAndAppKey(userNumber, appKey);
        convertMenuToTree(trees, menuList);
        return BuildTree.buildList(trees, "0");
    }

    @Override
    public List<Menu> getMenuListByUserNumberAndAppKey(String userNumber, String appKey) {
        return menuMapper.selectMenuListByUserNumberAndAppKey(userNumber, appKey);
    }

    @Override
    public List<Menu> getMenuAllListByUserNumberAndAppKey(String userNumber, String appKey) {
        return menuMapper.selectMenuAllListByUserNumberAndAppKey(userNumber, appKey);
    }

}
