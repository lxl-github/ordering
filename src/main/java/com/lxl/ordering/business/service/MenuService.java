package com.lxl.ordering.business.service;

import com.lxl.ordering.business.domain.Menu;
import com.lxl.ordering.business.domain.Tree;
import com.lxl.ordering.frame.utils.Query;

import java.util.List;

/**
 * <p>菜单资源管理业务</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/9/28
 * @since 1.0
 */
public interface MenuService {

    /**
     * 查询菜单列表
     * @return
     */
    List<Menu> getMenuAll(Query query);

    /**
     * 查询所有菜单列表
     * @return
     */
    List<Menu> getMenuAllList();

    /**
     * 根据条件查询总记录数
     * @param query
     * @return
     */
    int getMenuAllCount(Query query);

    /**
     * 保存菜单
     * @param menu
     * @return
     */
    Boolean saveMenu(Menu menu);

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    Boolean updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    Boolean deleteMenu(Integer id);

    /**
     * 批量删除菜单
     * @param menuIds
     * @return
     */
    Boolean batchDeleteMenu(List<Integer> menuIds);


    /**
     * 根据id查询菜单信息
     * @param menuId
     * @return
     */
    Menu getMenuByMenuId(Integer menuId);

    /**
     * 根据应用id查询菜单
     * @param appId
     * @return
     */
    List<Menu> getMenuListByAppId(Integer appId);

    /**
     * 根据父级菜单id查询子菜单
     * @param menuId
     * @return
     */
    List<Menu> getMenuListByParentId(Integer menuId);

    /**
     * 根据应用id查询树形菜单
     * @param appId
     * @return
     */
    Tree<Menu> getMenuTreeByAppId(Integer appId);

    /**
     * 根据应用id和角色id查询树形菜单
     * @param appId
     * @param roleId
     * @return
     */
    Tree<Menu> getMenuTree(Integer roleId, Integer appId);

    /**
     * 根据用户工号和应用系统key查询所属菜单树
     * @param userNumber
     * @param appKey
     * @return
     */
    List<Tree<Menu>> getMenuTreeListByUserNumberAndAppKey(String userNumber, String appKey);

    /**
     * 根据用户工号与应用系统key查询所属目录与菜单(提供外部接口)
     * @param userNumber
     * @param appKey
     * @return
     */
    List<Menu> getMenuListByUserNumberAndAppKey(String userNumber, String appKey);

    /**
     * 根据用户工号与应用系统key查询所属权限(提供外部接口)
     * @param userNumber
     * @param appKey
     * @return
     */
    List<Menu> getMenuAllListByUserNumberAndAppKey(String userNumber, String appKey);
}
