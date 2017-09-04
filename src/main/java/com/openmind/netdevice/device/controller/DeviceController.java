package com.openmind.netdevice.device.controller;

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
public class DeviceController {


}
