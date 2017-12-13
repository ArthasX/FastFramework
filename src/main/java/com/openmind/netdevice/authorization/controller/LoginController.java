package com.openmind.netdevice.authorization.controller;

import com.openmind.netdevice.authorization.model.User;
import com.openmind.netdevice.authorization.model.UserToken;
import com.openmind.netdevice.authorization.service.ILoginService;
import com.openmind.netdevice.framework.model.Result;
import com.openmind.netdevice.menu.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
@CrossOrigin(value = "*")
@RequestMapping(value = "/login")
@Controller
public class LoginController {

    @Autowired
    private ILoginService iLoginService;
    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "/")
    @ResponseBody
    public Result login(HttpSession httpSession, @RequestParam("account") String account
            , @RequestParam("password") String password) {
        User user = new User(account, password);
        Result result;

        try {
            user = iLoginService.select(user);
            if (user != null) {
                UserToken userToken = new UserToken();
//            userToken.setForward("/pages/index.html");
                userToken.setUser(user);
                userToken.setMenu(menuService.getDeptTreeMenu(user.getDeptId()));
                httpSession.setAttribute("userToken", userToken);
                result = Result.getSuccessResult("登录成功");
                result.setData(userToken);
            } else {
                result = Result.getFailureResult("登录失败");
            }
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return Result.getFailureResult("登录失败");
        }


    }
}
