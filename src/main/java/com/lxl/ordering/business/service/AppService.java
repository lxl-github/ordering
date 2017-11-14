package com.lxl.ordering.business.service;

import com.lxl.ordering.business.domain.Application;
import com.lxl.ordering.frame.utils.Query;

import java.util.List;

/**
 * <p>应用系统管理业务</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/8/11
 * @since 1.0
 */
public interface AppService {

    /**
     * 查询应用系统列表
     * @return
     */
    List<Application> getApplicationAll(Query query);

    /**
     * 根据条件查询总记录数
     * @param query
     * @return
     */
    int getApplicationAllCount(Query query);

    /**
     * 保存应用系统
     * @param application
     * @return
     */
    Boolean saveApplication(Application application);

    /**
     * 修改应用系统
     * @param application
     * @return
     */
    Boolean updateApplication(Application application);

    /**
     * 删除应用系统
     * @param appId
     * @return
     */
    Boolean deleteApplcation(Integer appId);

    /**
     * 批量删除应用系统
     * @param appIds
     * @return
     */
    Boolean batchDeleteApplcation(List<Integer> appIds);

    /**
     * 根据应用key查询应用系统信息
     * @param appKey
     * @return
     */
    Application getApplicationByAppKey(String appKey);


    /**
     * 根据应用id查询应用系统信息
     * @param appId
     * @return
     */
    Application getApplicationByAppId(Integer appId);

    /**
     * 获取所有启用的应用系统
     * @return
     */
    List<Application> getApplicationEnableList();
}
