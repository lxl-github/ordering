package com.lxl.ordering;

import com.lxl.ordering.bootstrap.StartApplication;
import com.lxl.ordering.business.domain.Application;
import com.lxl.ordering.business.service.AppService;
import com.lxl.ordering.frame.utils.JsonUtils;
import com.lxl.ordering.frame.utils.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.LinkedHashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApplication.class)
@WebAppConfiguration
public class AppServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(AppServiceTests.class);

    @Autowired
    private AppService appService;


    @Test
    public void getApplicationAllList() {
        Query query = new Query(new LinkedHashMap<String, Object>());
        List<Application> pageInfo = appService.getApplicationAll(query);

        logger.info(JsonUtils.toJson(pageInfo));
    }

    @Test
    public void saveApplication() {
		Application application = new Application();
        application.setName("somp");
        application.setAppKey("SYSTEM-001");
        application.setBasePath("http://somp.sfbest.cn");
        application.setIcon("");
        application.setTitle("门店运营管理平台");
        application.setDescription("门店运营管理平台");
        application.setOrders(1);
        application.setStatus(1);

        Boolean flag = appService.saveApplication(application);

        logger.info("应用系统保存结果：{}", flag);
    }

}
