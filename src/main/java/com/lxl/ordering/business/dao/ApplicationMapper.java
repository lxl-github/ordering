package com.lxl.ordering.business.dao;

import com.lxl.ordering.business.domain.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ApplicationMapper {

    int insertSelective(Application record);

    int updateByPrimaryKeySelective(Application record);

    List<Application> selectAllList(Map<String,Object> map);

    int selectAllCount(Map<String,Object> map);

    Application selectByAppKey(@Param("appKey") String appKey);

    Application selectByAppId(@Param("appId") Integer appId);

    int deleteById(@Param("appId") Integer appId);

    List<Application> selectApplicationEnableList();
}