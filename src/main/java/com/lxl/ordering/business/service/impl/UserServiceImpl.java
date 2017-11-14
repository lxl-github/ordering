package com.lxl.ordering.business.service.impl;

import com.lxl.ordering.business.dao.UserInfoMapper;
import com.lxl.ordering.business.dao.UserRoleMapper;
import com.lxl.ordering.business.domain.UserInfo;
import com.lxl.ordering.business.domain.UserRole;
import com.lxl.ordering.business.service.UserService;
import com.lxl.ordering.frame.base.BusinessException;
import com.lxl.ordering.frame.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @date 2017/8/15
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserInfo> getUserInfoAll(Query query) {
        return userInfoMapper.selectAllList(query);
    }

    @Override
    public int getUserInfoAllCount(Query query) {
        return userInfoMapper.selectAllCount(query);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveUserInfo(UserInfo userInfo) {
        int count = userInfoMapper.insertSelective(userInfo);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateUserInfo(UserInfo userInfo) {
        int count = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteUserInfo(Integer id) {
        int count = userInfoMapper.deleteById(id);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean batchDeleteUserInfo(List<Integer> userIds) {
        return null;
    }

    @Override
    public UserInfo getUserInfoByUserInfoId(Integer userId) {
        return userInfoMapper.selectUserInfoById(userId);
    }

    @Override
    public UserInfo getUserInfoByUserNumber(String userNumber) {
        return userInfoMapper.selectUserInfoByUserNumber(userNumber);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean batchSaveUserRole(List<UserRole> userRoleList) {

        int count = 0;

        for (UserRole userRole : userRoleList) {

            int cnt = userRoleMapper.insertSelective(userRole);

            if (cnt > 0) {
                count++;
            } else {
                throw new BusinessException("保存用户角色关系异常");
            }

        }
        if (userRoleList.size() == count) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteUserRoleByUserId(Integer userId) {
        int cnt = userRoleMapper.deleteUserRoleByUserId(userId);
        if (cnt > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Integer> getRoleIdByUserId(Integer userId) {
        return userRoleMapper.selectRoleIdByUserId(userId);
    }

    @Override
    public List<UserRole> getUserRoleByUserIdAndAppId(Integer userId, Integer appId) {
        return userRoleMapper.selectUserRoleByUserIdAndAppId(userId, appId);
    }
}
