package com.openmind.netdevice.device.controller;

import com.openmind.netdevice.device.model.Port;
import com.openmind.netdevice.device.service.IPortService;
import com.openmind.netdevice.framework.controller.BaseController;
import com.openmind.netdevice.framework.model.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuBin
 * @version Created on 2017/9/7
 */
@RequestMapping(value = "/ports")
@RestController
public class PortController extends BaseController<IPortService, Port> {
    static Logger logger = Logger.getLogger(PortController.class);


}
