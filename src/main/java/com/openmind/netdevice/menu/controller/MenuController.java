package com.openmind.netdevice.menu.controller;

import com.openmind.netdevice.authorization.model.User;
import com.openmind.netdevice.authorization.model.UserToken;
import com.openmind.netdevice.framework.model.Result;
import com.openmind.netdevice.menu.service.IMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiuBin
 * @version Created on 2017/9/5
 */
@CrossOrigin(origins = "*")
@RequestMapping(value = "/menus")
@Controller
public class MenuController {
    private static Logger logger = Logger.getLogger(MenuController.class);
    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "/")
    @ResponseBody
    public Result getDeptMenu(HttpSession httpSession){
        Result result;
        try {
//            UserToken userToken = (UserToken) httpSession.getAttribute("userToken");
            UserToken userToken =new UserToken();
            userToken.setMenu(menuService.getDeptTreeMenu(""));
            result = new Result();
            result.setData(userToken.getMenu());
        } catch (Throwable throwable) {
            logger.error("获取部门菜单失败",throwable);
            result = Result.getErrResult(throwable);
        }
        return result;
    }

    //TODO 后期增加根据所在机构显示具体的menu
}
