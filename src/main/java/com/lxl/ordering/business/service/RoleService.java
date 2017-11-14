package com.lxl.ordering.business.service;

import com.lxl.ordering.business.domain.*;
import com.lxl.ordering.frame.utils.Query;

import java.util.List;
import java.util.Map;

/**
 * <p>角色管理业务</p>
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
public interface RoleService {

    /**
     * 查询角色列表
     * @return
     */
    List<Role> getRoleAll(Query query);

    /**
     * 根据条件查询总记录数
     * @param query
     * @return
     */
    int getRoleAllCount(Query query);

    /**
     * 保存角色
     * @param role
     * @return
     */
    Boolean saveRole(Role role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    Boolean updateRole(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Boolean deleteRole(Integer id);

    /**
     * 批量删除角色
     * @param roleIds
     * @return
     */
    Boolean batchDeleteRole(List<Integer> roleIds);


    /**
     * 根据id查询角色
     * @param roleId
     * @return
     */
    Role getRoleByRoleId(Integer roleId);

    /**
     * 保存系统与角色与权限关系
     * @param roleMenuList
     * @return
     */
    Boolean saveRoleMenu(List<RoleMenu> roleMenuList);

    /**
     * 根据应用系统id和角色id删除关系
     * @param roleId
     * @param appId
     * @return
     */
    Boolean deleteRoleMenu(Integer roleId, Integer appId);

    /**
     * 获取所有角色树形结构
     * @return
     */
    Tree<RoleTree> getRoleTree();

    /**
     * 获取所有启用系统对应的角色关系
     * @return
     */
    Map<String, List<RoleCheckBox>> getAppToRoleMap(Integer userId);

    /**
     * 根据批量角色id查询角色列表
     * @param roleIdList
     * @return
     */
    List<Role> getRoloListByRoleIds(List<Integer> roleIdList);

    /**
     * 根据用户工号与应用系统key查询所属角色(用于外部接口)
     * @param userNumber
     * @param appKey
     * @return
     */
    List<Role> getRoleAllByUserNumberAndAppKey(String userNumber,String appKey);
}
