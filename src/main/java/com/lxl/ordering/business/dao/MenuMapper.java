package com.lxl.ordering.business.dao;

import com.lxl.ordering.business.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    int insertSelective(Menu record);

    int updateByPrimaryKeySelective(Menu record);

    List<Menu> selectAllList(Map<String, Object> map);

    List<Menu> selectAll();

    int selectAllCount(Map<String, Object> map);

    Menu selectMenuById(Integer id);

    List<Menu> selectMenuListByAppId(Integer appId);

    int deleteById(Integer id);

    List<Menu> selectMenuListByParentId(Integer menuId);

    List<Menu> selectMenuListByUserNumberAndAppKey(@Param("userNumber") String userNumber, @Param("appKey") String appKey);

    List<Menu> selectMenuAllListByUserNumberAndAppKey(@Param("userNumber") String userNumber, @Param("appKey") String appKey);

}