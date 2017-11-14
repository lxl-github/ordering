package com.lxl.ordering.business.service.impl;

import com.lxl.ordering.business.dao.ApplicationMapper;
import com.lxl.ordering.business.domain.Application;
import com.lxl.ordering.business.service.AppService;
import com.lxl.ordering.frame.utils.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 2017/8/11
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class AppServiceImpl implements AppService {

    private static final Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public List<Application> getApplicationAll(Query query) {

        List<Application> applicationList = applicationMapper.selectAllList(query);

        return applicationList;

    }

    @Override
    public int getApplicationAllCount(Query query) {
        return applicationMapper.selectAllCount(query);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveApplication(Application application) {
        int count = applicationMapper.insertSelective(application);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateApplication(Application application) {
        int count = applicationMapper.updateByPrimaryKeySelective(application);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteApplcation(Integer appId) {
        int count = applicationMapper.deleteById(appId);
        if (count > 0) return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean batchDeleteApplcation(List<Integer> appIds) {
        int counter = 0;
        for (Integer appId : appIds) {
            int count = applicationMapper.deleteById(appId);
            counter += count;
        }
        if (counter == appIds.size()) return true;

        return false;
    }

    @Override
    public Application getApplicationByAppKey(String appKey) {
        return applicationMapper.selectByAppKey(appKey);
    }

    @Override
    public Application getApplicationByAppId(Integer appId) {
        return applicationMapper.selectByAppId(appId);
    }

    @Override
    public List<Application> getApplicationEnableList() {
        return applicationMapper.selectApplicationEnableList();
    }
}
