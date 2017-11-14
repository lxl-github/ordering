package com.lxl.ordering.business.service;


import com.lxl.ordering.business.domain.UserInfo;
import com.lxl.ordering.business.domain.UserRole;
import com.lxl.ordering.frame.utils.Query;

import java.util.List;

/**
 * <p>用户管理业务</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/8/15
 * @since 1.0
 */
public interface UserService {

    /**
     * 查询用户列表
     * @return
     */
    List<UserInfo> getUserInfoAll(Query query);

    /**
     * 根据条件查询总记录数
     * @param query
     * @return
     */
    int getUserInfoAllCount(Query query);

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    Boolean saveUserInfo(UserInfo userInfo);

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    Boolean updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Boolean deleteUserInfo(Integer id);

    /**
     * 批量删除用户
     * @param userIds
     * @return
     */
    Boolean batchDeleteUserInfo(List<Integer> userIds);


    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    UserInfo getUserInfoByUserInfoId(Integer userId);

    /**
     * 根据工号查询是否存在
     * @param userNumber
     * @return
     */
    UserInfo getUserInfoByUserNumber(String userNumber);

    /**
     * 批量保存用户角色关系
     * @param userRoleList
     * @return
     */
    Boolean batchSaveUserRole(List<UserRole> userRoleList);

    /**
     * 根据用户id删除角色关系
     * @param userId
     * @return
     */
    Boolean deleteUserRoleByUserId(Integer userId);

    /**
     * 根据用户id查询用户角色id
     * @param userId
     * @return
     */
    List<Integer> getRoleIdByUserId(Integer userId);

    /**
     *
     * @param userId
     * @param appId
     * @return
     */
    List<UserRole> getUserRoleByUserIdAndAppId(Integer userId, Integer appId);

}
