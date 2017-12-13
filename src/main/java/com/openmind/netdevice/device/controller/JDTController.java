package com.openmind.netdevice.device.controller;

import com.openmind.netdevice.device.model.JointDeviceType;
import com.openmind.netdevice.device.service.IJointDeviceTypeService;
import com.openmind.netdevice.framework.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuBin
 * @version Created on 2017/9/7
 */
@RequestMapping(value = "/jointdevicetype")
@RestController
public class JDTController extends BaseController<IJointDeviceTypeService,JointDeviceType> {
}
