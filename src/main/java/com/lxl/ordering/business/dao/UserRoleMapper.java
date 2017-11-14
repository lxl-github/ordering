package com.lxl.ordering.business.dao;

import com.lxl.ordering.business.domain.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {

    int insertSelective(UserRole record);

    int updateByPrimaryKeySelective(UserRole record);

    List<Integer>  selectRoleIdByUserId(Integer userId);

    List<UserRole> selectUserRoleByUserIdAndAppId(@Param("userId") Integer userId, @Param("appId") Integer appId);

    int deleteUserRoleByUserId(Integer userId);
}