package com.lxl.ordering.web.controller;

import com.lxl.ordering.business.domain.Application;
import com.lxl.ordering.business.service.AppService;
import com.lxl.ordering.frame.utils.PageUtils;
import com.lxl.ordering.frame.utils.Query;
import com.lxl.ordering.frame.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
 * @date 2017/9/29
 * @since 1.0
 */
@Controller
@RequestMapping("app")
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AppService appService;

    @RequestMapping("app")
    public String app() {
        return "app/app";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageUtils searchAllList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Application> applicationList = appService.getApplicationAll(query);
        int count = appService.getApplicationAllCount(query);
        return new PageUtils(applicationList, count);
    }

    @RequestMapping("add")
    public String addApp() {
        return "app/add";
    }


    @RequestMapping("save")
    @ResponseBody
    public ResultVo saveApp(Application application) {
        try {
            Boolean flag = appService.saveApplication(application);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("edit/{id}")
    public String editApp(@PathVariable("id") Integer id, Model model) {
        Application application = appService.getApplicationByAppId(id);
        model.addAttribute("app", application);
        return "app/edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultVo updateApp(Application application) {
        try {
            Boolean flag = appService.updateApplication(application);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("remove")
    @ResponseBody
    public ResultVo remove(Integer id) {
        try {
            Application application = appService.getApplicationByAppId(id);
            if (application == null) return ResultVo.error(1, "要删除的应用系统不存在");
            //检测应用系统下是否存在菜单资源，存在则不能删除
            Boolean flag = appService.deleteApplcation(id);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }

    @RequestMapping("batchRemove")
    @ResponseBody
    public ResultVo batchRemove(@RequestParam("ids[]") Integer[] appIds) {
        try {
            List<Integer> appIdList = Arrays.asList(appIds);
            Boolean flag = appService.batchDeleteApplcation(appIdList);
            if (flag) return ResultVo.ok();
        } catch (Exception e) {
            logger.error("系统出错", e);
        }
        return ResultVo.error();
    }
}
