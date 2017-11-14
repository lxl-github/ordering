package com.lxl.ordering.business.dao;

import com.lxl.ordering.business.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    int insertSelective(Role record);

    int updateByPrimaryKeySelective(Role record);

    List<Role> selectAllList(Map<String,Object> map);

    int selectAllCount(Map<String, Object> map);

    Role selectRoleById(Integer id);

    int deleteById(Integer id);

    List<Role> selectRoleListByAppId(Integer appId);

    List<Role> selectRoleListByRoleIdList(@Param("roleIdList") List<Integer> roleIdList);

    List<Role> selectRoleAllByUserNumberAndAppKey(@Param("userNumber") String userNumber, @Param("appKey") String appKey);

}