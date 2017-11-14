package com.lxl.ordering.business.dao;

import com.lxl.ordering.business.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {

    int insertSelective(UserInfo record);

    int updateByPrimaryKeySelective(UserInfo record);

    List<UserInfo> selectAllList(Map<String, Object> map);

    int selectAllCount(Map<String, Object> map);

    UserInfo selectUserInfoById(Integer id);

    int deleteById(Integer id);

    UserInfo selectUserInfoByUserNumber(String userNumber);

}