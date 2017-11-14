package com.lxl.ordering.business.dao;

import com.lxl.ordering.business.domain.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {

    int insertSelective(RoleMenu record);

    int updateByPrimaryKeySelective(RoleMenu record);

    List<Integer> selectMenuIdList(@Param("appId") Integer appId, @Param("roleId") Integer roleId);

    int deleteRoleMenu(@Param("appId") Integer appId, @Param("roleId") Integer roleId);

}