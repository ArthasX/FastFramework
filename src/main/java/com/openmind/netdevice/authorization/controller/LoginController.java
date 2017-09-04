package com.openmind.netdevice.authorization.controller;

import com.openmind.netdevice.authorization.service.ILoginService;
import com.openmind.netdevice.framework.model.Result;
import com.openmind.netdevice.authorization.model.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@RequestMapping(value = "/login")
@Controller
public class LoginController {

    @Autowired
    ILoginService iLoginService;

    @RequestMapping(value = "/")
    @ResponseBody
    public Result login(HttpSession httpSession, @RequestParam("account") String account
            , @RequestParam("password") String password) {

        if (iLoginService.login(account, password)) {
            UserToken userToken = new UserToken();
            httpSession.setAttribute("userToken", userToken);
            return Result.getSuccessResult("登录成功");
        } else {
            return Result.getFailureResult("登录失败");
        }

    }
}
